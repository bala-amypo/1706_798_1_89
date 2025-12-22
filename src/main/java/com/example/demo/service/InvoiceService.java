package com.example.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.exception.ResourceNotFoundException;
import com.example.demo.model.*;
import com.example.demo.repository.*;
import com.example.demo.util.InvoiceCategorizationEngine;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;
    private final CategorizationRuleRepository ruleRepository;
    private final InvoiceCategorizationEngine engine;

    public InvoiceService(InvoiceRepository invoiceRepository,
                          UserRepository userRepository,
                          VendorRepository vendorRepository,
                          CategorizationRuleRepository ruleRepository,
                          InvoiceCategorizationEngine engine) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
        this.ruleRepository = ruleRepository;
        this.engine = engine;
    }

    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));

        Vendor vendor = vendorRepository.findById(vendorId)
                .orElseThrow(() -> new ResourceNotFoundException("Vendor not found"));

        if (invoice.getAmount() <= 0) {
            throw new RuntimeException("Amount must be greater than zero");
        }

        invoice.setUploadedBy(user);
        invoice.setVendor(vendor);

        return invoiceRepository.save(invoice);
    }

    public Invoice categorize(Long invoiceId) {

        Invoice invoice = invoiceRepository.findById(invoiceId)
                .orElseThrow(() -> new ResourceNotFoundException("Invoice not found"));

        List<CategorizationRule> rules =
                ruleRepository.findMatchingRulesByDescription(invoice.getDescription());

        Category category = engine.determineCategory(invoice, rules);
        invoice.setCategory(category);

        return invoiceRepository.save(invoice);
    }

    public List<Invoice> getUserInvoices(Long userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        return invoiceRepository.findByUploadedBy(user);
    }
}
