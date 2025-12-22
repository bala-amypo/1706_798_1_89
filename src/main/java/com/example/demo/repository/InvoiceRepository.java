package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.model.Invoice;
import com.example.demo.model.User;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    // Required by test suite
    List<Invoice> findByUploadedBy(User user);

    // Required by test suite (name must match exactly)
    List<Invoice> findByAmountGreaterThanHql(Double amount);
}
    