package com.example.demo.repository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;

import java.util.List;
import java.util.Optional;

public interface InvoiceRepository {

    Optional<Invoice> findById(Long id);

    List<Invoice> findByUploadedBy(User user);

    List<Invoice> findByAmountGreaterThanHql(double amount);

    Invoice save(Invoice invoice);
}
