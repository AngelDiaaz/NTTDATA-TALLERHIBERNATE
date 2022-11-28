package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;

import com.nttdata.hibernate.persistence.dao.ClientDaoImpl;
import com.nttdata.hibernate.persistence.interfaces.ClientDaoI;
import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.services.interfaces.ClientManagementServiceI;

/**
 * Clase de implementacion de servicios del Cliente, ClientManagementServiceImpl
 * 
 * @author Ángel Díaz Avilés
 */
public class ClientManagementServiceImpl implements ClientManagementServiceI {
	/** Cliente Dao */
	private ClientDaoI clientDao;

	/**
	 * Constructor ClientManagementServiceImpl
	 */
	public ClientManagementServiceImpl(final Session session) {
		this.clientDao = new ClientDaoImpl(session);
	}

	/**
	 * Metodo que inserta un nuevo cliente en la base de datos
	 * 
	 * @param newClient Cliente que queremos insertar
	 */
	public void insertNewClient(final Client newClient) {

		// Si el cliente no es nulo y su id si
		if (newClient != null && newClient.getClientId() == null) {

			// Inserta el nuevo cliente
			clientDao.insert(newClient);
		}
	}

	/**
	 * Metodo que actualiza un cliente en la base de datos
	 * 
	 * @param updatedClient Cliente que queremos actualizar
	 */
	public void updateClient(final Client updatedClient) {

		// Si el cliente no es nulo y su id si
		if (updatedClient != null && updatedClient.getClientId() != 0) {

			// Actualiza el cliente
			clientDao.update(updatedClient);
		}
	}

	/**
	 * Metodo que elimina un cliente de la base de datos
	 * 
	 * @param deletedClient Cliente que queremos eliminar
	 */
	public void deleteClient(final Client deletedClient) {

		// Si el cliente no es nulo y su id si
		if (deletedClient != null && deletedClient.getClientId() != 0) {

			// Eliminamos el cliente
			clientDao.delete(deletedClient);
		}
	}

	/**
	 * Metodo que devuelve un cliente, buscandolo a traves de su id
	 * 
	 * @param clientId ID del cliente que queremos sacar
	 * @return Cliente de la base de datos con el id
	 */
	public Client searchById(final Long clientId) {
		Client client = null;

		// Si el id es diferente de 0
		if (clientId != 0) {

			// Cliente con el ID
			client = clientDao.searchById(clientId);
		}
		return client;
	}

	/**
	 * Metodo que devuelve los clientes que contiene un mismo nombre
	 * 
	 * @param name Nombre de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese nombre
	 */
	public List<Client> searchByName(final String name) {
		List<Client> playersList = new ArrayList<>();

		// Si no es nulo
		if (StringUtils.isNotBlank(name)) {

			// Clientes con ese nombre
			playersList = clientDao.searchByName(name);
		}
		return playersList;
	}

	/**
	 * Metodo que devuelve todos los clientes de la base de datos
	 *
	 * @return List con todos los clientes
	 */
	public List<Client> searchAll() {
		return clientDao.searchAll();
	}

	/**
	 * Metodo que devuelve los clientes que contiene el mismo primer apellido
	 * 
	 * @param firstLastName Primer apellido de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese primer apellido
	 */
	public List<Client> searchByFirstLastName(String firstLastName) {
		List<Client> playersList = new ArrayList<>();

		// Si no es nulo
		if (StringUtils.isNotBlank(firstLastName)) {

			// Clientes con ese nombre
			playersList = clientDao.searchByFirstLastName(firstLastName);
		}
		return playersList;
	}

	/**
	 * Metodo que devuelve los clientes que contiene el mismo segundo apellido
	 * 
	 * @param secondLastName Segundo apellido de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese segundo apellido
	 */
	public List<Client> searchBySecondLastName(String secondLastName) {
		List<Client> playersList = new ArrayList<>();

		// Si no es nulo
		if (StringUtils.isNotBlank(secondLastName)) {

			// Clientes con ese nombre
			playersList = clientDao.searchBySecondLastName(secondLastName);
		}
		return playersList;
	}
	
	/**
	 * Metodo que saca los clientes a traves de su nombre y el precio del contrato
	 * 
	 * @param name Nombre de los clientes
	 * @param price Precio del contrato
	 * @return Lista de clientes
	 */
	@Override
	public List<Client> searchClientByNameAndPrice(final String name, final int price) {
		List<Client> client = null;

		// Si el nombre no es nulo
		if (name != null) {
			client = clientDao.searchClientByNameAndPrice(name, price);
		}
		return client;
	}

}
