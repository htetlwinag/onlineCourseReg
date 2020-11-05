package com.online.course.assign.repository;

import com.online.course.assign.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartRepository extends JpaRepository<Department, Long> {
}
