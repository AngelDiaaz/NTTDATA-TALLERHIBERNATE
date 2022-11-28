package com.nttdata.hibernate.persistence.dao;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.interfaces.ClientDaoI;
import com.nttdata.hibernate.persistence.models.Client;
import com.nttdata.hibernate.persistence.models.Contract;

/**
 * Clase DAO cliente, ClientDaoImpl
 * 
 * @author Ángel Díaz Avilés
 */
public class ClientDaoImpl extends CommonDaoImpl<Client> implements ClientDaoI {

	// Session de la base de datos
	private Session session;

	/**
	 * Constructor cliente DAO
	 * 
	 * @param session Session de la base de datos
	 */
	public ClientDaoImpl(Session session) {
		super(session);
		this.session = session;
	}

	/**
	 * Metodo que busca y devuelve los clientes que contiene el nombre que le
	 * pasamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los clientes con ese nombre
		return session.createQuery("FROM Client WHERE name='" + name + "'").list();
	}

	/**
	 * Metodo que busca y devuelve los clientes que contiene el primer apellido que
	 * le pasamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstLastName(final String firstLastName) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los clientes con ese primer apellido
		return session.createQuery("FROM Client WHERE FIRST_LAST_NAME='" + firstLastName + "'").list();
	}

	/**
	 * Metodo que busca y devuelve los clientes que contiene el segundo apellido que
	 * le pasamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchBySecondLastName(final String secondLastName) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuele los clientes con ese segundo apellido
		return session.createQuery("FROM Client WHERE SECOND_LAST_NAME='" + secondLastName + "'").list();
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
		final CriteriaBuilder cb = session.getCriteriaBuilder();
		final CriteriaQuery<Client> cquery = cb.createQuery(Client.class);
		final Root<Client> rootP = cquery.from(Client.class);
		final Join<Client, Contract> pJoinT = rootP.join("contract");

		// Where
		final Predicate pr1 = cb.equal(pJoinT.getParent().<String>get("name"), name);
		final Predicate pr2 = cb.gt(pJoinT.<Double>get("monthlyPrice"), price);

		// Consulta
		cquery.select(rootP).where(cb.and(pr1, pr2));

		cquery.orderBy(cb.desc(pJoinT.get("client")));

		// Ejecución de consulta
		return session.createQuery(cquery).getResultList();
	}
}
