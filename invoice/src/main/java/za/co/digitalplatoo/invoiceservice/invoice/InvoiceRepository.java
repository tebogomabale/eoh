/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package za.co.digitalplatoo.invoiceservice.invoice;


import org.springframework.data.jpa.repository.JpaRepository;
import za.co.digitalplatoo.invoiceservice.invoice.entity.Invoice;

/**
 *
 * @author tmabale
 */
public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    
}
