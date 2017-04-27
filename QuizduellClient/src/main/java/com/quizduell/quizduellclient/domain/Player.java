package com.quizduell.quizduellclient.domain;

import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Player {

    private UUID uuid;
    private String name;
    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public int matchesWon, matchesLost, totalMatches;

    Duel matchPlayer1, matchPlayer2;
}
