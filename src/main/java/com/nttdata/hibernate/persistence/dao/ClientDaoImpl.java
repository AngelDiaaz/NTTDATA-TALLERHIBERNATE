package com.nttdata.hibernate.persistence.dao;

import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.interfaces.ClientDaoI;
import com.nttdata.hibernate.persistence.models.Client;

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
	 * Metodo que busca y devuelve los clientes que contiene el nombre que le pasamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByName(final String name) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los clientes con ese nombre
		return session.createQuery("FROM Client WHERE name='" + name + "'").list();	}

	/**
	 * Metodo que busca y devuelve los clientes que contiene el primer apellido que le pasamos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Client> searchByFirstLastName(final String firstLastName) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve los clientes con ese primer apellido
		return session.createQuery("FROM Client WHERE FIRST_LAST_NAME='" + firstLastName+ "'").list();
	}

	/**
	 * Metodo que busca y devuelve los clientes que contiene el segundo apellido que le pasamos
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
}
