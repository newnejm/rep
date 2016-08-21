package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Compagne
 *
 */
@Entity
@Table(name="crm_mktgrh01")
public class Marketing implements Serializable {

	
	private Long id;
	private String nom;
	private StatusMarketing status;
	private Date dateDeb;
	private Date dateFin;
	private double budgetTotal;
	private double coutFinal;
	private Devise devise;
	
	private List<Compagne> compagnes;
	
	private static final long serialVersionUID = 1L;

	public Marketing() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public String getnom() {
		return nom;
	}
	public void setnom(String nom) {
		this.nom = nom;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateDeb() {
		return dateDeb;
	}
	public void setDateDeb(Date dateDeb) {
		this.dateDeb = dateDeb;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateFin() {
		return dateFin;
	}
	public void setDateFin(Date dateFin) {
		this.dateFin = dateFin;
	}
	public double getBudgetTotal() {
		return budgetTotal;
	}
	public void setBudgetTotal(double budgetTotal) {
		this.budgetTotal = budgetTotal;
	}
	public double getCoutFinal() {
		return coutFinal;
	}
	public void setCoutFinal(double coutFinal) {
		this.coutFinal = coutFinal;
	}

	@OneToMany(mappedBy="marketing",cascade=CascadeType.ALL)
	public List<Compagne> getCompagnes() {
		return compagnes;
	}
	public void setCompagnes(List<Compagne> compagnes) {
		this.compagnes = compagnes;
	}

	
	public void setId(Long id) {
		this.id = id;
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
		Marketing other = (Marketing) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
	@ManyToOne
	public Devise getDevise() {
		return devise;
	}
	public void setDevise(Devise devise) {
		this.devise = devise;
	}
	@ManyToOne
	public StatusMarketing getStatus() {
		return status;
	}
	public void setStatus(StatusMarketing status) {
		this.status = status;
	}
	
	
   
}
