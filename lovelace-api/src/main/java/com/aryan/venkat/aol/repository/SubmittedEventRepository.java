package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.SubmittedEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubmittedEventRepository extends JpaRepository<SubmittedEvent, Long> {
    // Define custom queries or additional methods if needed
}
