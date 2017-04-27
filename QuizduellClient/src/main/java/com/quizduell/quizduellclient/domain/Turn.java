package com.quizduell.quizduellclient.domain;

import java.util.List;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Turn {
    public Category category;

    public List<Question> questionList;

    public Player firstPlayer;

    public Player secondPlayer;

    public List<Answer> firstPlayersAnswerList;

    public List<Answer> secondPlayersAnswerList;
}
