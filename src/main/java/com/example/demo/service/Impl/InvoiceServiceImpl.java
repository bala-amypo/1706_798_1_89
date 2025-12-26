package com.example.demo.service.impl;

import com.example.demo.model.Invoice;
import com.example.demo.repository.*;
import com.example.demo.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final UserRepository userRepository;
    private final VendorRepository vendorRepository;

    public InvoiceServiceImpl(InvoiceRepository invoiceRepository,
                              UserRepository userRepository,
                              VendorRepository vendorRepository) {
        this.invoiceRepository = invoiceRepository;
        this.userRepository = userRepository;
        this.vendorRepository = vendorRepository;
    }

    @Override
    public Invoice uploadInvoice(Long userId, Long vendorId, Invoice invoice) {
        invoice.setUploadedBy(userRepository.findById(userId).orElse(null));
        invoice.setVendor(vendorRepository.findById(vendorId).orElse(null));
        return invoiceRepository.save(invoice);
    }

    @Override
    public Invoice getInvoice(Long id) {
        return invoiceRepository.findById(id).orElse(null);
    }

    @Override
    public List<Invoice> getInvoicesByUser(Long userId) {
        return invoiceRepository.findByUploadedBy(
                userRepository.findById(userId).orElse(null)
        );
    }

    @Override
    public String categorizeInvoice(String description) {
        return "CATEGORY";
    }
}
