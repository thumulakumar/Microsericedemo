package com.microservicedemo.department.controller;

import com.microservicedemo.department.entity.Department;
import com.microservicedemo.department.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/department")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @GetMapping("/hello")
    public String sayHello() {
        log.info("Inside the Department Controller method getting Department");
        return "hi";
    }

    @GetMapping("/{id}")
    public Department getDepartment(@PathVariable("id") Long departmentId) {
        log.info("Inside the Department Controller method getting Department");
        return departmentService.getDepartment(departmentId);
    }

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("Inside the Department Controller method Saving Department");
        return departmentService.saveDepart(department);
    }

}
