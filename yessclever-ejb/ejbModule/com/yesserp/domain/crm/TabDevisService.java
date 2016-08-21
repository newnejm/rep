package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabDevisService
 *
 */
@Entity
@Table(name = "crm_tdsvrh01")
public class TabDevisService implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Devis devis;
	private Service service;
	
	private static final long serialVersionUID = 1L;

	public TabDevisService() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
	@ManyToOne
	public Devis getDevis() {
		return devis;
	}
	public void setDevis(Devis devis) {
		this.devis = devis;
	}
   
}
