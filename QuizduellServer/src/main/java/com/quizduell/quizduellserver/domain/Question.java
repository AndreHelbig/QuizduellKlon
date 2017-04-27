/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.domain;

import java.util.List;
import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author Andre
 */
@Entity
public class Question {
    @Getter
    @Setter
    @Id
    private UUID uuid;
    @Getter
    @Setter
    private String text;
    @Getter
    @Setter
    @OneToMany
    private List<Answer> answers;
}
