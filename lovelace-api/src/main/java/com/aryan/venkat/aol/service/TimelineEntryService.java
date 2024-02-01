package com.aryan.venkat.aol.service;

import com.aryan.venkat.aol.entity.TimelineEntry;

import java.util.List;

public interface TimelineEntryService {
    List<TimelineEntry> getTimelineEntriesByUserId(long userId);

    TimelineEntry createTimelineEntry(TimelineEntry timeline);

    TimelineEntry updateTimelineEntry(long timelineId, TimelineEntry timeline);

    void deleteTimelineEntry(long timelineId);
}
