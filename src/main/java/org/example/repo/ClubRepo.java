package org.example.repo;

import jakarta.persistence.EntityManager;
import org.example.model.Club;

import java.util.List;

public class ClubRepo extends Repo implements IRepo<Club> {
    public ClubRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Club club) {
        inTransaction(em -> {
            em.persist(club);
        });
    }

    @Override
    public List<Club> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public void update(Club params) {

    }

    @Override
    public Club findOne(String id) {
        return entityManager.find(Club.class, id);
    }

    @Override
    public List<Club> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
