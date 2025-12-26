package com.example.demo.service;

import com.example.demo.model.Vendor;
import java.util.List;

public interface VendorService {
    Vendor create(Vendor vendor);
    List<Vendor> getAll();
    Vendor getById(Long id);
}
