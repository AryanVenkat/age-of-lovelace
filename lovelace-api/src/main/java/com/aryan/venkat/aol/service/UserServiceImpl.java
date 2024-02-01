package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.*;
import com.aryan.venkat.aol.model.Timeline;
import com.aryan.venkat.aol.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private TechEventService techEventService;

    @Autowired
    private LifeEventService lifeEventService;

    @Autowired
    private TimelineEntryService timelineEntryService;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getUserById(long userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));
    }

    @Override
    public User createUser(User user) {
        // Add additional validations or logic if required before saving
        return userRepository.save(user);
    }

    @Override
    public User updateUser(long userId, User user) {
        User existingUser = userRepository.findById(userId)
                .orElseThrow(() -> new EntityNotFoundException("User not found with ID: " + userId));

        // Update existingUser with details from the provided user object
        existingUser.setName(user.getName());
        existingUser.setYearOfBirth(user.getYearOfBirth());
        // Update other fields similarly
        
        return userRepository.save(existingUser);
    }

    @Override
    public void addTimeLineEntries(User user) {

        if(user == null) {
            throw new IllegalArgumentException("User cannot be null");
        }

        if (user.getUserId() == null) {
            throw new IllegalArgumentException("User ID cannot be null");
        }

        List<LifeEvent> lifeEvents = lifeEventService.getAllLifeEvents();

        lifeEvents.forEach(lifeEvent -> {
            System.out.println(lifeEvent.getEventName());
            long userId = lifeEvent.getUserId();
            int eventYear = lifeEvent.getEventYear();

            TimelineEntry timelineEntry = new TimelineEntry();
            timelineEntry.setEventYear(eventYear);
            timelineEntry.setUserId(userId);

            Optional<Narrative> lifeEventNarrative = lifeEventService.findRandomNarrativeByLifeEventId(lifeEvent.getEventId());
            lifeEventNarrative.ifPresent(narrative -> {
                timelineEntry.setLifeEventNarrative(narrative.getNarrativeDesc());
            });

            Optional<TechEvent> techEventOptional = techEventService.findRandomEventByYear(eventYear);
            techEventOptional.ifPresent(techEvent -> {

                Optional<Narrative> narrativeOptional = techEventService.findRandomNarrativeByTechEventId(techEvent.getEventId());
                narrativeOptional.ifPresent(narrative -> {
                    timelineEntry.setTechEventNarrative(narrative.getNarrativeDesc());
                });

                timelineEntryService.createTimelineEntry(timelineEntry);
            });

        });
    }

    @Override
    public LifeEvent createLifeEvent(LifeEvent lifeEvent) {
        return lifeEventService.createLifeEvent(lifeEvent);
    }

    @Override
    public Timeline generateTimeLine(User user) {

        addTimeLineEntries(user);

        return getTimelineFromDB(user.getUserId());
    }

    @Override
    public Timeline getTimeLine(long userId) {

        if(userId == 0) {
            throw new IllegalArgumentException("User ID cannot be empty");
        }
        return getTimelineFromDB(userId);
    }

    private Timeline getTimelineFromDB(long userId) {
        List<TimelineEntry> timelineEntries = timelineEntryService.getTimelineEntriesByUserId(userId);
        if(CollectionUtils.isEmpty(timelineEntries)) {
            throw new EntityNotFoundException("Timeline entries not found for user ID: " + userId);
        }

        Timeline timeline = new Timeline();
        timeline.setUserId(userId);
        timeline.setTimelineEntries(timelineEntries);
        return timeline;
    }
}
