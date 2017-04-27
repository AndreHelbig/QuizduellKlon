package com.quizduell.quizduellclient.domain;

import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Answer {


        private UUID uuid;

        private String text;

        public String getText() {
                return text;
        }

        public UUID getUuid() {
                return uuid;
        }
}
