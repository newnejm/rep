package com.yesserp.domain.crm;

import java.io.Serializable;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Active_saisie
 *
 */
@Entity
@Table(name="crm_actiuh01")
public class Activite_saisie implements Serializable {

	
	private int id;
	private CommercialInterne techniciens;
	private static final long serialVersionUID = 1L;

	public Activite_saisie() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}
	@ManyToOne
	public CommercialInterne getTechniciens() {
		return techniciens;
	}
	public void setTechniciens(CommercialInterne techniciens) {
		this.techniciens = techniciens;
	}
   
}
