package org.example.model;

import jakarta.persistence.*;

@Entity
@Table(name = "user_credential")
public class UserCredential {
    @Id
    @Column(name = "email")
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @OneToOne(mappedBy = "userCredential", cascade = CascadeType.PERSIST)
    private Student student;

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "UserCredential{" +
                "email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
