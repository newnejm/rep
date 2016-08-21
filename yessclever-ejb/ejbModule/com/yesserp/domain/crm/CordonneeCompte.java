package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: CordonneeCompte
 *
 */
@Entity
@Table(name="crm_crdnrh04")
public class CordonneeCompte implements Serializable {

	
	private Long id;
	private String rue;
	private String ville;
	private int codepays;
	private double longitude;
	private double latitude;
	private int num;
	private String residence;
	private String  bloc;
	private String temoin;
	private Date datedeb;
	private Date datefin;
	private String gouvernaurat;
	private String pays;

	
	private Compte compte;
	
	
	private static final long serialVersionUID = 1L;
	
	
	
    public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getResidence() {
		return residence;
	}
	public void setResidence(String residence) {
		this.residence = residence;
	}
	public String getBloc() {
		return bloc;
	}
	public void setBloc(String bloc) {
		this.bloc = bloc;
	}
	public String getTemoin() {
		return temoin;
	}
	public void setTemoin(String temoin) {
		this.temoin = temoin;
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
	public String getGouvernaurat() {
		return gouvernaurat;
	}
	public void setGouvernaurat(String gouvernaurat) {
		this.gouvernaurat = gouvernaurat;
	}
	public String getPays() {
		return pays;
	}
	public void setPays(String pays) {
		this.pays = pays;
	}

	
	
	
	
	public String getRue() {
		return rue;
	}
	public void setRue(String rue) {
		this.rue = rue;
	}
	public String getVille() {
		return ville;
	}
	public void setVille(String ville) {
		this.ville = ville;
	}
	public int getCodepays() {
		return codepays;
	}
	public void setCodepays(int codepays) {
		this.codepays = codepays;
	}
	public double getLongitude() {
		return longitude;
	}
	public void setLongitude(double longitude) {
		this.longitude = longitude;
	}
	public double getLatitude() {
		return latitude;
	}
	public void setLatitude(double latitude) {
		this.latitude = latitude;
	}
	
	@ManyToOne
	public Compte getCompte() {
		return compte;
	}
	public void setCompte(Compte compte) {
		this.compte = compte;
	}


	public CordonneeCompte() {
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
   
}
