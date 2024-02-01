package com.aryan.venkat.aol.controller;

import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.service.NarrativeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/narratives")
public class NarrativeController {

    @Autowired
    private NarrativeService narrativeService;

    // GET - Get all narratives
    @GetMapping("/")
    public List<Narrative> getAllNarratives() {
        return narrativeService.getAllNarratives();
    }

    // GET - Get narrative by ID
    @GetMapping("/{narrativeId}")
    public ResponseEntity<Narrative> getNarrativeById(@PathVariable Long narrativeId) {
        Narrative narrative = narrativeService.getNarrativeById(narrativeId);
        return ResponseEntity.ok().body(narrative);
    }

    // POST - Create a new narrative
    @PostMapping("/")
    public ResponseEntity<Narrative> createNarrative(@RequestBody Narrative narrative) {
        Narrative createdNarrative = narrativeService.createNarrative(narrative);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdNarrative);
    }

    // PUT - Update narrative by ID
    @PutMapping("/{narrativeId}")
    public ResponseEntity<Narrative> updateNarrative(@PathVariable Long narrativeId,
                                                     @RequestBody Narrative narrative) {
        Narrative updatedNarrative = narrativeService.updateNarrative(narrativeId, narrative);
        return ResponseEntity.ok().body(updatedNarrative);
    }

    // DELETE - Delete narrative by ID
    @DeleteMapping("/{narrativeId}")
    public ResponseEntity<?> deleteNarrative(@PathVariable Long narrativeId) {
        narrativeService.deleteNarrative(narrativeId);
        return ResponseEntity.ok().build();
    }
}
