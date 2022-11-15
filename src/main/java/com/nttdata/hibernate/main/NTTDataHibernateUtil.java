package com.nttdata.hibernate.main;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

/**
 * Clase de configuración NTTDataHibernateUtil
 * 
 * @author Ángel Díaz Avilés
 */
public class NTTDataHibernateUtil {

	/** Factoría de sesiones */
	private static final SessionFactory SESSION_FACTORY;

	/**
	 * Constructor privado
	 */
	private NTTDataHibernateUtil() {
	}

	/**
	 * Generación de factoría de sesiones
	 */
	static {
		try {
			// Generación de configuración
			SESSION_FACTORY = new Configuration().configure().buildSessionFactory();

		} catch (final Exception ex) {
			// Error de inicio
			System.err.println("[ERROR] Configuración de Hibernate - " + ex);
			throw new ExceptionInInitializerError();
		}
	}

	/**
	 * Devuelve las factorias de sesiones
	 * 
	 * @return SessionFactory
	 */
	public static SessionFactory getSessionFactory() {
		return SESSION_FACTORY;
	}

}
