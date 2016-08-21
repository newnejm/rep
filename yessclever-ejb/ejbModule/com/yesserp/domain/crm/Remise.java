package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: remise
 *
 */
@Entity
@Table(name="crm_rmserh01")
public class Remise implements Serializable {

	   
	
	private Long id;
	private int valremis;
	private Date datedeb;
	private Date datefin;
	
	private List<Produit> produits;
	private List<Service> services;

	
	private static final long serialVersionUID = 1L;

	public Remise() {
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
	public int getValremis() {
		return this.valremis;
	}

	public void setValremis(int valremis) {
		this.valremis = valremis;
	}
	
	@OneToMany(mappedBy="remise",cascade=CascadeType.ALL)
	public List<Produit> getProduits() {
		return produits;
	}
	public void setProduits(List<Produit> produits) {
		this.produits = produits;
	}



	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	
	@OneToMany(mappedBy="remise",cascade=CascadeType.ALL)
	public List<Service> getServices() {
		return services;
	}

	public void setServices(List<Service> services) {
		this.services = services;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(valremis);
		result = prime * result + (int) (temp ^ (temp >>> 32));
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
		Remise other = (Remise) obj;
		if (Double.doubleToLongBits(valremis) != Double
				.doubleToLongBits(other.valremis))
			return false;
		return true;
	}


	
	
	
   
}
