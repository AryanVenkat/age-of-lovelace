package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.LifeEvent;
import com.aryan.venkat.aol.entity.TechEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface LifeEventRepository extends JpaRepository<LifeEvent, Long> {

    public List<LifeEvent> findByEventYear(int eventYear);

    @Query(value = "SELECT l FROM LifeEvent l WHERE l.eventYear = :year and l.userId= :userId ORDER BY FUNCTION('RAND')")
    Optional<LifeEvent> findRandomEventByYear(@Param("year") int year, @Param("userId") long userId);

}
