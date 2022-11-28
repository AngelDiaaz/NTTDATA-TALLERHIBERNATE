package com.nttdata.hibernate.persistence.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

/**
 * Clase Contract, entidad de tabla
 * 
 * @author Ángel Díaz Avilés
 */
@Entity
@Table(name = "TABLE_CONTRACTS")
public class Contract extends AbstractEntity implements Serializable {
	/** SERIAL VERSION */
	private static final long serialVersionUID = 1L;

	// Propiedades
	private Long contractId;
	private String dateValidity;
	private String dateExpiration;
	private int monthlyPrice;
	private Client client;

	// Getters y setters de las propiedades
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "CONTRACT_ID")
	public Long getContractId() {
		return contractId;
	}

	public void setContractId(Long contractId) {
		this.contractId = contractId;
	}

	@Column(name = "DATE_VALIDITY")
	public String getDateValidity() {
		return dateValidity;
	}

	public void setDateValidity(String dateValidity) {
		this.dateValidity = dateValidity;
	}

	@Column(name = "DATE_EXPIRATION")
	public String getDateExpiration() {
		return dateExpiration;
	}

	public void setDateExpiration(String dateExpiration) {
		this.dateExpiration = dateExpiration;
	}

	@Column(name = "MONTHLY_PRICE")
	public int getMonthlyPrice() {
		return monthlyPrice;
	}

	public void setMonthlyPrice(int monthlyPrice) {
		this.monthlyPrice = monthlyPrice;
	}

	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "CLIENT_ID", referencedColumnName = "CLIENT_ID")
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	
	@Override
	public String toString() {
		return "Contract [contractId=" + contractId + ", dateValidity=" + dateValidity + ", dateExpiration="
				+ dateExpiration + ", monthlyPrice=" + monthlyPrice + ", client=" + client + "]";
	}

	@Transient
	@Override
	public Long getId() {
		return this.contractId;
	}
}
