package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.model.Invoice;
import com.example.demo.model.User;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {

    List<Invoice> findByUploadedBy(User user);

    List<Invoice> findByAmountGreaterThanHql(Double amount);
}
