package org.example.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Major;

import java.util.List;

public class MajorRepo extends ARepo implements IRepo<Major>{
    public MajorRepo(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public void create(Major params) {
        inTransaction(em -> {
            em.persist(params);
        });
    }

    @Override
    public List<Major> findAll(Integer page, Integer size) {
        return null;
    }

    @Override
    public void update(Major params) {

    }

    @Override
    public Major findOne(String id) {
        TypedQuery<Major> typedQuery = entityManager.createNamedQuery("find major by id", Major.class);
        typedQuery.setParameter("id", id);

        Major major = typedQuery.getSingleResult();

        return major;
    }

    @Override
    public List<Major> findByName(String name) {
        return null;
    }

    @Override
    public void delete(String id) {

    }
}
