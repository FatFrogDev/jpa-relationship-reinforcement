package org.globant.jparelationshipreinforcement.repository;

import org.globant.jparelationshipreinforcement.models.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ClientRepository extends CrudRepository<Client, Long>{
    
    // @Query("SELECT CONCAT(c.name || ' ', c.lastname) from Client c ")
    @Query("SELECT CONCAT(c.name, ' ', c.lastname) FROM Client c WHERE c.name like ?1%")
    Object[] findClientStartingWith(String pattern);

    @Query("SELECT CONCAT(c.name, ' ', c.lastname) FROM Client c WHERE c.name like %?1")
    Object[] findClientEndingWith(String pattern);
}