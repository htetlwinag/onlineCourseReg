package com.online.course.assign.controller;

import com.online.course.assign.constant.GlobalConstant;
import com.online.course.assign.entity.Course;
import com.online.course.assign.entity.Department;
import com.online.course.assign.response.BaseResponse;
import com.online.course.assign.service.CourseService;
import com.online.course.assign.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;

@RestController
@CrossOrigin
public class DepartmentController {

    @Autowired
    DepartmentService departmentService;

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/department-list")
    public BaseResponse getDepartment() {
        List<Department> departments= departmentService.getDepartment();
        return new BaseResponse(GlobalConstant.SUCCESS, departments,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/department")
    public Department createDepartment(@RequestBody Department department){

        Collection<Course> courses= department.getCourses();
        if(courses !=null){
            courses = courseService.saveAll(courses);
        }

        for(Course course : courses){
            department.addCourse(course);
        }

        return departmentService.save(department);
    }

    @GetMapping (value = "/department/{id}")
    public BaseResponse getById(@PathVariable Long id) {
        Department department = departmentService.findById(id);
        return new BaseResponse(GlobalConstant.SUCCESS, department,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

}
