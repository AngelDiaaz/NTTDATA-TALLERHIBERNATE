package com.nttdata.hibernate.persistence.interfaces;

import java.util.List;

import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.persistence.models.Contract;

/**
 * Clase interfaz ContractDaoI
 *
 * @author Ángel Díaz Avilés
 */
public interface ContractDaoI extends CommonDaoI<Contract> {

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
