package org.globant.jparelationshipreinforcement;

import java.util.Arrays;
import java.util.Optional;

import org.globant.jparelationshipreinforcement.models.Adress;
import org.globant.jparelationshipreinforcement.models.Client;
import org.globant.jparelationshipreinforcement.repository.ClientRepository;
import org.globant.jparelationshipreinforcement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import jakarta.transaction.Transactional;

@SpringBootApplication
public class JpaRelationshipReinforcementApplication implements CommandLineRunner{

	@Autowired
	ClientRepository clientRepo;
	
	@Autowired
	InvoiceRepository invoiceRepo;

	public static void main(String[] args) {
		SpringApplication.run(JpaRelationshipReinforcementApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		OneToManyFindById();
	}

	/** 
 	* Example of jpa/hibernate using CASCADE.Type Class.
 	*/
	@Transactional
	public void createClientAndAddresses(){
		Client client = new Client("Deyby", "ariza");
		
		Adress adress1 = new Adress(null, "St monica street", 15);

		Adress adress2 = new Adress(null, "Boca raton", 223);

		client.setAddresses(Arrays.asList(adress1, adress2));

		clientRepo.save(client);
	}

	@Transactional
	public void OneToManyFindById(){
		Optional<Client> client = clientRepo.findById(2L);

		client.ifPresent(foundClient ->{
			Adress adress1 = new Adress(null, "Kenedy's Village Street", 912);
			Adress adress2 = new Adress(null, "Fishers lake", 1200);

			foundClient.setAddresses(Arrays.asList(adress1, adress2));

			// Ufpdates a client
			clientRepo.save(foundClient);

			System.out.println(foundClient);
		});
	}

}
