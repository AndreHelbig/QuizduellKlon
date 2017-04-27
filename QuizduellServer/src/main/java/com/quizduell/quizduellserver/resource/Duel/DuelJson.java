/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.resource.Duel;

import com.quizduell.quizduellserver.domain.Duel;
import com.quizduell.quizduellserver.domain.Player;
import com.quizduell.quizduellserver.domain.Turn;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Andre
 */
public class DuelJson {
    
    public UUID uuid;
    public Player player1;
    public Player player2;
    public List<Turn> turnList;

    public static DuelJson fromDuel(final Duel duel) {
        DuelJson duelJson = new DuelJson();
        duelJson.uuid = duel.getUuid();
        duelJson.player1 = duel.getPlayer1();
        duelJson.player2 = duel.getPlayer2();
        duelJson.turnList = duel.getTurnList();
        return duelJson;
    }
}
