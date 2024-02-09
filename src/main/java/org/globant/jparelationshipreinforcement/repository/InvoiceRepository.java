package org.globant.jparelationshipreinforcement.repository;

import org.globant.jparelationshipreinforcement.models.Invoice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InvoiceRepository extends CrudRepository <Invoice, Long> {
    
}
