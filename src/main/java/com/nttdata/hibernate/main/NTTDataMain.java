package com.nttdata.hibernate.main;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.persistence.models.Contract;
import com.nttdata.hibernate.services.ClientManagementServiceImpl;
import com.nttdata.hibernate.services.ContractManagementServiceImpl;
import com.nttdata.hibernate.services.interfaces.ClientManagementServiceI;
import com.nttdata.hibernate.services.interfaces.ContractManagementServiceI;

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
		ContractManagementServiceI contractService = new ContractManagementServiceImpl(session);

		// Creo los contratos
		Contract contract1 = new Contract();
		contract1.setDateValidity("2010-05-12");
		contract1.setDateExpiration("2015-07-19");
		contract1.setMonthlyPrice(1500);
		contract1.setUpdatedClient("ada");

		Contract contract2 = new Contract();
		contract2.setDateValidity("2018-06-21");
		contract2.setDateExpiration("2020-10-09");
		contract2.setMonthlyPrice(1500);
		contract2.setUpdatedClient("ada");

		List<Contract> contracts1 = new ArrayList<>();
		contracts1.add(contract1);
		contracts1.add(contract2);

		List<Contract> contracts2 = new ArrayList<>();
		contracts2.add(contract2);

		// Creo los clientes para añadirlos a la base de datos
		Client client1 = new Client();
		client1.setName("Juan");
		client1.setFirstLastName("Perez");
		client1.setSecondLastName("Rodriguez");
		client1.setDni("14725836Q");
		client1.setUpdatedClient("ada");
		client1.setContract(contracts1);

		Client client2 = new Client();
		client2.setName("Pepe");
		client2.setFirstLastName("Gonzalez");
		client2.setSecondLastName("Macias");
		client2.setDni("98765432Z");
		client2.setUpdatedClient("ada");

		Client client3 = new Client();
		client3.setName("Maria");
		client3.setFirstLastName("Ramirez");
		client3.setSecondLastName("Lopez");
		client3.setDni("12345678A");
		client3.setUpdatedClient("ada");
		client3.setContract(contracts1);

		// Vinculo los contratos con los clientes
		contract1.setClient(client1);
		contract2.setClient(client1);
		contract2.setClient(client3);

		// Inserto los clientes en la base de datos
		clientService.insertNewClient(client1);
		clientService.insertNewClient(client2);
		clientService.insertNewClient(client3);

		// Inserto los contratos en la base de datos
		contractService.insertNewContract(contract1);
		contractService.insertNewContract(contract2);

		// Realizo algunas consultas a la base de datos
		System.out.println("\nConsulta en la base de datos\n");

		System.out.println(clientService.searchByName("Pepe"));
		System.out.println(clientService.searchById((long) 1));
		System.out.println(clientService.searchByFirstLastName("Ramirez"));

		System.out.println("\nBusqueda de los contratos de un cliente concreto");

		System.out.println(contractService.searchByClient((long) 3));

		System.out.println("\nConsulta con Criteria");
		System.out.println(contractService.searchClientByContract((long) 3));

		System.out.println(clientService.searchClientByNameAndPrice("Maria", 1500));

		// Cierro Session y SessionFactory
		session.close();
	}
}
