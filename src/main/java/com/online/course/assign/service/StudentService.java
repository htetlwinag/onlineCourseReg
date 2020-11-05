package com.online.course.assign.service;

import com.online.course.assign.entity.Student;
import com.online.course.assign.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    public Student addStudent (Student student) {
        return studentRepository.save(student);
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    public void deleteStudent(long id) {
        studentRepository.deleteById(id);
    }

    public Student findById(Long id) {
        return studentRepository.findById(id).orElse(null);
    }
}
