package com.nttdata.hibernate.persistence.interfaces;

import java.util.List;

import com.nttdata.hibernate.persistence.models.Client;

/**
 * Clase interfaz ClientDaoI
 *
 * @author Ángel Díaz Avilés
 */
public interface ClientDaoI extends CommonDaoI<Client> {
	
	/**
	 * Devuelve los clientes que tienen ese nombre en la base de datos
	 * 
	 * @param name Nombre de los clientes que queremos obtener de la base de datos
	 * @return Clientes que contienen ese name
	 */
	public List<Client> searchByName(final String name);
	
	/**
	 * Devuelve los clientes que tienen ese primer apellido en la base de datos
	 * 
	 * @param firstLastName Primer apellido de los clientes que queremos obtener de la base de datos
	 * @return Clientes que contienen ese firstLastName
	 */
	public List<Client> searchByFirstLastName(final String firstLastName);
	
	/**
	 * Devuelve los clientes que tienen ese segundo apellido en la base de datos
	 * 
	 * @param secondLastName Segundo apellido de los clientes que queremos obtener de la base de datos
	 * @return Clientes que contienen ese secondLastName
	 */
	public List<Client> searchBySecondLastName(final String secondLastName);
}
