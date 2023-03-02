package org.example;

import jakarta.persistence.EntityManager;
import org.example.config.Factory;
import org.example.model.Club;
import org.example.model.Major;
import org.example.model.Student;
import org.example.model.UserCredential;
import org.example.repo.ClubRepo;
import org.example.repo.MajorRepo;
import org.example.repo.StudentRepo;
import org.example.service.MajorService;
import org.example.service.StudentService;
import org.example.utils.Gender;
import org.example.utils.GenerateDate;

import java.util.List;

public class App {
    static EntityManager entityManager = Factory.start();

    static MajorRepo majorRepo = new MajorRepo(entityManager);
    static StudentRepo studentRepo = new StudentRepo(entityManager);
    static ClubRepo clubRepo = new ClubRepo(entityManager);

    static MajorService majorService = new MajorService(majorRepo);
    static StudentService studentService = new StudentService(studentRepo, majorService);

    public static void main(String[] args) {
//        Club voli = new Club();
//        voli.setClubName("Voli");
//        clubRepo.create(voli);

        UserCredential userCredential = new UserCredential();
        userCredential.setEmail("test@email.com");
        userCredential.setPassword("123456");

        Student student = new Student();
        student.setFirstName("First");
        student.setLastName("Last");
        student.setGender(Gender.FEMALE);
        student.setBirthDate(GenerateDate.generate("2002-01-21"));
        student.setAddress("Jakarta");

        Club futsal = clubRepo.findOne("0fa21921-c0a8-4602-89d0-68de4baeac8b");
        Club voli = clubRepo.findOne("1a1a53a0-1fb1-4f23-be2c-96a1d64d4e8c");

        student.setClub(futsal);
        student.setClub(voli);

        futsal.setStudents(student);

        studentService.insert(student, userCredential, "1ebaad5c-a564-4fa0-83a1-405e24eaee8e");
    }

    static void insertStudentUser() {
        UserCredential userCredential = new UserCredential();
        userCredential.setEmail("musulton@outlook.com");
        userCredential.setPassword("password");

        Student student = new Student();
        student.setFirstName("Moch");
        student.setLastName("Rahman");
        student.setAddress("Jakarta Timur");
        student.setGender(Gender.MALE);
        student.setBirthDate(GenerateDate.generate("1995-04-25"));

        studentService.insert(student, userCredential, "1ebaad5c-a564-4fa0-83a1-405e24eaee8e");
    }
}
