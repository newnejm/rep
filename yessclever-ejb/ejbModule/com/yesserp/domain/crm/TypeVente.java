package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeVente
 *
 */
@Entity
@Table(name="crm_tyvtrh01")
public class TypeVente implements Serializable {

	
	private Long id;
	private String nom;
	private List<Vente> ventes;
	private static final long serialVersionUID = 1L;

	public TypeVente() {
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
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy="typeVente" ,cascade=CascadeType.ALL)
	public List<Vente> getVentes() {
		return ventes;
	}
	public void setVentes(List<Vente> ventes) {
		this.ventes = ventes;
	}
   
}
