package com.nttdata.hibernate.persistence.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.interfaces.ContractDaoI;
import com.nttdata.hibernate.persistence.models.Client;
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

	/**
	 * Metodo que saca los clientes de un contrato concreto, a través del ID del
	 * contrato
	 * 
	 * @param contractId Id del contrato donde quiero sacar los clientes
	 * @return Clientes vinculados a ese contrato
	 */
	@Override
	public List<Client> searchClientByContract(final Long contractId) {
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where
		final Predicate pr2 = cb.gt(pJoinT.<Long>get("contractId"), contractId);

		// Consulta
		cquery.select(rootP).where(cb.and(pr2));

		cquery.orderBy(cb.desc(pJoinT.get("client")));

		// Ejecución de consulta
		return session.createQuery(cquery).getResultList();
	}
}
