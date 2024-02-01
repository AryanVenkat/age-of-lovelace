package com.aryan.venkat.aol.repository;

import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.entity.TechEvent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface NarrativeRepository extends JpaRepository<Narrative, Long> {

    @Query(value = "SELECT n FROM Narrative n WHERE n.techEventId = :techEventId ORDER BY FUNCTION('RAND')")
    Optional<Narrative> findRandomNarrativeByTechEventId(@Param("techEventId") long techEventId);

    @Query(value = "SELECT n FROM Narrative n WHERE n.lifeEventId = :lifeEventId ORDER BY FUNCTION('RAND')")
    Optional<Narrative> findRandomNarrativeByLifeEventId(@Param("lifeEventId") long lifeEventId);
}
