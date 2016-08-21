package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TauxCompte
 *
 */
@Entity
@Table(name="crm_txcpuf01")
public class TauxCompte implements Serializable {

	
	private Long id;
	private Date date;
	private Compte compte;
	private Taux taux;
	
	
	private static final long serialVersionUID = 1L;

	public TauxCompte() {
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
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}
	
	
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}
	
	
	@ManyToOne
	public Taux getTaux() {
		return taux;
	}
	public void setTaux(Taux taux) {
		this.taux = taux;
	}
   
}
