package com.nttdata.hibernate.main;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.services.ClientManagementServiceImpl;
import com.nttdata.hibernate.services.interfaces.ClientManagementServiceI;

/**
 * Clase principal NTTDataMain
 * 
 * @author Ángel Díaz Avilés
 */
public class NTTDataMain {

	/**
	 * Metodo principal
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		// Inicio la sesión
		final Session session = NTTDataHibernateUtil.getSessionFactory().openSession();

		// Inicio los servicios
		ClientManagementServiceI clientService = new ClientManagementServiceImpl(session);

		// Creo los clientes para añadirlos a la base de datos
		Client cliente1 = new Client();
		cliente1.setName("Juan");
		cliente1.setFirstLastName("Perez");
		cliente1.setSecondLastName("Rodriguez");
		cliente1.setDni("14725836Q");
		cliente1.setUpdatedClient("ada");

		Client cliente2 = new Client();
		cliente2.setName("Pepe");
		cliente2.setFirstLastName("Gonzalez");
		cliente2.setSecondLastName("Macias");
		cliente2.setDni("98765432Z");
		cliente2.setUpdatedClient("ada");

		Client cliente3 = new Client();
		cliente3.setName("Maria");
		cliente3.setFirstLastName("Ramirez");
		cliente3.setSecondLastName("Lopez");
		cliente3.setDni("12345678A");
		cliente3.setUpdatedClient("ada");

		// Inserto los clientes en la base de datos
		clientService.insertNewClient(cliente1);
		clientService.insertNewClient(cliente2);
		clientService.insertNewClient(cliente3);

		// Realizo algunas consultas a la base de datos
		System.out.println("\nConsulta en la base de datos\n");

		var client2 = clientService.searchByName("Pepe");
		var client1 = clientService.searchById((long) 1);
		var client3 = clientService.searchByFirstLastName("Ramirez");
		System.out.println(client2);
		System.out.println(client1);
		System.out.println(client3);

		// Cierro Session y SessionFactory
		session.close();
	}
}
