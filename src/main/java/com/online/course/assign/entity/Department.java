package com.online.course.assign.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "Department")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)
public class Department {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq")
    long id;

    @Column
    String name;

    @Column
    String phone;

    @OneToMany //(cascade = CascadeType.ALL)
    @JoinColumn(name = "DEPARTMENT_ID" )
    private Collection<Course> courses;

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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Collection<Course> getCourses() {
        return courses;
    }


    public void addCourse(Course course) {
        if (courses==null) {
            courses = new ArrayList<Course>();
        }
        if (!courses.contains(course)) {
            courses.add(course);
        }
    }

    @Override
    public String toString() {
        return "Department{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", courses=" + courses +
                '}';
    }
}
