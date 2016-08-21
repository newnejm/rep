package com.yesserp.domain.crm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Vente
 *
 */
@Entity
@Table(name="crm_vnterh01")
public class Vente implements Serializable {

	
	private Long id;
	private Date date;
	private double montant; 
	private List<Facture> factures;
	private TypeVente typeVente;

	
	
	private static final long serialVersionUID = 1L;

	public Vente() {
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
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDate() {
		return this.date;
	}

	public void setDate(Date date) {
		this.date = date;
	}   
	public double getMontant() {
		return this.montant;
	}

	public void setMontant(double montant) {
		this.montant = montant;
	}
	
	@OneToMany(mappedBy="vente")
	public List<Facture> getFactures() {
		return factures;
	}
	public void setFactures(List<Facture> factures) {
		this.factures = factures;
	}
	
	@ManyToOne
	public TypeVente getTypeVente() {
		return typeVente;
	}
	public void setTypeVente(TypeVente typeVente) {
		this.typeVente = typeVente;
	}
   
}
