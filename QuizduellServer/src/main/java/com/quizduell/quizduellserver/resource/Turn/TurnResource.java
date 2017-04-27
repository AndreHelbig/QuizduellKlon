/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.resource.Turn;

import com.quizduell.quizduellserver.core.Manager;
import com.quizduell.quizduellserver.domain.Answer;
import com.quizduell.quizduellserver.domain.Duel;
import com.quizduell.quizduellserver.domain.Question;
import com.quizduell.quizduellserver.domain.Turn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Andre
 */
public class TurnResource extends ServerResource {
    private EntityManager entityManager = Manager.getEntityManager();

    @Get
    public JacksonRepresentation index() {
        EntityManager entityManager = Manager.getEntityManager();
        Query query = entityManager.createQuery("SELECT m FROM Turn m", Turn.class);
        List<Turn> turnList = query.getResultList();

        TurnListJson turnListJson = new TurnListJson();
        turnListJson.turns = new TurnJson[turnList.size()];

        for (int i = 0; i < turnList.size(); i++) {
            turnListJson.turns[i] = TurnJson.fromTurn(turnList.get(i));
        }

        return new JacksonRepresentation(turnListJson);
    }

    @Post("json")
    public void create(CreateTurnJson createTurnJson) {
        Query query = entityManager.createQuery("SELECT m FROM Duel m WHERE uuid = :uuid", Duel.class);
        query.setParameter("uuid", createTurnJson.duelUuid);
        Duel duel = (Duel) query.getSingleResult();

        Turn turn = new Turn();
        turn.setDuel(duel);
        turn.setFirstPlayer(duel.getPlayer1());
        turn.setSecondPlayer(duel.getPlayer2());

        entityManager.getTransaction().begin();
        entityManager.persist(turn);
        entityManager.getTransaction().commit();
        createQuestion(
                turn,
                "In welchem Bundesland befindet sich Karlsruhe?",
                "Baden-Württemberg",
                "Hessen",
                "Bayern",
                "Sachsen-Anhalt"
        );
        createQuestion(
                turn,
                "In welcher Straße befindet sich die DHBW Karlsruhe?",
                "Erzbergerstraße",
                "Kaiserstraße",
                "Kriegsstraße",
                "Poststraße"
        );
        createQuestion(
                turn,
                "Welche Farben hat das DHBW Logo?",
                "Rot und grau",
                "Blau und grau",
                "Gelb und orange",
                "Grün und rot"
        );
    }

    private void createQuestion(Turn turn, String questionText, String rightAnswerText, String wrongAnswerText1, String wrongAnswerText2, String wrongAnswerText3) {
        Question question = new Question();
        question.setTurn(turn);
        question.setText(questionText);
        entityManager.getTransaction().begin();
        entityManager.persist(question);
        entityManager.getTransaction().commit();
        createAnswer(question, rightAnswerText, true);
        createAnswer(question, wrongAnswerText1, false);
        createAnswer(question, wrongAnswerText2, false);
        createAnswer(question, wrongAnswerText3, false);
    }

    private Answer createAnswer(Question question, String text, boolean isRight) {
        Answer answer = new Answer();
        answer.setQuestion(question);
        answer.setText(text);
        answer.setRight(isRight);
        entityManager.getTransaction().begin();
        entityManager.persist(answer);
        entityManager.getTransaction().commit();
        return answer;
    }
}
