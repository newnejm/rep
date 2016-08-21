package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;



/**
 * Entity implementation class for Entity: identite
 *
 */
@Entity
@Table(name="crm_identite")
public class CommercialInterne implements Serializable {

	
	private Long id;
	private Long numedoss;
	private Date datenais;
	private String matricul;
	private String nom;
	private String prenom;
	
	private TypeCommercialInterne typeCommercialInterne;
	private List<ObjectifCommercialInterne> objectifCommercialInternes;
	private List<TravailInterne> travailInternes;
	private List<Activite_saisie> Activite_tache;
	
	
	public Long getNumedoss() {
		return numedoss;
	}
	public void setNumedoss(Long numedoss) {
		this.numedoss = numedoss;
	}
	
	@Temporal(TemporalType.DATE)
	public Date getDatenais() {
		return datenais;
	}
	public void setDatenais(Date datenais) {
		this.datenais = datenais;
	}
	public String getMatricul() {
		return matricul;
	}
	public void setMatricul(String matricul) {
		this.matricul = matricul;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public String getPrenom() {
		return prenom;
	}
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}
	
@OneToMany(mappedBy="techniciens" ,cascade=CascadeType.ALL)
	public List<Activite_saisie> getActivite_tache() {
		return Activite_tache;
	}
	public void setActivite_tache(List<Activite_saisie> activite_tache) {
		Activite_tache = activite_tache;
	}


	private static final long serialVersionUID = 1L;

	public CommercialInterne() {
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
	
	@ManyToOne
	public TypeCommercialInterne getTypeCommercialInterne() {
		return typeCommercialInterne;
	}
	public void setTypeCommercialInterne(TypeCommercialInterne typeCommercialInterne) {
		this.typeCommercialInterne = typeCommercialInterne;
	}
	
	
	
	
	
	@OneToMany(mappedBy="commercialInterne" ,cascade=CascadeType.ALL)
	public List<TravailInterne> getTravailInternes() {
		return travailInternes;
	}
	public void setTravailInternes(List<TravailInterne> travailInternes) {
		this.travailInternes = travailInternes;
	}
	
	@OneToMany(mappedBy="commercialInterne" ,cascade=CascadeType.ALL)
	public List<ObjectifCommercialInterne> getObjectifCommercialInternes() {
		return objectifCommercialInternes;
	}
	public void setObjectifCommercialInternes(
			List<ObjectifCommercialInterne> objectifCommercialInternes) {
		this.objectifCommercialInternes = objectifCommercialInternes;
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
		CommercialInterne other = (CommercialInterne) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
}
