package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.entity.TechEvent;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface TechEventService {
    List<TechEvent> getAllTechEvents();

    TechEvent getTechEventById(Long eventId);

    TechEvent createTechEvent(TechEvent techEvent);

    TechEvent updateTechEvent(Long eventId, TechEvent techEvent);

    void deleteTechEvent(Long eventId);

    Optional<TechEvent> findRandomEventByYear(int year);

    Optional<Narrative> findRandomNarrativeByTechEventId(long techEventId);
}
