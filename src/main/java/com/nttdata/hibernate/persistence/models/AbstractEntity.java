package com.nttdata.hibernate.persistence.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.Transient;

/**
 * Clase entidad abstracta, AbstractEntity
 * 
 * @author Ángel Díaz Avilés
 *
 */
@MappedSuperclass
public abstract class AbstractEntity implements Serializable {

	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	/** Auditoría | Usuario que actualiza */
	private String updatedClient;

	/**
	 * Getter del ID
	 * 
	 * @return Long
	 */
	@Transient
	public abstract Long getId();

	/**
	 * @return the updatedClient
	 */
	@Column(name = "CLIENT_UPDATED_USER", nullable = false)
	public String getUpdatedClient() {
		return updatedClient;
	}

	/**
	 * @param updatedClient the updatedClient to set
	 */
	public void setUpdatedClient(String updatedClient) {
		this.updatedClient = updatedClient;
	}
}
