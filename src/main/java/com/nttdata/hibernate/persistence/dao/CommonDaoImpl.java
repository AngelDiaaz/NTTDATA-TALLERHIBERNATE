package com.nttdata.hibernate.persistence.dao;

import java.lang.reflect.ParameterizedType; 
import java.util.List;

import org.hibernate.Session;

import com.nttdata.hibernate.persistence.interfaces.CommonDaoI;
import com.nttdata.hibernate.persistence.models.AbstractEntity;

/**
 * Clase con el DAO genérico, CommonDaoImpl
 * 
 * @author Ángel Díaz Avilés
 */
public abstract class CommonDaoImpl<T extends AbstractEntity> implements CommonDaoI<T> {

	/** Tipo de clase */
	private Class<T> entityClass;

	/** Sesión de conexión a BD */
	private Session session;

	/**
	 * Constructor de la clase
	 * 
	 * @param session Session de la base de datos
	 */
	@SuppressWarnings("unchecked")
	protected CommonDaoImpl(Session session) {
		setEntityClass((Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0]);
		this.session = session;
	}

	/**
	 * Metodo insert, que inserta un objeto en la base de datos
	 */
	@Override
	public void insert(final T paramT) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Inserta el objeto en la base de datos
		session.save(paramT);
		session.flush();

		// Commit
		session.getTransaction().commit();
	}

	/**
	 * Metodo que modifica un objeto de la base de datos
	 */
	@Override
	public void update(final T paramT) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Updatea el objeto en la base de datos
		session.saveOrUpdate(paramT);

		// Commit
		session.getTransaction().commit();
	}

	/**
	 * Metodo que elimina un objeto de la base de datos
	 */
	@Override
	public void delete(final T paramT) {

		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Elimina el objeto
		session.delete(paramT);

		// Commit
		session.getTransaction().commit();
	}

	/**
	 * Metodo que busca un objeto en la base de datos, a través del id
	 */
	@Override
	public T searchById(final Long id) {

		// Verificación de sesión abierta.
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve el objeto que contiene esa id
		return session.get(this.entityClass, id);
	}

	/**
	 * Metodo que lista todos los objetos de la base de datos
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> searchAll() {
		// Verificación de sesión abierta
		if (!session.getTransaction().isActive()) {
			session.getTransaction().begin();
		}

		// Devuelve todos los objetos
		return session.createQuery("FROM "  + this.entityClass.getName()).list();
	}
	
	/**
	 * @return the entityClass
	 */
	public Class<T> getEntityClass() {
		return entityClass;
	}

	/**
	 * @param entityClass
	 *            the entityClass to set
	 */
	public void setEntityClass(Class<T> entityClass) {
		this.entityClass = entityClass;
	}
}
