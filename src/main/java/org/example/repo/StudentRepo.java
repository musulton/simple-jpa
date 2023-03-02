package org.example.repo;

import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import org.example.model.Student;

import java.util.List;

public class StudentRepo extends Repo implements IRepo<Student> {
    public StudentRepo(EntityManager entityManager){
        super(entityManager);
    }

    @Override
    public void create(Student student) {
        inTransaction(((em) -> em.persist(student) ));
    }

    /*
    Versi PSQL

        @Override
    public List<Student> findAll() {
        TypedQuery<Student> result = entityManager.createQuery("select s from Student s", Student.class);
        List<Student> students = result.getResultList();

        return students;
    }
     */

    // Versi NamedQuery
    @Override
    public List<Student> findAll(Integer page, Integer size) {
        TypedQuery<Student> result = entityManager.createNamedQuery("find all student", Student.class);

        result.setFirstResult((page - 1) * size);
        result.setMaxResults(size);

        List<Student> students = result.getResultList();

        return students;
    }

    @Override
    public void update(Student student) {
        inTransaction(em -> {
            em.merge(student);
        });
    }

    /*
    Versi PSQL

    @Override
    public Student findOne(String id) {
        Student student = entityManager.find(Student.class, id);

        return student;
    }
     */

    // Versi NamedQuery
    @Override
    public Student findOne(String id) {
        TypedQuery<Student> result = entityManager.createNamedQuery("find student by id", Student.class);
        result.setParameter("id", id);

        return result.getSingleResult();
    }

    @Override
    public List<Student> findByName(String name) {
        TypedQuery<Student > result = entityManager.createQuery("select s from Student s where firstName like %?1% ", Student.class);
        result.setParameter(1, name);
        List<Student> students = result.getResultList();

        return students;
    }

    @Override
    public void delete(String id) {
        inTransaction(em -> {
            Student student = findOne(id);
            em.remove(student);
        });
    }
}
