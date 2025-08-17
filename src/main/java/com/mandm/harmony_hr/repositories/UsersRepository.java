package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {
    Optional<Users> findByUsername(String username);
    boolean existsByUsername(String username);
    Optional<Users> getByUserId(int userId);
}
