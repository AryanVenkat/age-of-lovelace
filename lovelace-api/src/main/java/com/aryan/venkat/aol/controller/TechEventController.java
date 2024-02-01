package com.aryan.venkat.aol.controller;

import com.aryan.venkat.aol.entity.TechEvent;
import com.aryan.venkat.aol.service.TechEventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/tech-events")
public class TechEventController {

    @Autowired
    private TechEventService techEventService;

    // GET - Get all tech events
    @GetMapping("/")
    public List<TechEvent> getAllTechEvents() {
        return techEventService.getAllTechEvents();
    }

    // GET - Get tech event by ID
    @GetMapping("/{eventId}")
    public ResponseEntity<TechEvent> getTechEventById(@PathVariable Long eventId) {
        TechEvent techEvent = techEventService.getTechEventById(eventId);
        return ResponseEntity.ok().body(techEvent);
    }

    // POST - Create a new tech event
    @PostMapping("/")
    public ResponseEntity<TechEvent> createTechEvent(@RequestBody TechEvent techEvent) {
        TechEvent createdTechEvent = techEventService.createTechEvent(techEvent);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdTechEvent);
    }

    // PUT - Update tech event by ID
    @PutMapping("/{eventId}")
    public ResponseEntity<TechEvent> updateTechEvent(@PathVariable Long eventId, @RequestBody TechEvent techEvent) {
        TechEvent updatedTechEvent = techEventService.updateTechEvent(eventId, techEvent);
        return ResponseEntity.ok().body(updatedTechEvent);
    }

    // DELETE - Delete tech event by ID
    @DeleteMapping("/{eventId}")
    public ResponseEntity<?> deleteTechEvent(@PathVariable Long eventId) {
        techEventService.deleteTechEvent(eventId);
        return ResponseEntity.ok().build();
    }
}
