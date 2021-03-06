package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: TypeProduitConcurrent
 *
 */
@Entity
@Table(name="crm_typcrf01")
public class TypeProduitConcurrent implements Serializable {

	
	private Long id;
	private String nom;
	
	private List<ProduitConcurrent> produitConcurrents;
	
	private static final long serialVersionUID = 1L;

	public TypeProduitConcurrent() {
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
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
	
	
	@OneToMany(mappedBy="typeProduitConcurrent",cascade=CascadeType.ALL)
	public List<ProduitConcurrent> getProduitConcurrents() {
		return produitConcurrents;
	}
	public void setProduitConcurrents(List<ProduitConcurrent> produitConcurrents) {
		this.produitConcurrents = produitConcurrents;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		TypeProduitConcurrent other = (TypeProduitConcurrent) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
	
	
	
	
}
