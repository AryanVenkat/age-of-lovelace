package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.Narrative;

import java.util.List;
import java.util.Optional;

public interface NarrativeService {
    List<Narrative> getAllNarratives();

    Narrative getNarrativeById(Long narrativeId);

    Narrative createNarrative(Narrative narrative);

    Narrative updateNarrative(Long narrativeId, Narrative narrative);

    void deleteNarrative(Long narrativeId);

    Optional<Narrative> findRandomNarrativeByTechEventId(long techEventId);

    Optional<Narrative> findRandomNarrativeByLifeEventId(long lifeEventId);

}
