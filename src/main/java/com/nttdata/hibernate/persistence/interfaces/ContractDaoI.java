package com.nttdata.hibernate.persistence.interfaces;

import java.util.List;

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

}
