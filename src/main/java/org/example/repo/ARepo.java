package org.example.repo;

import jakarta.persistence.EntityManager;

import java.util.function.Consumer;

public abstract class ARepo {
    EntityManager entityManager;

    public ARepo(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    protected void inTransaction(Consumer<EntityManager> consumer) {
        try {
            entityManager.getTransaction().begin();
            consumer.accept(entityManager);
            entityManager.getTransaction().commit();
        } catch (Exception e) {
            System.out.println(e.getMessage());
            entityManager.getTransaction().rollback();
        }
    }
}
