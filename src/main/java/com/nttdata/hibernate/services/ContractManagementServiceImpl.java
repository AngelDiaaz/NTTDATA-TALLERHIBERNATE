package com.nttdata.hibernate.services;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.dao.ContractDaoImpl;
import com.nttdata.hibernate.persistence.interfaces.ContractDaoI;
import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.persistence.models.Contract;
import com.nttdata.hibernate.services.interfaces.ContractManagementServiceI;

/**
 * Clase de implementacion de servicios del Contrato,
 * ContractManagementServiceImpl
 * 
 * @author Ángel Díaz Avilés
 */
public class ContractManagementServiceImpl implements ContractManagementServiceI {
	/** Contract Dao */
	private ContractDaoI contractDao;

	/**
	 * Constructor ContractManagementServiceImpl
	 */
	public ContractManagementServiceImpl(final Session session) {
		this.contractDao = new ContractDaoImpl(session);
	}

	/**
	 * Metodo que inserta un nuevo contrato en la base de datos
	 * 
	 * @param newContract Contrato que queremos insertar
	 */
	@Override
	public void insertNewContract(Contract newContract) {
		// Si el cliente no es nulo y su id si
		if (newContract != null && newContract.getId() == null) {

			// Inserta el nuevo cliente
			contractDao.insert(newContract);
		}
	}

	/**
	 * Metodo que actualiza un contrato en la base de datos
	 * 
	 * @param updatedContract Contrato que queremos actualizar
	 */
	@Override
	public void updateContract(Contract updatedContract) {
		// Si el cliente no es nulo y su id si
		if (updatedContract != null && updatedContract.getId() != 0) {

			// Actualiza el cliente
			contractDao.update(updatedContract);
		}
	}

	/**
	 * Metodo que elimina un contrato de la base de datos
	 * 
	 * @param deletedContrato Contrato que queremos eliminar
	 */
	@Override
	public void deleteContract(Contract deletedContract) {
		// Si el cliente no es nulo y su id si
		if (deletedContract != null && deletedContract.getId() != 0) {

			// Eliminamos el cliente
			contractDao.delete(deletedContract);
		}
	}

	/**
	 * Metodo que devuelve un contrato, buscandolo a traves de su id
	 * 
	 * @param contractId ID del Contrato que queremos sacar
	 * @return Contrato de la base de datos con el id
	 */
	@Override
	public Contract searchById(Long contractId) {
		Contract contract = null;

		// Si el id es diferente de 0
		if (contractId != 0) {

			// Cliente con el ID
			contract = contractDao.searchById(contractId);
		}
		return contract;
	}

	/**
	 * Metodo que devuelve todos los contratos de la base de datos
	 *
	 * @return List con todos los clientes
	 */
	@Override
	public List<Contract> searchAll() {
		return contractDao.searchAll();
	}

	/**
	 * Metodo que busqua los contratos a traves de Id del cliente al que esta
	 * asociados esos contratos
	 * 
	 * @param clientId Id del cliente que queremos sacar los contratos
	 * @return List con los contratos que estan asociados a ese cliente
	 */
	@Override
	public List<Contract> searchByClient(Long clientId) {
		List<Contract> contract = new ArrayList<>();

		// Si el id es diferente de 0
		if (clientId != 0) {

			// Cliente con el ID
			contract = contractDao.searchByClient(clientId);
		}
		return contract;
	}
	
	/**
	 * Metodo que saca los clientes de un contrato concreto, a través del ID del contrato
	 * 
	 * @param contractId Id del contrato donde quiero sacar los clientes
	 * @return Clientes vinculados a ese contrato
	 */
	@Override
	public List<Client> searchClientByContract(final Long contractId) {
		List<Client> client = null;

		// Si el id es diferente de 0
		if (contractId != 0) {

			// Cliente con el ID
			client = contractDao.searchClientByContract(contractId);
		}
		return client;
	}
}
