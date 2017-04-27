/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellclient.json;

/**
 *
 * @author Andre
 */
public class CreateDuelJson {
    public String playerName1;
    public String playerName2;
    
    public CreateDuelJson(String playerName1, String playerName2) {
        this.playerName1 = playerName1;
        this.playerName2 = playerName2;
    }
}
