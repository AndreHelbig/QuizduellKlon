package com.quizduell.quizduellclient.core;

import com.quizduell.quizduellclient.domain.Answer;
import com.quizduell.quizduellclient.domain.Duel;
import com.quizduell.quizduellclient.domain.Question;
import com.quizduell.quizduellclient.domain.Turn;
import com.quizduell.quizduellclient.json.AnswerJson;
import com.quizduell.quizduellclient.json.CreateDuelJson;
import com.quizduell.quizduellclient.json.CreateTurnJson;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.UUID;

/**
 * Created by Daniel-NB on 26.04.2017.
 */
public class Game {
    public void runGame(BufferedReader br) throws IOException {

        RestApi restapi = new RestApi();
        String playerName1 ="";
        String playerName2 ="";

        //Duel duel = createDuel(playerName1, playerName2);
        Duel duel = new Duel(UUID.fromString("a03b7c94-2046-11e7-93ae-92361f002671"));


        Turn[] turns = null;

        for(int i=0; i<6; i++) {
            boolean isCreated = restapi.createTurn(new CreateTurnJson(duel.getUuid()));
            if (isCreated) turns = restapi.getTurns();
            else {
                System.out.println("Cannot get turn, retry");
                runGame(br);
            }

            for (int j = 0; i < 2; i++) {
                turns[turns.length].questionList.get(j).askQuestion();
                int answerNumber = br.read();

                System.out.println("You chose " + answerNumber);
                AnswerJson answerJson = createAnswerJson(getAnswer(turns[turns.length].questionList.get(j), answerNumber), duel, playerName1, turns.length);
                restapi.postAnswer(answerJson);
            }
            while (true) {
                System.out.println("Turn finished! Ready for next? Press y or n");
                if (br.readLine().equals("y"))
                    continue;
            }
        }
        System.out.println("Game finished");
    }

    private  AnswerJson createAnswerJson(Answer answer,  Duel duel, String playerName1, int turnNumber) {

        AnswerJson answerJson = new AnswerJson();
        answerJson.duelUUID = duel.getUuid();
        answerJson.answerUUID = answer.getUuid();
        answerJson.turnNumber = turnNumber;

        if(duel.getPlayer1().getName().equals(playerName1))
            answerJson.playerUUID = duel.getPlayer1().getUuid();
        else answerJson.playerUUID = duel.getPlayer2().getUuid();

        return answerJson;
    }

    private  Duel createDuel(String playerName1, String playerName2) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        System.out.println("Tell me your name");
        playerName1 = br.readLine();

        System.out.println("Tell me the name of your opponent");
        playerName2 = br.readLine();

        RestApi restApi = new RestApi();

        restApi.createDuel(new CreateDuelJson(playerName1, playerName2));

        return (getDuel(restApi, playerName1, playerName2));
    }

    public  Answer getAnswer(Question question, int answerNumber) {
        return question.answers.get(answerNumber-1);
    }

    public  Duel getDuel(RestApi restapi, String playerName1, String playerName2){
        Duel duel = null;

        Duel[] dueles = restapi.getDuels();

        for (int i=0; i<dueles.length; i++){
            if(dueles[i].getPlayer1().getName().equals(playerName1) && dueles[i].getPlayer2().getName().equals(playerName2)){
                duel = dueles[i];
            }
            if(dueles[i].getPlayer1().getName().equals(playerName2) && dueles[i].getPlayer2().getName().equals(playerName1)){
                duel = dueles[i];
            }
        }
        return duel;
    }
}
