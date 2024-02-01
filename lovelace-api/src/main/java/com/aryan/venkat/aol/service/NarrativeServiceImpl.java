package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.Narrative;
import com.aryan.venkat.aol.repository.NarrativeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NarrativeServiceImpl implements NarrativeService {

    @Autowired
    private NarrativeRepository narrativeRepository;

    @Override
    public List<Narrative> getAllNarratives() {
        return narrativeRepository.findAll();
    }

    @Override
    public Narrative getNarrativeById(Long narrativeId) {
        return narrativeRepository.findById(narrativeId)
                .orElseThrow(() -> new EntityNotFoundException("Narrative not found with ID: " + narrativeId));
    }

    @Override
    public Narrative createNarrative(Narrative narrative) {
        // Add additional validations or logic if required before saving
        return narrativeRepository.save(narrative);
    }

    @Override
    public Narrative updateNarrative(Long narrativeId, Narrative narrative) {
        Narrative existingNarrative = narrativeRepository.findById(narrativeId)
                .orElseThrow(() -> new EntityNotFoundException("Narrative not found with ID: " + narrativeId));

        // Update existingNarrative with details from the provided narrative object
        existingNarrative.setTechEventId(narrative.getTechEventId());
        existingNarrative.setNarrativeDesc(narrative.getNarrativeDesc());
        // Update other fields similarly

        return narrativeRepository.save(existingNarrative);
    }

    @Override
    public void deleteNarrative(Long narrativeId) {
        narrativeRepository.deleteById(narrativeId);
    }

    @Override
    public Optional<Narrative> findRandomNarrativeByTechEventId(long techEventId) {
        return narrativeRepository.findRandomNarrativeByTechEventId(techEventId);
    }

    @Override
    public Optional<Narrative> findRandomNarrativeByLifeEventId(long lifeEventId) {
        return narrativeRepository.findRandomNarrativeByLifeEventId(lifeEventId);
    }

}
