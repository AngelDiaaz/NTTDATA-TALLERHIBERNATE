package com.nttdata.hibernate.services.interfaces;

import java.util.List;

import com.nttdata.hibernate.persistence.models.Client;

/**
 * Clase interfaz ClientManagementServiceI
 * 
 * @author Ángel Díaz Avilés
 */
public interface ClientManagementServiceI {
	/**
	 * Metodo que inserta un nuevo cliente en la base de datos
	 * 
	 * @param newClient Cliente que queremos insertar
	 */
	public void insertNewClient(final Client newClient);

	/**
	 * Metodo que actualiza un cliente en la base de datos
	 * 
	 * @param updatedClient Cliente que queremos actualizar
	 */
	public void updateClient(final Client updatedClient);

	/**
	 * Metodo que elimina un cliente de la base de datos
	 * 
	 * @param deletedClient Cliente que queremos eliminar
	 */
	public void deleteClient(final Client deletedClient);

	/**
	 * Metodo que devuelve un cliente, buscandolo a traves de su id
	 * 
	 * @param clientId ID del cliente que queremos sacar
	 * @return Cliente de la base de datos con el id
	 */
	public Client searchById(final Long clientId);

	/**
	 * Metodo que devuelve los clientes que contiene un mismo nombre
	 * 
	 * @param name Nombre de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese nombre
	 */
	public List<Client> searchByName(final String name);

	/**
	 * Metodo que devuelve todos los clientes de la base de datos
	 *
	 * @return List con todos los clientes
	 */
	public List<Client> searchAll();

	/**
	 * Metodo que devuelve los clientes que contiene el mismo primer apellido
	 * 
	 * @param firstLastName Primer apellido de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese primer apellido
	 */
	public List<Client> searchByFirstLastName(String firstLastName);

	/**
	 * Metodo que devuelve los clientes que contiene el mismo segundo apellido
	 * 
	 * @param secondLastName Segundo apellido de los clientes que queremos obtener
	 * @return List con todos los clientes que tienen ese segundo apellido
	 */
	public List<Client> searchBySecondLastName(String secondLastName);
	
	/**
	 * Metodo que saca los clientes a traves de su nombre y el precio del contrato
	 * 
	 * @param name Nombre de los clientes
	 * @param price Precio del contrato
	 * @return Lista de clientes
	 */
	public List<Client> searchClientByNameAndPrice(final String name, final int price);

}
