package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabAvoirService
 *
 */
@Entity
@Table(name="crm_tasvuh01")
public class TabAvoirService implements Serializable {

	
	private Long id;
	private int quantite;

	private Avoir avoir;
    private Service service;
	
	private static final long serialVersionUID = 1L;

	public TabAvoirService() {
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
	public int getQuantite() {
		return this.quantite;
	}

	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}
	
	@ManyToOne
	public Avoir getAvoir() {
		return avoir;
	}
	public void setAvoir(Avoir avoir) {
		this.avoir = avoir;
	}
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
   
}
