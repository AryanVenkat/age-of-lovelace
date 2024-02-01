package com.aryan.venkat.aol.model;

import com.aryan.venkat.aol.entity.TimelineEntry;
import lombok.Data;

import java.util.List;

@Data
public class Timeline {

    private Long userId;
    private List<TimelineEntry> timelineEntries;

}
