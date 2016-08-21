package com.yesserp.domain.pg;

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

import com.yesserp.domain.gtaparam.Libelle;


@Entity
@Table(name="pg_TypeContrat")
public class TypeContrat  implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public TypeContrat() {
		super();
	}
	
	   private	Description_poste description_poste ;
	   private int code_contrat ;
	   private double taux_offre;
	   private String unite_offre;
	    private Date dateffet ;   
	    private Date datefin ;
	   private String designation_type;
	   private double forfait_type;
	   private int duree_type;
	   private List<Libelle> libelles;

	   
	   
	   
	   @Id   
	public int getCode_contrat() {
		return code_contrat;
	}
	   
	public void setCode_contrat(int code_contrat) {
		this.code_contrat = code_contrat;
	}
	
	public double getTaux_offre() {
		return taux_offre;
	}
	
	public void setTaux_offre(double taux_offre) {
		this.taux_offre = taux_offre;
	}
	
	public String getUnite_offre() {
		return unite_offre;
	}
	
	public void setUnite_offre(String unite_offre) {
		this.unite_offre = unite_offre;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateffet() {
		return dateffet;
	}
	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}
	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	public String getDesignation_type() {
		return designation_type;
	}
	
	public void setDesignation_type(String designation_type) {
		this.designation_type = designation_type;
	}
	
	public double getForfait_type() {
		return forfait_type;
	}
	
	public void setForfait_type(double forfait_type) {
		this.forfait_type = forfait_type;
	}
	
	public int getDuree_type() {
		return duree_type;
	}
	
	public void setDuree_type(int duree_type) {
		this.duree_type = duree_type;
	}
	
	@OneToMany(mappedBy = "typeContrat")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	@ManyToOne(cascade = CascadeType.ALL)
    public Description_poste getDescription_poste() {
		return description_poste;
	}

	public void setDescription_poste(Description_poste description_poste) {
		this.description_poste = description_poste;
	}
	//
}
