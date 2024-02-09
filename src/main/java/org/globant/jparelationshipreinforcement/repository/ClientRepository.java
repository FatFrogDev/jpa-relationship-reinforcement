package org.globant.jparelationshipreinforcement.repository;

import org.globant.jparelationshipreinforcement.models.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{

}