package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.belongsTo WHERE u.username = :username")
    Optional<Users> findByUsername(String username);

    @Query("SELECT CASE WHEN COUNT(u) > 0 THEN true ELSE false END FROM Users u WHERE u.username = :username")
    boolean existsByUsername(String username);

    @Query("SELECT u FROM Users u LEFT JOIN FETCH u.belongsTo WHERE u.userId = :userId")
    Optional<Users> getByUserId(int userId);
}
