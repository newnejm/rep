package com.yesserp.domain.crm;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.List;


/**
 * Entity implementation class for Entity: Service
 *
 */
@Entity
@Table(name="crm_srvcrh01")
public class Service implements Serializable {

	
	private Long id;
	private String nom;
	private String code;
	//private String description;
	private double prix;
	//private Type_travail_interne typeTravailInt;
	private TypeService typeService;
	private Taxe taxe;
	private Remise remise;

	private Compte compte;
	private List<Suivi> suivis; 
	private CommercialInterne personnels;
	private Date  date;
	private Date datefin;
	private Boolean valider;
	private String indicateur;
	private List<TabDevisService> tabDevisServices;
	private List<TabBcService> tabBcServices;
	private List<TabBlService> tabBlServices;
	private List<TabFactureService> tabFactureServices;
	private List<TabAvoirService> tabAvoirServices;




	
	private  Origine origine;
	private Statut_service statut;
	private Priorite_service priorite;
	private static final long serialVersionUID = 1L;

	public Service() {
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
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
//	public String getDescription() {
//		return this.description;
//	}
//
//	public void setDescription(String description) {
//		this.description = description;
//	}   

	
	@ManyToOne
	public TypeService getTypeService() {
		return typeService;
	}
	public void setTypeService(TypeService typeService) {
		this.typeService = typeService;
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
		Service other = (Service) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}

	
	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	public List<TabDevisService> getTabDevisServices() {
		return tabDevisServices;
	}

	public void setTabDevisServices(List<TabDevisService> tabDevisServices) {
		this.tabDevisServices = tabDevisServices;
	}

	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	public List<TabBcService> getTabBcServices() {
		return tabBcServices;
	}

	public void setTabBcServices(List<TabBcService> tabBcServices) {
		this.tabBcServices = tabBcServices;
	}

	
	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	public List<TabBlService> getTabBlServices() {
		return tabBlServices;
	}

	public void setTabBlServices(List<TabBlService> tabBlServices) {
		this.tabBlServices = tabBlServices;
	}
	
	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	public List<TabAvoirService> getTabAvoirServices() {
		return tabAvoirServices;
	}

	public void setTabAvoirServices(List<TabAvoirService> tabAvoirServices) {
		this.tabAvoirServices = tabAvoirServices;
	}

	@OneToMany(mappedBy="service",cascade=CascadeType.ALL)
	public List<TabFactureService> getTabFactureServices() {
		return tabFactureServices;
	}

	public void setTabFactureServices(List<TabFactureService> tabFactureServices) {
		this.tabFactureServices = tabFactureServices;
	}

	
	@ManyToOne
	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}

	@ManyToOne
	public Remise getRemise() {
		return remise;
	}


	public void setRemise(Remise remise) {
		this.remise = remise;
	}
	
	
	
	
	

	

	
	
	
	

@ManyToOne
	public Compte getCompte() {
		return compte;
	}

	public void setCompte(Compte compte) {
		this.compte = compte;
	}
@OneToMany(mappedBy="services" , cascade=CascadeType.ALL)
	public List<Suivi> getSuivis() {
		return suivis;
	}

	public void setSuivis(List<Suivi> suivis) {
		this.suivis = suivis;
	}
@ManyToOne
	public CommercialInterne getPersonnels() {
		return personnels;
	}

	public void setPersonnels(CommercialInterne personnels) {
		this.personnels = personnels;
	}

@Temporal(TemporalType.TIMESTAMP)
public Date getDate() {
		return date;
	}

	public void setDate(Date date2) {
		this.date = date2;
	}

@ManyToOne
public Origine getOrigine() {
		return origine;
	}

	public void setOrigine(Origine origine) {
		this.origine = origine;
	}

@ManyToOne
	public Statut_service getStatut() {
		return statut;
	}

	public void setStatut(Statut_service statut) {
		this.statut = statut;
	}
@ManyToOne
	public Priorite_service getPriorite() {
		return priorite;
	}

	public void setPriorite(Priorite_service priorite) {
		this.priorite = priorite;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Boolean getValider() {
		return valider;
	}

	public void setValider(Boolean valider) {
		this.valider = valider;
	}

	public String getIndicateur() {
		return indicateur;
	}

	public void setIndicateur(String indicateur) {
		this.indicateur = indicateur;
	}

	public double getPrix() {
		return prix;
	}

	public void setPrix(double prix) {
		this.prix = prix;
	}
	
   

}
