package com.microservicedemo.user.repository;

import com.microservicedemo.user.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
    User getByUserId(Long id);
}
