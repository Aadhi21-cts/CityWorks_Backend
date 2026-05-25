package com.cts.repository;

import java.util.List;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cts.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Optional<User> findByUsername(String username);
    List<User> findAllByName(String name);
    List<User> findByRoleAndStatus(String role, String status);
    Optional<User> findByEmail(String email); 
    Optional<User> findByResetToken(String resetToken);
    Optional<User> findByUserIdAndRole(Long id, String role);
}