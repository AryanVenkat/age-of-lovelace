package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.entity.TechEvent;
import com.aryan.venkat.aol.repository.TechEventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TechEventServiceImpl implements TechEventService {

    @Autowired
    private TechEventRepository techEventRepository;

    @Autowired
    private NarrativeService narrativeService;

    @Override
    public List<TechEvent> getAllTechEvents() {
        return techEventRepository.findAll();
    }

    @Override
    public TechEvent getTechEventById(Long eventId) {
        return techEventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("TechEvent not found with ID: " + eventId));
    }

    @Override
    public TechEvent createTechEvent(TechEvent techEvent) {
        // Add additional validations or logic if required before saving
        return techEventRepository.save(techEvent);
    }

    @Override
    public TechEvent updateTechEvent(Long eventId, TechEvent techEvent) {
        TechEvent existingTechEvent = techEventRepository.findById(eventId)
                .orElseThrow(() -> new EntityNotFoundException("TechEvent not found with ID: " + eventId));

        // Update existingTechEvent with details from the provided techEvent object
        existingTechEvent.setEventName(techEvent.getEventName());
        existingTechEvent.setEventYear(techEvent.getEventYear());
        // Update other fields similarly

        return techEventRepository.save(existingTechEvent);
    }

    @Override
    public void deleteTechEvent(Long eventId) {
        techEventRepository.deleteById(eventId);
    }

    @Override
    public Optional<TechEvent> findRandomEventByYear(int year) {
        return techEventRepository.findRandomEventByYear(year);
    }

    @Override
    public Optional<Narrative> findRandomNarrativeByTechEventId(long techEventId) {
        return narrativeService.findRandomNarrativeByTechEventId(techEventId);
    }


}
