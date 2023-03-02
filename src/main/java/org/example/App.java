package org.example;

import jakarta.persistence.EntityManager;
import org.example.config.Factory;
import org.example.model.Student;
import org.example.repo.StudentRepo;
import org.example.utils.Gender;
import org.example.utils.GenerateDate;

import java.util.List;

public class App {
    static EntityManager entityManager = Factory.start();
    static StudentRepo studentRepo = new StudentRepo(entityManager);
    public static void main(String[] args) {
//        Student student = new Student();
//        student.setFirstName("Ahmad");
//        student.setLastName("Muzaki");
//        student.setAddress("Sukabumi");
//        student.setMajor("Teknik");
//        student.setGender(Gender.MALE);
//        student.setBirthDate(GenerateDate.generate("2000-04-02"));
//        insert(student);

        getAll(1, 4);
//        getById("c324e061-7019-49e4-9b12-849de3b98a43");

//        Student student = new Student();
//        student.setStudentId("2ec8cf43-3154-406e-8381-6a9f6227f0c5");

//        update(student);

//        delete("071bd4e8-14f1-4c09-83e5-641656cd8d17");
    }

    static void insert(Student student) {
        studentRepo.create(student);
    }

    static void delete(String id) {
        studentRepo.delete(id);
    }

    static void update(Student student) {
        studentRepo.update(student);
    }

    static void getById(String id) {
        Student student = studentRepo.findOne(id);
        System.out.println(student);
    }

    static void getAll(Integer page, Integer size) {
        List<Student> students = studentRepo.findAll(page, size);
        students.forEach(System.out::println);
    }

    static void getAllByName(String name) {
        List<Student> students = studentRepo.findByName(name);
        students.forEach(System.out::println);
    }
}
