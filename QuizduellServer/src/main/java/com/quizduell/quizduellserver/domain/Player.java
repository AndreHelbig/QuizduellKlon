/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.domain;

import java.io.Serializable;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Andre
 */
@Entity
@Indexed
public class Player implements Serializable{
    @Getter
    @Setter
    @Id
    private UUID uuid;
    @Getter
    @Setter
    private String name;
    @Getter
    @Setter
    private int duelsWon;
    @Getter
    @Setter
    private int duelsLost;
    @Getter
    @Setter
    private int totalDuels;
    
    //for hibernate 
    @Getter
    @Setter
    @ManyToOne
    private Duel duelPlayer1;

    @Getter
    @Setter
    @ManyToOne
    private Duel duelPlayer2;
    
    public Player(){
        this.uuid = UUID.randomUUID();
    }
}
