package com.quizduell.quizduellclient.json;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.quizduell.quizduellclient.domain.Duel;
import com.quizduell.quizduellclient.domain.Player;
import com.quizduell.quizduellclient.domain.Turn;
import org.apache.http.HttpResponse;
import org.apache.http.params.HttpParams;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.UUID;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public  class JsonParser {
    public static String parsePlayer(Player player){
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(player);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static String parseAnswer(AnswerJson answerJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        json = mapper.writeValueAsString(answerJson);

        return json;
    }

    public static String parseCreateDuel(CreateDuelJson createDuelJson) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        json = mapper.writeValueAsString(createDuelJson);

        return json;
    }

    public static Turn[] deserializeTurns(HttpResponse response) throws IOException {

        BufferedReader rd = null;
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(result.toString(), Turn[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String parseTurn(CreateTurnJson createTurnJson) {
        ObjectMapper mapper = new ObjectMapper();

        String json = null;
        try {
            json = mapper.writeValueAsString(createTurnJson);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }

        return json;
    }

    public static Duel[] deserializeDuels(HttpResponse response) throws IOException {
        BufferedReader rd = null;
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
          return mapper.readValue(result.toString(), Duel[].class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Duel deserializeDuel(HttpResponse response) throws IOException {
        BufferedReader rd = null;
        rd = new BufferedReader(new InputStreamReader(response.getEntity().getContent()));

        StringBuffer result = new StringBuffer();
        String line = "";
        while ((line = rd.readLine()) != null) {
            result.append(line);
        }

        ObjectMapper mapper = new ObjectMapper();
        try {
            return mapper.readValue(result.toString(), Duel.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
