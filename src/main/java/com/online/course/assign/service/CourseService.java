package com.online.course.assign.service;

import com.online.course.assign.entity.Course;
import com.online.course.assign.repository.CourseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.Collection;
import java.util.List;

@Service
public class CourseService {

    @Autowired
    CourseRepository courseRepository;

    public List<Course> getCourse() {
        return courseRepository.findAll();
    }


    public Collection<Course> saveAll(Collection<Course> courses) {
        return courseRepository.saveAll(courses);
    }

    public Course save(Course course) {
        return courseRepository.save(course);
    }
}
