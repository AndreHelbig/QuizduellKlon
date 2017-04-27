package com.quizduell.quizduellclient.core;



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class Main {

    public static void main(String[] args) throws IOException {
/*
        RestApi restapi = new RestApi();
        restapi.createRound()
        Round[] rounds = restapi.getRounds();

*/
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Game game = new Game();
        game.runGame(br);

        /*

        AnswerJson answerJson = new AnswerJson();

        answerJson.answerUUID = UUID.fromString("f357d90a-2045-11e7-93ae-92361f002671");
        answerJson.matchUUID =  UUID.fromString("a03b7c94-2046-11e7-93ae-92361f002671");
        answerJson.roundNumber = 0;
        answerJson.playerUUID =  UUID.fromString("a03b7c94-2046-11e7-93ae-92361f002671");

        restapi.postAnswer(answerJson);
        //restapi.getMatches();

        restapi.getRounds();

        CreateRoundJson createRoundJson = new CreateRoundJson(UUID.fromString("a03b7c94-2046-11e7-93ae-92361f002671"));
        restapi.createRound(createRoundJson);

        Match[] matches = restapi.getMatches();

        String test= "";
        */
    }
}

