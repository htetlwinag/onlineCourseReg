package com.online.course.assign.controller;
import com.online.course.assign.constant.GlobalConstant;
import com.online.course.assign.entity.Course;
import com.online.course.assign.response.BaseResponse;
import com.online.course.assign.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class CourseController {

    @Autowired
    CourseService courseService;

    @GetMapping(value = "/course")
    public BaseResponse getCourse() {
        List<Course> courses= courseService.getCourse();
        return new BaseResponse(GlobalConstant.SUCCESS, courses,GlobalConstant.Message.SUCCESS_MESSAGE);
    }

    @PostMapping(value = "/create/course")
    public BaseResponse createCourse(@RequestBody Course course) {
        try {
            course= courseService.save(course);
        }catch (Exception e){
            System.out.println("error" + e.getMessage());
            return new  BaseResponse(GlobalConstant.FAIL,null , GlobalConstant.Message.FAIL_MESSAGE) ;
        }
        return new BaseResponse(GlobalConstant.SUCCESS, course, GlobalConstant.Message.SUCCESS_MESSAGE);
    }

}
