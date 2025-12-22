package com.example.demo.model;

import java.time.LocalDate;
import java.time.LocalDateTime;

import jakarta.persistence.*;

@Entity
@Table(
    uniqueConstraints = @UniqueConstraint(columnNames = {"vendor_id","invoiceNumber"})
)
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

    private LocalDateTime uploadedAt;

    @PrePersist
    public void prePersist() {
        this.uploadedAt = LocalDateTime.now();
    }

    public Double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }

    public void setVendor(Vendor vendor) {
        this.vendor = vendor;
    }

    public void setUploadedBy(User uploadedBy) {
        this.uploadedBy = uploadedBy;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
