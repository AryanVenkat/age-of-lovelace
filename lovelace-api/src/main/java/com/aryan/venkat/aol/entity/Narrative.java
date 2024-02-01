package com.aryan.venkat.aol.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "narrative")
@Data
public class Narrative {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long narrativeId;

    @Column(nullable = false)
    private String narrativeDesc;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private long techEventId;

    @Column(nullable = false)
    private long lifeEventId;
}
