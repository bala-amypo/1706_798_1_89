package com.example.demo.service;

import com.example.demo.model.Invoice;
import java.util.List;

public interface InvoiceService {

    String categorizeInvoice(String description);

    Invoice getInvoice(Long id);

    List<Invoice> getInvoicesByUser(Long userId);
}
