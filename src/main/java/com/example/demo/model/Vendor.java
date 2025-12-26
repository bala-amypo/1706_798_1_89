package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(
    name = "vendors",
    uniqueConstraints = @UniqueConstraint(columnNames = "vendorName")
)
public class Vendor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String vendorName;

    @Email
    @NotBlank
    private String contactEmail;

    private String address;

    private LocalDateTime createdAt;

    @ManyToMany(mappedBy = "favoriteVendors")
    private Set<User> users = new HashSet<>();

    @OneToMany(mappedBy = "vendor")
    private Set<Invoice> invoices = new HashSet<>();

    @PrePersist
    public void prePersist() {
        this.createdAt = LocalDateTime.now();
    }

    /* getters and setters */
}
