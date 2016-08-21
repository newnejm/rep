package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: ClasseEmp
 * 
 */
@Entity
@Table(name="gta_classemp")
public class ClasseEmp implements Serializable {

	private Integer id;
	private String codeClasse;
	private Date dateeffet;
	private Date DateFin = new Date(1099, 12, 31);
	private Identite identite ;
	private CodeGTA codeGTA ;
	
	private static final long serialVersionUID = 1L;
	

	public ClasseEmp() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	
	

	public Date getDateFin() {
		return DateFin;
	}

	public void setDateFin(Date dateFin) {
		DateFin = dateFin;
	}

	public String getCodeClasse() {
		return codeClasse;
	}

	public void setCodeClasse(String codeClasse) {
		this.codeClasse = codeClasse;
	}
	
	
	@ManyToOne
	@JoinColumn(name = "classemp")
	public Identite getIdentite() {
		return identite;
	}

	public void setIdentite(Identite identite) {
		this.identite = identite;
	}
	@Temporal(TemporalType.DATE)
	public Date getDateeffet() {
		return dateeffet;
	}

	public void setDateeffet(Date dateeffet) {
		this.dateeffet = dateeffet;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

}
