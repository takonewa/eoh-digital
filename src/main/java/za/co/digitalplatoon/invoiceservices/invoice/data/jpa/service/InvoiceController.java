
package za.co.digitalplatoon.invoiceservices.invoice.data.jpa.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import za.co.digitalplatoon.invoiceservices.invoice.data.jpa.domain.Invoice;

@RepositoryRestResource(collectionResourceRel = "invoices", path = "invoices")
interface InvoiceController extends CrudRepository<Invoice, Long> {

}
