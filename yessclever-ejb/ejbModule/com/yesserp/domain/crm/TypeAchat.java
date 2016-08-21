package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeAchat
 *
 */
@Entity
@Table(name="crm_tyacrh01")
public class TypeAchat implements Serializable {

	
	private Long id;
	private String nom;
	private List<Achat> achats;
	
	private static final long serialVersionUID = 1L;

	public TypeAchat() {
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
	
	@OneToMany(mappedBy="typeAchat" ,cascade=CascadeType.ALL)
	public List<Achat> getAchats() {
		return achats;
	}
	public void setAchats(List<Achat> achats) {
		this.achats = achats;
	}
   
}
