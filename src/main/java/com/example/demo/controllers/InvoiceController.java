package com.example.demo.controller;

import java.util.List;

import org.springframework.web.bind.annotation.*;

import com.example.demo.model.Invoice;
import com.example.demo.service.InvoiceService;

@RestController
@RequestMapping("/api/invoices")
public class InvoiceController {

    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @PostMapping("/upload/{userId}/{vendorId}")
    public Invoice upload(@PathVariable Long userId,
                          @PathVariable Long vendorId,
                          @RequestBody Invoice invoice) {
        return invoiceService.uploadInvoice(userId, vendorId, invoice);
    }

    @PostMapping("/categorize/{invoiceId}")
    public Invoice categorize(@PathVariable Long invoiceId) {
        return invoiceService.categorize(invoiceId);
    }

    @GetMapping("/user/{userId}")
    public List<Invoice> userInvoices(@PathVariable Long userId) {
        return invoiceService.getUserInvoices(userId);
    }
}
