package com.online.course.assign.entity;

import javax.persistence.*;

@Entity
@Table(name = "COURSE")
@SequenceGenerator(name="seq", initialValue=1, allocationSize=100)

public class Course {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY, generator="seq")
    long id;

    @Column
    String name;


    @Column(name = "DEPARTMENT_ID")
    private Long departmentId;

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

    public Long getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Long departmentId) {
        this.departmentId = departmentId;
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", departmentId=" + departmentId +
                '}';
    }
}
