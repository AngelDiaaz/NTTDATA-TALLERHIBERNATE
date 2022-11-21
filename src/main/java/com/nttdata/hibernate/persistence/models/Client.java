package com.nttdata.hibernate.persistence.models;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Client, entidad de tabla
 *
 * @author Ángel Díaz Avilés
 */
@Entity
@Table(name = "TABLE_CLIENTS")
public class Client extends AbstractEntity implements Serializable {
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	// Propiedades
	private Long clientId;
	private String name;
	private String firstLastName;
	private String secondLastName;
	private String dni;
	private List<Contract> contract;

	// Getters y setters de las propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CLIENT_ID")
	public Long getClientId() {
		return clientId;
	}

	public void setClientId(Long id) {
		this.clientId = id;
	}

	@Column(name = "NAME")
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Column(name = "FIRST_LAST_NAME")
	public String getFirstLastName() {
		return firstLastName;
	}

	public void setFirstLastName(String firstLastName) {
		this.firstLastName = firstLastName;
	}

	@Column(name = "SECOND_LAST_NAME")
	public String getSecondLastName() {
		return secondLastName;
	}

	public void setSecondLastName(String secondLastName) {
		this.secondLastName = secondLastName;
	}

	@Column(name = "DNI", nullable = false, unique = true)
	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	@OneToMany(mappedBy = "client")
	public List<Contract> getContract() {
		return contract;
	}

	public void setContract(List<Contract> contract) {
		this.contract = contract;
	}

	// toString
	@Override
	public String toString() {
		return "Cliente [id=" + clientId + ", name=" + name + ", firstLastName=" + firstLastName + ", secondLastName="
				+ secondLastName + ", dni=" + dni + "]";
	}

	@Transient
	@Override
	public Long getId() {
		return this.clientId;
	}
}
