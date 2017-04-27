/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.resource.Answer;

import com.quizduell.quizduellserver.core.Manager;
import com.quizduell.quizduellserver.domain.Answer;
import com.quizduell.quizduellserver.domain.Duel;
import com.quizduell.quizduellserver.domain.Player;
import com.quizduell.quizduellserver.domain.Turn;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import org.restlet.resource.Post;
import org.restlet.resource.ServerResource;

/**
 *
 * @author Andre
 */
public class AnswerResource extends ServerResource {
    
    @Post
    public boolean createAnswerValidation(AnswerValidationJson jsonObject) {

        int turnIndex = jsonObject.turnNumber;

        Duel duel;
        Answer answer;
        Player player;

        String duelCondition = "'" + jsonObject.duelUUID + "'";
        String answerCondition = "'" + jsonObject.answerUUID + "'";
        String playerCondition = "'" + jsonObject.playerUUID + "'";

        EntityManager entityManager = Manager.getEntityManager();

        entityManager.getTransaction().begin();

        try {
            duel = getDuel(entityManager, duelCondition);
            //if (duel == null) return false;
            answer = getAnswer(entityManager, answerCondition);
            //if (answer == null) return false;
            player = getPlayer(entityManager, playerCondition);
            //if (player == null) return false;
        } catch (NoResultException e) {
            return false;
        }
        List<Turn> turnList = duel.getTurnList();

        if (player.getUuid().equals(jsonObject.playerUUID)) {
            turnList.get(turnIndex).getFirstPlayersAnswerList().add(answer);
        }

        if (player.getUuid().equals(jsonObject.playerUUID)) {
            turnList.get(turnIndex).getSecondPlayersAnswerList().add(answer);
        }

        entityManager.persist(turnList.get(turnIndex));
        entityManager.getTransaction().commit();

        return true;
    }

    private Duel getDuel(EntityManager entityManager, String uuid) {
        Query query = entityManager.createQuery("SELECT m FROM Duel m WHERE uuid = :uuid", Duel.class);
        query.setParameter("uuid", uuid);
        return (Duel) query.getSingleResult();
    }

    private Answer getAnswer(EntityManager entityManager, String uuid) {
        Query query = entityManager.createQuery("SELECT a FROM Answer a WHERE uuid = :uuid", Answer.class);
        query.setParameter("uuid", uuid);
        return (Answer) query.getSingleResult();
    }

    private Player getPlayer(EntityManager entityManager, String uuid) {
        Query query = entityManager.createQuery("SELECT p FROM Player p WHERE uuid = :uuid", Answer.class);
        query.setParameter("uuid", uuid);
        return (Player) query.getSingleResult();
    }

    } 

