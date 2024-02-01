package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.LifeEvent;
import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.repository.LifeEventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

@Service
public class LifeEventServiceImpl implements LifeEventService {

    @Autowired
    private LifeEventRepository lifeEventRepository;

    @Autowired
    private NarrativeService narrativeService;

    @Override
    public List<LifeEvent> getAllLifeEvents() {
        return lifeEventRepository.findAll();
    }

    @Override
    public LifeEvent getLifeEventById(Long eventId) {
        return lifeEventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("LifeEvent not found with ID: " + eventId));
    }

    @Override
    public LifeEvent createLifeEvent(LifeEvent lifeEvent) {
        if (lifeEvent == null) {
            throw new IllegalArgumentException("LifeEvent cannot be empty");
        }
        if(lifeEvent.getUserId() == 0) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        if(!StringUtils.hasText(lifeEvent.getEventName())) {
            throw new IllegalArgumentException("Event name cannot be empty");
        }
        if(lifeEvent.getEventYear() == 0) {
            throw new IllegalArgumentException("Event year cannot be empty");
        }
        return lifeEventRepository.save(lifeEvent);
    }

    @Override
    public LifeEvent updateLifeEvent(Long eventId, LifeEvent lifeEvent) {
        LifeEvent existingLifeEvent = lifeEventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("LifeEvent not found with ID: " + eventId));

        // Update existingLifeEvent with details from the provided LifeEvent object
        existingLifeEvent.setEventName(lifeEvent.getEventName());
        existingLifeEvent.setEventYear(lifeEvent.getEventYear());
        // Update other fields similarly

        return lifeEventRepository.save(existingLifeEvent);
    }

    @Override
    public void deleteLifeEvent(Long eventId) {
        lifeEventRepository.deleteById(eventId);
    }

    @Override
    public Optional<LifeEvent> findRandomEventByYear(int year, long userId) {
        return lifeEventRepository.findRandomEventByYear(year, userId);
    }


    @Override
    public Optional<Narrative> findRandomNarrativeByLifeEventId(long lifeEventId) {
        return narrativeService.findRandomNarrativeByLifeEventId(lifeEventId);
    }



}
