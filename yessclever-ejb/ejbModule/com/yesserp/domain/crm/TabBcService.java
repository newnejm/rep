package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabBcService
 *
 */
@Entity
@Table(name="crm_tbsvrh01")
public class TabBcService implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Bc bc;
	private Service service;
	
	private static final long serialVersionUID = 1L;

	public TabBcService() {
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
	public Bc getBc() {
		return bc;
	}
	public void setBc(Bc bc) {
		this.bc = bc;
	}
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
   
}
