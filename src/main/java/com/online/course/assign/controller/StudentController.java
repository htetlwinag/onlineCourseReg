package com.online.course.assign.controller;

import com.online.course.assign.constant.GlobalConstant;
import com.online.course.assign.entity.Student;
import com.online.course.assign.pojo.StudentPojo;
import com.online.course.assign.response.BaseResponse;
import com.online.course.assign.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
public class StudentController {

    @Autowired
    StudentService studentService;

    @GetMapping (value = "/students")
    public BaseResponse getStudent() {
        List<Student> students= studentService.getStudent();
        return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/create")
    public BaseResponse addStudent(@RequestBody Student student)
    {

        try {
            student = studentService.save(student);
        }catch (Exception e) {
            System.out.println("Error occur "+e.getMessage());
            return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
        }
        return new BaseResponse(GlobalConstant.SUCCESS, student,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @GetMapping (value = "/student/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        Student student = studentService.findById(id);
        return new BaseResponse(GlobalConstant.SUCCESS, student,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @DeleteMapping (value = "/student/{id}")
    public BaseResponse deleteById(@PathVariable long id) {
        studentService.deleteStudent(id);
        return new BaseResponse(GlobalConstant.SUCCESS, null, GlobalConstant.Message.SUCCESS_MESSAGE);
    }


    @PutMapping (value = "/student")
    public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {

        System.out.println(studentPojo.getAddress());
        System.out.println(studentPojo.getEmail());
        System.out.println(studentPojo.getStudentId());
        System.out.println(studentPojo.getPhone());
        System.out.println(studentPojo.getBirthDate());

        Student student = studentService.findById(studentPojo.getId());
        System.out.println("id" + student);
        if(student==null) {
            return null;
        }
        student.setName(studentPojo.getName());
        System.out.println(studentPojo.getName());
        student.setEmail(studentPojo.getEmail());
        student.setPhone(studentPojo.getPhone());
        student.setBirthDate(studentPojo.getBirthDate());
        student.setAddress(studentPojo.getAddress());
        student.setStudentId(studentPojo.getStudentId());
        Student students = studentService.save(student);

        return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);

    }

}
