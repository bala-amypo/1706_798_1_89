package com.example.demo.repository;

import com.example.demo.model.*;
import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {
    Invoice save(Invoice invoice);
    Optional<Invoice> findById(Long id);
    List<Invoice> findByUploadedBy(User user);
    List<Invoice> findByAmountGreaterThanHql(double amount);
}
