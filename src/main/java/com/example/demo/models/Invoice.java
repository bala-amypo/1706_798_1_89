package com.example.demo.model;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(uniqueConstraints = @UniqueConstraint(columnNames = {"vendor_id", "invoiceNumber"}))
public class Invoice {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    private Vendor vendor;

    private String invoiceNumber;
    private Double amount;
    private LocalDate invoiceDate;
    private String description;

    @ManyToOne
    private Category category;

    @ManyToOne
    private User uploadedBy;

    private LocalDateTime uploadedAt = LocalDateTime.now();
}
