package com.nttdata.hibernate.services.interfaces;

import java.util.List;

import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.persistence.models.Contract;

/**
 * Clase interfaz ContractManagementServiceI
 * 
 * @author Ángel Díaz Avilés
 */
public interface ContractManagementServiceI {
	/**
	 * Metodo que inserta un nuevo contrato en la base de datos
	 * 
	 * @param newContract Contrato que queremos insertar
	 */
	public void insertNewContract(final Contract newContract);

	/**
	 * Metodo que actualiza un contrato en la base de datos
	 * 
	 * @param updatedContract Contrato que queremos actualizar
	 */
	public void updateContract(final Contract updatedContract);

	/**
	 * Metodo que elimina un contrato de la base de datos
	 * 
	 * @param deletedContrato Contrato que queremos eliminar
	 */
	public void deleteContract(final Contract deletedContract);

	/**
	 * Metodo que devuelve un contrato, buscandolo a traves de su id
	 * 
	 * @param contractId ID del Contrato que queremos sacar
	 * @return Contrato de la base de datos con el id
	 */
	public Contract searchById(final Long contractId);

	/**
	 * Metodo que devuelve todos los contratos de la base de datos
	 *
	 * @return List con todos los clientes
	 */
	public List<Contract> searchAll();

	/**
	 * Metodo que busqua los contratos a traves de Id del cliente al que esta
	 * asociados esos contratos
	 * 
	 * @param clientId Id del cliente que queremos sacar los contratos
	 * @return List con los contratos que estan asociados a ese cliente
	 */
	public List<Contract> searchByClient(final Long clientId);
	
	
	/**
	 * Metodo que saca los clientes de un contrato concreto, a través del ID del contrato
	 * 
	 * @param contractId Id del contrato donde quiero sacar los clientes
	 * @return Clientes vinculados a ese contrato
	 */
	public List<Client> searchClientByContract(final Long contractId);
}
