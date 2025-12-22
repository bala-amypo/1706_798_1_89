package com.example.demo.model;

import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(name = "categorization_rules")
public class CategorizationRule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String keyword;
    private String matchType;
    private Integer priority;
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    public String getKeyword() { return keyword; }
    public String getMatchType() { return matchType; }
    public Integer getPriority() { return priority; }
    public void setCategory(Category category) {
    this.category = category;
    public Category getCategory() { return category; }
}
