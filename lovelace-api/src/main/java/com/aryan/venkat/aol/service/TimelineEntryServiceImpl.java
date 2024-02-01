package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.TimelineEntry;
import com.aryan.venkat.aol.repository.TimelineEntryRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TimelineEntryServiceImpl implements TimelineEntryService {

    @Autowired
    private TimelineEntryRepository timelineEntryRepository;

    @Override
    public List<TimelineEntry> getTimelineEntriesByUserId(long userId) {
        return timelineEntryRepository.findByUserIdOrderByEventYear(userId);
    }

    @Override
    public TimelineEntry createTimelineEntry(TimelineEntry timeline) {
        return timelineEntryRepository.save(timeline);
    }

    @Override
    public TimelineEntry updateTimelineEntry(long timelineId, TimelineEntry timeline) {
        TimelineEntry existingTimeline = timelineEntryRepository.findById(timelineId)
                .orElseThrow(() -> new EntityNotFoundException("Timeline entry not found with ID: " + timelineId));

        // Update existingTimeline with details from the provided timeline object
        existingTimeline.setLifeEventNarrative(timeline.getLifeEventNarrative());
        existingTimeline.setTechEventNarrative(timeline.getTechEventNarrative());
        // Update other fields similarly

        return timelineEntryRepository.save(existingTimeline);
    }

    @Override
    public void deleteTimelineEntry(long timelineId) {
        timelineEntryRepository.deleteById(timelineId);
    }
}
