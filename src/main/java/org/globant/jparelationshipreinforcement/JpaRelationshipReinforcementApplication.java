package org.globant.jparelationshipreinforcement;

import java.util.Arrays;
import java.util.Optional;
import java.util.List;

import org.globant.jparelationshipreinforcement.models.Adress;
import org.globant.jparelationshipreinforcement.models.Client;
import org.globant.jparelationshipreinforcement.models.Invoice;
import org.globant.jparelationshipreinforcement.repository.ClientRepository;
import org.globant.jparelationshipreinforcement.repository.InvoiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.Transactional;


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
		OneToManyInvoice();
	}


	@Transactional()
	public void OneToManyInvoice(){
		Client client = new Client("Marlon", "Caicedo");

		Invoice invoice1 = new Invoice("Compras para el hogar", 120_000L);
		Invoice invoice2 = new Invoice("Compras para el patio", 20_000L);

		// Alternative method to add invoices  through concatenation
		// client.addInvoice(invoice1).addInvoice(invoice2);

		client.setInvoices(Arrays.asList(invoice1, invoice2));

		clientRepo.save(client);

		System.out.println(client.toString());
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
	public void editClientAndAddressById(){
		Optional<Client> client = clientRepo.findById(2L);

		client.ifPresent(foundClient ->{
			Adress adress1 = new Adress(null, "Kenedy's Village Street", 912);
			Adress adress2 = new Adress(null, "Fishers lake", 1200);

			foundClient.setAddresses(Arrays.asList(adress1, adress2));

			// Updates a client
			clientRepo.save(foundClient);

			System.out.println(foundClient);
		});
	}

	@Transactional(readOnly=true)
	public void findClientStartingWith(){
		String pattern="J";
		Object[] client =  clientRepo.findClientStartingWith(pattern);
		if (client.length>0)
		{
			System.out.println("Client or clients found that name starts with " + pattern);

			for(Object clientLoop:client){
				System.out.println(clientLoop);
			}

		}else System.out.println("There are no users with name that starts with " + pattern);
		
	}

	@Transactional(readOnly=true)
	public void findClientEndingWith(){
		String pattern="a";
		Object[] clients =  clientRepo.findClientEndingWith(pattern);
		if (clients.length>0)
		{
			System.out.println("Client or clients found that name ends with " + pattern);

			for(Object clientLoop:clients){
				System.out.println(clientLoop);
			}

		}else System.out.println("There are no users with name that ends with " + pattern);
		
	}

	@Transactional
	public void findAllCLientsWithInvoices(){
		Client client = new Client("Deyby", "ariza");
		Client client2 = new Client("Carlos", "Casas");
		
		Adress adress1 = new Adress(null, "St monica street", 15);
		Adress adress2 = new Adress(null, "Boca raton", 223);
		
		Adress adress3 = new Adress(null, "Kenedy's Village Street", 912);
		Adress adress4 = new Adress(null, "Fishers lake", 1200);

		client.setAddresses(Arrays.asList(adress1, adress2));
		client2.setAddresses(Arrays.asList(adress3, adress4));
		
		clientRepo.save(client);
		clientRepo.save(client2);

		// Saving a client with invoices
		List<Client> clients = (List<Client>) clientRepo.findAll();
		
		clients.forEach(System.out::println);

	}

}
