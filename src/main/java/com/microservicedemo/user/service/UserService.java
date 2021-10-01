package com.microservicedemo.user.service;

import com.microservicedemo.user.VO.Department;
import com.microservicedemo.user.VO.UserDepartment;
import com.microservicedemo.user.entity.User;
import com.microservicedemo.user.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@Slf4j
public class UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    public User saveUserInformation(User user) {
        log.info("Inside the UserService Method for saving User Info");
        return userRepository.save(user);
    }

    public UserDepartment getUserInfo(Long id) {
        UserDepartment userDepartment = new UserDepartment();
        User user = userRepository.getByUserId(id);
        Department department = restTemplate.getForObject("http://localhost:9001/department/"+user.getDepartmentId(), Department.class);
        userDepartment.setDepartment(department);
        userDepartment.setUser(user);
        return userDepartment;
    }
}
