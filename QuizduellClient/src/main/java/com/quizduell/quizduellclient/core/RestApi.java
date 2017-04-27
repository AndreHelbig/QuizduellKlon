package com.quizduell.quizduellclient.core;

import com.quizduell.quizduellclient.domain.Duel;
import com.quizduell.quizduellclient.domain.Turn;
import com.quizduell.quizduellclient.json.JsonParser;
import com.quizduell.quizduellclient.json.AnswerJson;
import com.quizduell.quizduellclient.json.CreateDuelJson;
import com.quizduell.quizduellclient.json.CreateTurnJson;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import jdk.nashorn.internal.parser.JSONParser;

/**
 * Created by Daniel-PC on 26.04.2017.
 */
public class RestApi {

    public final static String route ="http://localhost:8182/api/";
    
    public Duel[] getDuels() {
        String url = route +"dueles";

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        HttpResponse response = null;
        try {
            response = client.execute(request);
            return JsonParser.deserializeDuels(response);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public Duel createDuel(CreateDuelJson createDuel) {
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(route +"dueles");
        try {
            String json = JsonParser.parseCreateDuel(createDuel);
            if(json == null) return null;

            StringEntity params = new StringEntity(json);
            post.addHeader("content-type", "application/json");
            post.setEntity(params);

            HttpResponse response = client.execute(post);

            return JsonParser.deserializeDuel(response);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    public boolean postAnswer(AnswerJson answerJson) {

        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(route +"answer");
        try {
            String json = JsonParser.parseAnswer(answerJson);
            if(json == null) return false;

            StringEntity params = new StringEntity(json);
            post.addHeader("content-type", "application/json");
            post.setEntity(params);

            HttpResponse response = client.execute(post);
            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public Turn[] getTurns() {

        String url = route +"turns";
        Turn[] turns = null;

        HttpClient client = new DefaultHttpClient();
        HttpGet request = new HttpGet(url);

        HttpResponse response = null;
        try {
            response = client.execute(request);

            turns = JsonParser.deserializeTurns(response);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return turns;
    }

    public boolean createTurn(CreateTurnJson createTurnJson){
        HttpClient client = new DefaultHttpClient();
        HttpPost post = new HttpPost(route +"turns");
        try {
            String json = JsonParser.parseTurn(createTurnJson);
            if(json == null) return false;

            StringEntity params = new StringEntity(json);
            post.addHeader("content-type", "application/json");
            post.setEntity(params);

            HttpResponse response = client.execute(post);

            return true;
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}
