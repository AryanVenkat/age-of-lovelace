package com.aryan.venkat.aol.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "timeline_entry")
@Data
public class TimelineEntry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timelineId;

    @Column(nullable = false)
    private int eventYear;

    @Column(nullable = false)
    private String lifeEventNarrative;

    @Column(nullable = false)
    private String lifeEventImageUrl;

    @Column(nullable = false)
    private String techEventNarrative;

    @Column(nullable = false)
    private String techEventImageUrl;

    @Column(nullable = false)
    private long userId;

}
