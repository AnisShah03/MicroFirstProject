package com.ty.UserService.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ty.UserService.model.User;

public interface UserRepository extends JpaRepository<User, Long> {}

