package com.aryan.venkat.aol.controller;

import com.aryan.venkat.aol.entity.SubmittedEvent;
import com.aryan.venkat.aol.service.SubmittedEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/submitted-events")
public class SubmittedEventController {

    @Autowired
    private SubmittedEventService submittedEventService;

    // GET - Get all submitted events
    @GetMapping("/")
    public List<SubmittedEvent> getAllSubmittedEvents() {
        return submittedEventService.getAllSubmittedEvents();
    }

    // GET - Get submitted event by ID
    @GetMapping("/{submittedEventId}")
    public ResponseEntity<SubmittedEvent> getSubmittedEventById(@PathVariable Long submittedEventId) {
        SubmittedEvent submittedEvent = submittedEventService.getSubmittedEventById(submittedEventId);
        return ResponseEntity.ok().body(submittedEvent);
    }

    // POST - Create a new submitted event
    @PostMapping("/")
    public ResponseEntity<SubmittedEvent> createSubmittedEvent(@RequestBody SubmittedEvent submittedEvent) {
        SubmittedEvent createdSubmittedEvent = submittedEventService.createSubmittedEvent(submittedEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdSubmittedEvent);
    }

    // PUT - Update submitted event by ID
    @PutMapping("/{submittedEventId}")
    public ResponseEntity<SubmittedEvent> updateSubmittedEvent(@PathVariable Long submittedEventId,
                                                               @RequestBody SubmittedEvent submittedEvent) {
        SubmittedEvent updatedSubmittedEvent = submittedEventService.updateSubmittedEvent(submittedEventId, submittedEvent);
        return ResponseEntity.ok().body(updatedSubmittedEvent);
    }

    // DELETE - Delete submitted event by ID
    @DeleteMapping("/{submittedEventId}")
    public ResponseEntity<?> deleteSubmittedEvent(@PathVariable Long submittedEventId) {
        submittedEventService.deleteSubmittedEvent(submittedEventId);
        return ResponseEntity.ok().build();
    }
}
