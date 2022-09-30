package com.base.base_project.repositroy;

import org.springframework.data.jpa.repository.JpaRepository;

import com.base.base_project.model.User;

public interface UserRepositroy extends JpaRepository<User, Integer> {
}
