package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.SubmittedEvent;

import java.util.List;

public interface SubmittedEventService {
    List<SubmittedEvent> getAllSubmittedEvents();

    SubmittedEvent getSubmittedEventById(Long submittedEventId);

    SubmittedEvent createSubmittedEvent(SubmittedEvent submittedEvent);

    SubmittedEvent updateSubmittedEvent(Long submittedEventId, SubmittedEvent submittedEvent);

    void deleteSubmittedEvent(Long submittedEventId);
}
