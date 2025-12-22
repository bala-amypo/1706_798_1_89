package com.example.demo.model;

import jakarta.persistence.*;

@Entity
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String ruleType; // EXACT, CONTAINS, REGEX
    private String pattern;

    @ManyToOne
    private Category category;
}
