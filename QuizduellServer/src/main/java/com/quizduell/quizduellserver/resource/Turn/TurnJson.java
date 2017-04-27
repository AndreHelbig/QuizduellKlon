/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.resource.Turn;

import com.quizduell.quizduellserver.domain.Answer;
import com.quizduell.quizduellserver.domain.Category;
import com.quizduell.quizduellserver.domain.Player;
import com.quizduell.quizduellserver.domain.Question;
import com.quizduell.quizduellserver.domain.Turn;
import java.util.List;

/**
 *
 * @author Andre
 */
public class TurnJson {
    public Category category;

    public List<Question> questionList;

    public Player firstPlayer;

    public Player secondPlayer;

    public List<Answer> firstPlayersAnswerList;

    public List<Answer> secondPlayersAnswerList;
    
    public static TurnJson fromTurn(final Turn turn) {
        TurnJson turnJson = new TurnJson();
        turnJson.category = turn.getCategory();
        turnJson.questionList = turn.getQuestionList();
        turnJson.firstPlayer = turn.getFirstPlayer();
        turnJson.secondPlayer = turn.getSecondPlayer();
        turnJson.firstPlayersAnswerList = turn.getFirstPlayersAnswerList();
        turnJson.secondPlayersAnswerList = turn.getSecondPlayersAnswerList();
        return turnJson;
    }

}
