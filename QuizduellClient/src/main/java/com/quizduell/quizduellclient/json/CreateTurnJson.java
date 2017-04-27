/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellclient.json;

import java.util.UUID;

/**
 *
 * @author Andre
 */
public class CreateTurnJson {
    public UUID duelUuid;

    public CreateTurnJson(UUID uuid) {
        duelUuid = uuid;
    }
}
