package com.example.demo.repository;

import com.example.demo.model.Vendor;

public interface VendorRepository {
    Vendor save(Vendor vendor);
    java.util.Optional<Vendor> findById(Long id);
}
