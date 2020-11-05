package com.online.course.assign.entity;


import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "STUDENT")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)

public class Student {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq")
    long id;

    @Column
    String name;

    @Column
    String email;

    @Column
    String phone;

    @Column
    String address;

    @Column
    LocalDate birthDate;

    @Column
    String studentId;

    @Column
    String password;

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }
}
