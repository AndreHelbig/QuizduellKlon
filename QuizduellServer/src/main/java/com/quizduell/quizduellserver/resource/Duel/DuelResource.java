package com.quizduell.quizduellserver.resource.Duel;


import com.quizduell.quizduellserver.core.Manager;
import com.quizduell.quizduellserver.domain.Duel;
import com.quizduell.quizduellserver.domain.Player;
import org.restlet.ext.jackson.JacksonRepresentation;
import org.restlet.resource.Get;
import org.restlet.resource.ServerResource;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.NoResultException;
import java.util.List;
import org.restlet.resource.Post;
/**
 *
 * @author Andre
 */
public class DuelResource extends ServerResource {

    private EntityManager entityManager = Manager.getEntityManager();

    @Get
    public JacksonRepresentation index() {
        EntityManager entityManager = Manager.getEntityManager();
        Query query = entityManager.createQuery("SELECT m FROM Duel m", Duel.class);
        List<Duel> duelList = query.getResultList();

        DuelListJson duelListRepresentation = new DuelListJson();
        duelListRepresentation.duelList = new DuelJson[duelList.size()];

        for (int i = 0; i < duelList.size(); i++) {
            duelListRepresentation.duelList[i] = DuelJson.fromDuel(duelList.get(i));
        }

        return new JacksonRepresentation(duelListRepresentation);
    }
    
    @Post("json")
    public JacksonRepresentation create(CreateDuelJson createDuelJson) {
        Player player1 = getOrCreatePlayer(createDuelJson.playerName1);
        Player player2 = getOrCreatePlayer(createDuelJson.playerName2);

        entityManager.getTransaction().begin();
        
        Duel duel = new Duel();
        duel.setPlayer1(player1);
        duel.setPlayer2(player2);

        entityManager.persist(duel);
        entityManager.getTransaction().commit();

        return new JacksonRepresentation(DuelJson.fromDuel(duel));
    }

    private Player getOrCreatePlayer(String name) {
        try {
            return getPlayer(name);
        } catch (NoResultException e) {
            Player player = new Player();
            player.setName(name);
            entityManager.persist(player);
            return player;
        }
    }

    private Player getPlayer(String name) {
        Query query = entityManager.createQuery("SELECT p FROM Player p WHERE name = :name", Player.class);
        query.setParameter("name", name);
        return (Player) query.getSingleResult();
    }
}
