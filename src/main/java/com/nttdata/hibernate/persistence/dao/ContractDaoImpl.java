package com.nttdata.hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.interfaces.ContractDaoI;
import com.nttdata.hibernate.persistence.models.Contract;

/**
 * Clase Dao Contract, ContractDaoImpl
 * 
 * @author Ángel Díaz Avilés
 */
public class ContractDaoImpl extends CommonDaoImpl<Contract> implements ContractDaoI {

	// Session de la base de datos
	private Session session;

	/**
	 * Constructor contract DAO
	 * 
	 * @param session Session de la base de datos
	 */
	public ContractDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Metodo que busqua los contratos a traves de Id del cliente al que esta
	 * asociados esos contratos
	 * 
	 * @param clientId Id del cliente que queremos sacar los contratos
	 * @return List con los contratos que estan asociados a ese cliente
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Contract> searchByClient(final Long clientId) {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los contratos asociados a un cliente
		return session.createQuery("FROM Contract WHERE CLIENT_ID='" + clientId + "'").list();
	}

}
