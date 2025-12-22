package com.example.demo.service;

import java.util.List;
import com.example.demo.model.Vendor;

public interface VendorService {

    Vendor create(Vendor vendor);

    List<Vendor> getAll();

    Vendor getById(Long id);
}
