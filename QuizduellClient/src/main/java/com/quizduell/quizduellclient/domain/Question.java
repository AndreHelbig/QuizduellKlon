package com.quizduell.quizduellclient.domain;

import java.util.List;
import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Question {

    private UUID uuid;
    private String text;
    public List<Answer> answers;

    public void askQuestion() {
        System.out.println("Question:" +text);
        System.out.println("possible answers:");

        for(int i=1; i<5; i++){
            System.out.println("[" +i+ "]"+answers.get(i).getText());
        }
        System.out.println("type 1, 2, 3 or 4 to answer");
    }
}
