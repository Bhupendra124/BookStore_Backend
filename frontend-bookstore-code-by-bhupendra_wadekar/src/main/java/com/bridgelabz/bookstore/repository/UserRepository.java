package com.bridgelabz.bookstore.repository;

import com.bridgelabz.bookstore.entity.Users;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {


    Optional<Users> getUserById(Long userId);
}