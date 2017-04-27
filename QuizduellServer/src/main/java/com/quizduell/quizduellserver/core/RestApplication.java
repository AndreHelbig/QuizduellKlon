/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.core;

import com.quizduell.quizduellserver.resource.Answer.AnswerResource;
import com.quizduell.quizduellserver.resource.Duel.DuelResource;
import com.quizduell.quizduellserver.resource.Turn.TurnResource;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import org.restlet.Application;
import org.restlet.Restlet;
import org.restlet.routing.Router;

/**
 *
 * @author Andre
 */
public class RestApplication extends Application {
           
    @Override
    public Restlet createInboundRoot(){
        Router router = new Router(getContext());
        
        router.attach("/duel", DuelResource.class);
        router.attach("/turn", TurnResource.class);
        router.attach("/answer", AnswerResource.class);
        
        return router;
    }
}
