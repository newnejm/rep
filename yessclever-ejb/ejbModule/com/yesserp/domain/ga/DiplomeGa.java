package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DiplomeGa
 *
 */
@Entity
@Table(name="ga_diplrf01")

public class DiplomeGa implements Serializable {

	
	private Long id;
	private Date dateffet;
	private String niveau;
	private String specialite;
	private String mension;
	private String ecole;
	private String description;
	private Identite identite;
	private static final long serialVersionUID = 1L;

	public DiplomeGa() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	} 
	@Temporal(TemporalType.DATE)
	public Date getDateffet() {
		return this.dateffet;
	}

	public void setDateffet(Date dateffet) {
		this.dateffet = dateffet;
	}   
	public String getNiveau() {
		return this.niveau;
	}

	public void setNiveau(String niveau) {
		this.niveau = niveau;
	}
	@Column(name="speciali")
	public String getSpecialite() {
		return this.specialite;
	}

	public void setSpecialite(String specialite) {
		this.specialite = specialite;
	}   
	public String getMension() {
		return this.mension;
	}

	public void setMension(String mension) {
		this.mension = mension;
	}   
	public String getEcole() {
		return this.ecole;
	}

	public void setEcole(String ecole) {
		this.ecole = ecole;
	} 
	@Column(name="descript")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	@ManyToOne(fetch = FetchType.EAGER, optional = true )
	@JoinColumn(name = "dossempl")
	public Identite getIdentite() {
		return this.identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}

   
}
