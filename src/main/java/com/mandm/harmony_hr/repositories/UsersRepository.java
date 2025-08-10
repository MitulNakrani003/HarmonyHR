package com.mandm.harmony_hr.repositories;

import com.mandm.harmony_hr.entities.Users;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Integer> {

    /**
     * Finds a user by their username.
     *
     * @param username the username to search for
     * @return an Optional containing the User if found, or empty if not found
     */
    Optional<Users> findByUsername(String username);

    /**
     * Checks if a user exists by their username.
     *
     * @param username the username to check
     * @return true if the user exists, false otherwise
     */
    boolean existsByUsername(String username);
}
