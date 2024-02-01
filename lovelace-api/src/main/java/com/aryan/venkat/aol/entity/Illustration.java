package com.aryan.venkat.aol.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "illustration")
@Data
public class Illustration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long illustrationId;

    @Column(nullable = false)
    private String category;

    @Column(nullable = false)
    private String url;

    private String avatarId;
}
