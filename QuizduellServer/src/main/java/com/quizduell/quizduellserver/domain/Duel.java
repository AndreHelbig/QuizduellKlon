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
public class Duel {
    private static final int MAX_ROUNDS = 6;

    private Player player1;
    private Player player2;
    private List<Turn> turnList;
}
