package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Collections;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    @Override
    public String categorizeInvoice(String description) {
        return "UNCATEGORIZED";
    }

    @Override
    public Invoice getInvoice(Long id) {
        return null;
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        return Collections.emptyList();
    }
}
