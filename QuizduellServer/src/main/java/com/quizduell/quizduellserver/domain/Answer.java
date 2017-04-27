/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.domain;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import lombok.Setter;
import lombok.Getter;
import org.hibernate.search.annotations.Indexed;

/**
 *
 * @author Andre
 */
@Indexed
@Entity
public class Answer {
    @Getter
    @Setter
    @Id
    private UUID uuid;

    @Getter
    @Setter
    private String text;

    @Getter
    @Setter
    private boolean isRight;

    //for hibernate 
    @Getter
    @Setter
    @ManyToOne
    private Turn turn;

    @Getter
    @Setter
    @ManyToOne 
    private Question question;
}
