package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    // Define custom queries or additional methods if needed
}
