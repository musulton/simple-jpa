package org.example.repo;

import org.example.model.Student;

import java.util.List;

public interface IStudentRepo {
    void create(Student student);
    List<Student> findAll(Integer page, Integer size);
    void update(Student student);
    Student findOne(String id);
    List<Student> findByName(String name);
    void delete(String id);
}
