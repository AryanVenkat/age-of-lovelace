package com.aryan.venkat.aol.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "submitted_event")
@Data
public class SubmittedEvent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long submittedEventId;

    @Column(nullable = false)
    private String eventName;

    @Column(nullable = false)
    private int eventYear;

    private String eventDescription;

    private String eventImageUrl;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;
}
