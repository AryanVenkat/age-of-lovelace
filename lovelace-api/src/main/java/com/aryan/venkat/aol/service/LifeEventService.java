package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.LifeEvent;
import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.entity.TechEvent;

import java.util.List;
import java.util.Optional;

public interface LifeEventService {

    List<LifeEvent> getAllLifeEvents();

    LifeEvent getLifeEventById(Long eventId);

    LifeEvent createLifeEvent(LifeEvent lifeEvent);

    LifeEvent updateLifeEvent(Long eventId, LifeEvent lifeEvent);

    void deleteLifeEvent(Long eventId);

    Optional<LifeEvent> findRandomEventByYear(int year, long userId);

    Optional<Narrative> findRandomNarrativeByLifeEventId(long lifeEventId);

}