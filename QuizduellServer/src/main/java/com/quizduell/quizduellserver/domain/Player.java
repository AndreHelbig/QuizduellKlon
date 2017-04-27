/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
@Entity
public class Player {
    @Getter
    @Setter
    @Id
    private UUID uuid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int matchesWon;
    @Getter
    @Setter
    private int matchesLost;
    @Getter
    @Setter
    private int totalMatches;
}
