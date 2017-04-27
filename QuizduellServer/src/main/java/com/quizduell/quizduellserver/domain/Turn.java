/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.domain;

import java.util.List;

/**
 *
 * @author Andre
 */
public class Turn {
    private static final int MAX_QUESTIONS = 3;

    private Category category;
    private List<Question> questionList;
    private Player firstPlayer;
    private Player secondPlayer;
    private List<Answer> firstPlayersAnswerList;
    private List<Answer> secondPlayersAnswerList;
}
