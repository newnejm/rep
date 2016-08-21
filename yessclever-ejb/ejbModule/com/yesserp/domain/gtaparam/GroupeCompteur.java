package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: GroupeCompteur
 * 
 */

@Entity
@Table(name = "GTA_GRPCMPT_UH01", uniqueConstraints = @UniqueConstraint(columnNames = "codegrpc"))
public class GroupeCompteur implements Serializable {

	private int idgrpc;
	private String codegrpc;
	private List<Libelle> libelles;
	private List<Compteur> compteurs;
	private Date dateeffe;
	private Date datefin;
	private Identite identite ;
	private CodeGTA codeGTA ;

	private static final long serialVersionUID = 1L;

	public GroupeCompteur() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdgrpc() {
		return this.idgrpc;
	}

	public void setIdgrpc(int idgrpc) {
		this.idgrpc = idgrpc;
	}

	public String getCodegrpc() {
		return this.codegrpc;
	}

	public void setCodegrpc(String codegrpc) {
		this.codegrpc = codegrpc;
	}

	@OneToMany(mappedBy = "groupeCompteur")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}



	@ManyToMany
	public List<Compteur> getCompteurs() {
		return compteurs;
	}

	public void setCompteurs(List<Compteur> compteurs) {
		this.compteurs = compteurs;
	}
	
	
	@Temporal(TemporalType.DATE)
	public Date getDateeffe() {
		return dateeffe;
	}

	public void setDateeffe(Date dateeffe) {
		this.dateeffe = dateeffe;
	}
	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}
	
	@ManyToOne
	@JoinColumn(name="grpcompteur")
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

}
