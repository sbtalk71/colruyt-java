package com.demo.spring.repo;

import com.demo.spring.controllers.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,String> {
}
