package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TabBlFactureService
 *
 */
@Entity
@Table(name="crm_tlsvuf01")
public class TabBlService implements Serializable {

	
	private Long id;
	private int quantite;
	
	private Bl bl;
	private Service service;
	
	private static final long serialVersionUID = 1L;

	public TabBlService() {
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
	public Bl getBl() {
		return bl;
	}
	public void setBl(Bl bl) {
		this.bl = bl;
	}
	
	@ManyToOne
	public Service getService() {
		return service;
	}
	public void setService(Service service) {
		this.service = service;
	}
   
}
