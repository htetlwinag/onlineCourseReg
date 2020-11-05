package com.online.course.assign.service;

import com.online.course.assign.entity.Department;
import com.online.course.assign.repository.DepartRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartRepository departRepository;

    public List<Department> getDepartment() {
        return departRepository.findAll();
    }
//
    public Department createDepartment(Department department) {
        return departRepository.save(department);
    }

    public Department save(Department department) {
        return departRepository.save(department);
    }

    public Department findById(Long id) {
        return departRepository.findById(id).orElse(null);
    }
}
