package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public String categorizeInvoice(String description) {
        // Simple placeholder logic
        return "UNCATEGORIZED";
    }

    @Override
    public Invoice getInvoice(Long id) {
        // Stub implementation
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        // Stub implementation
        return Collections.emptyList();
    }
}
