package com.quizduell.quizduellclient.domain;

import java.util.List;
import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Duel {
    private static final int MAX_ROUNDS = 6;

    private UUID uuid;
    private Player player1;
    private Player player2;
    private List<Turn> turnList;


    public Duel() {
        this.uuid = UUID.randomUUID();
    }

    public Duel(UUID uuid) {
        this.uuid = uuid;
    }

    public UUID getUuid() {
        return uuid;
    }

    public Player getPlayer1() {
        return player1;
    }

    public Player getPlayer2() {
        return player2;
    }

    public List<Turn> getTurnList() {
        return turnList;
    }

    public void setPlayer2(Player player2) {
        this.player2 = player2;
    }

    public void setPlayer1(Player player1) {
        this.player1 = player1;
    }

    public void setTurnList(List<Turn> turnList) {
        this.turnList = turnList;
    }
}
