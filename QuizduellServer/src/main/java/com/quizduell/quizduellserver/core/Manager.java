/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.quizduell.quizduellserver.core;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import lombok.Synchronized;

/**
 *
 * @author Andre
 */
public class Manager {
    private static EntityManager entityManager;

    @Synchronized
    public static EntityManager getEntityManager() {
        if (entityManager == null) {
            EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("cassandra");
            entityManager = entityManagerFactory.createEntityManager();
        }
        return entityManager;
    }
}
