package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Integer;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabFactureService
 *
 */
@Entity
@Table(name="crm_tfsvhf01")
public class TabFactureService implements Serializable {

	
	private Long id;
	private Integer quantite;
	
	private Facture facture;
	private Service service;
	private static final long serialVersionUID = 1L;

	public TabFactureService() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	public Integer getQuantite() {
		return this.quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	

	@ManyToOne
	public Facture getFacture() {
		return facture;
	}
	public void setFacture(Facture facture) {
		this.facture = facture;
	}
	
	
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
	
}
