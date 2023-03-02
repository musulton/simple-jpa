package org.example.model;

import jakarta.persistence.*;
import org.hibernate.annotations.GenericGenerator;

import java.util.List;

@Entity
@Table(name = "major")
@NamedQueries({
    @NamedQuery(name = "find major by id", query = "select m from Major m where m.majorId = :id")
})
public class Major {
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(name = "major_id")
    private String majorId;

    @Column(name = "major_name", nullable = false, unique = true)
    private String majorName;

    @OneToMany(mappedBy = "major")
    private List<Student> students;

    public String getMajorId() {
        return majorId;
    }

    public void setMajorId(String majorId) {
        this.majorId = majorId;
    }

    public String getMajorName() {
        return majorName;
    }

    public void setMajorName(String majorName) {
        this.majorName = majorName;
    }

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Major{" +
                "majorId='" + majorId + '\'' +
                ", majorName='" + majorName + '\'' +
                ", students=" + students +
                '}';
    }
}
