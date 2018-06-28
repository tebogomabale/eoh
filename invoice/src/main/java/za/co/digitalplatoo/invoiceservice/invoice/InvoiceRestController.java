/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoo.invoiceservice.invoice;

import java.util.List;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import za.co.digitalplatoo.invoiceservice.invoice.entity.Invoice;

/**
 *
 * @author tmabale
 */
@RestController
@RequestMapping("/eoh")
public class InvoiceRestController {
    
    public static final org.slf4j.Logger logger = LoggerFactory.getLogger(InvoiceRestController.class);
 
    @Autowired
    InvoiceRepository invoiceRepository; 
    
    @RequestMapping(value = "/invoices/", method = RequestMethod.POST)
    public ResponseEntity<String> addIvoice(Invoice invoice)
    {
        if (invoiceRepository.existsById(invoice.getId())) {
            
            return new ResponseEntity(new InvoiceError("Unable to create. A Invoice with ID " +  invoice.getId() + " already exist."),HttpStatus.CONFLICT);
        }
        invoiceRepository.save(invoice);
        HttpHeaders headers = new HttpHeaders();
        return new ResponseEntity<String>(headers, HttpStatus.CREATED);
        
     
    }
    
    @RequestMapping(value = "/invoices/", method = RequestMethod.GET)
    public ResponseEntity<List<Invoice>>   viewAllInvoices()
    {
        List<Invoice> invoices = invoiceRepository.findAll();
        if (invoices.isEmpty()) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
           
        }
        return new ResponseEntity<List<Invoice>>(invoices, HttpStatus.OK);
    }
    
    @RequestMapping(value = "/invoices/{id}", method = RequestMethod.GET)
    public ResponseEntity<?> viewInvoice(@PathVariable("id")Long id)
    {
        Invoice invoice = invoiceRepository.getOne(id);
        if (invoice == null) {
             return new ResponseEntity(new InvoiceError("Invoice with id " + id + " not found"), HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<Invoice>(invoice, HttpStatus.OK);
    }
    
}
