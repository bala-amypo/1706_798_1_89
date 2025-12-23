package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public String categorizeInvoice(String description) {
        // Temporary logic since no categorization engine is used
        return "UNCATEGORIZED";
    }

    @Override
    public Invoice getInvoice(Long id) {
        // Stub implementation for now
        return null;
    }
}
