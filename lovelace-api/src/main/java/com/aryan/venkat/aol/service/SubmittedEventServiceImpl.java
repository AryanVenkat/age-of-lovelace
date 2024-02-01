package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.SubmittedEvent;
import com.aryan.venkat.aol.repository.SubmittedEventRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubmittedEventServiceImpl implements SubmittedEventService {

    @Autowired
    private SubmittedEventRepository submittedEventRepository;

    @Override
    public List<SubmittedEvent> getAllSubmittedEvents() {
        return submittedEventRepository.findAll();
    }

    @Override
    public SubmittedEvent getSubmittedEventById(Long submittedEventId) {
        return submittedEventRepository.findById(submittedEventId)
                .orElseThrow(() -> new EntityNotFoundException("SubmittedEvent not found with ID: " + submittedEventId));
    }

    @Override
    public SubmittedEvent createSubmittedEvent(SubmittedEvent submittedEvent) {
        // Add additional validations or logic if required before saving
        return submittedEventRepository.save(submittedEvent);
    }

    @Override
    public SubmittedEvent updateSubmittedEvent(Long submittedEventId, SubmittedEvent submittedEvent) {
        SubmittedEvent existingSubmittedEvent = submittedEventRepository.findById(submittedEventId)
                .orElseThrow(() -> new EntityNotFoundException("SubmittedEvent not found with ID: " + submittedEventId));

        // Update existingSubmittedEvent with details from the provided submittedEvent object
        existingSubmittedEvent.setEventName(submittedEvent.getEventName());
        existingSubmittedEvent.setEventYear(submittedEvent.getEventYear());
        // Update other fields similarly

        return submittedEventRepository.save(existingSubmittedEvent);
    }

    @Override
    public void deleteSubmittedEvent(Long submittedEventId) {
        submittedEventRepository.deleteById(submittedEventId);
    }
}
