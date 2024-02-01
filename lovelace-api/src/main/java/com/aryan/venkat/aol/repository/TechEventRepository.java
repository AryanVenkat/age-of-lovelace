package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.TechEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TechEventRepository extends JpaRepository<TechEvent, Long> {

    public List<TechEvent> findByEventYear(int eventYear);

    @Query(value = "SELECT t FROM TechEvent t WHERE t.eventYear = :year ORDER BY FUNCTION('RAND')")
    Optional<TechEvent> findRandomEventByYear(@Param("year") int year);

}
