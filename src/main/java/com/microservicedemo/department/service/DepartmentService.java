package com.microservicedemo.department.service;

import com.microservicedemo.department.entity.Department;
import com.microservicedemo.department.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepart(Department department) {
        log.info("Inside the Department Service method Saving Department");
        return departmentRepository.save(department);
    }

    public Department getDepartment(Long departmentId) {
        log.info("Inside the Department Service method Getting Department");
        return departmentRepository.findByDepartmentId(departmentId);

    }
}
