package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Opportunite
 *
 */
@Entity
@Table(name="crm_opptrh01")
public class Opportunite implements Serializable {

	   
	
	private Long id;
	private String nomopp;
	private String type;
	private Date date;
	
	private Compte compte;
	private List<Produit> produits ;
	private Compagne compagne;
	
	
	private static final long serialVersionUID = 1L;

	public Opportunite() {
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
	public String getNomopp() {
		return this.nomopp;
	}

	public void setNomopp(String nomopp) {
		this.nomopp = nomopp;
	}   
	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}  
	
	@Temporal(TemporalType.TIMESTAMP)
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
	
	@OneToMany(mappedBy="opportunite",cascade=CascadeType.ALL)

	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomopp == null) ? 0 : nomopp.hashCode());
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
		Opportunite other = (Opportunite) obj;
		if (nomopp == null) {
			if (other.nomopp != null)
				return false;
		} else if (!nomopp.equals(other.nomopp))
			return false;
		return true;
	}

	@ManyToOne
	public Compagne getCompagne() {
		return compagne;
	}

	public void setCompagne(Compagne compagne) {
		this.compagne = compagne;
	}
	
	
	
	
   
}
