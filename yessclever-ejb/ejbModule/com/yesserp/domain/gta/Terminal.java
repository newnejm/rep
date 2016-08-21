package com.yesserp.domain.gta;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: TypeCalucle
 * 
 */
@Entity
@Table(name = "gta_terminalfu01", uniqueConstraints = @UniqueConstraint(columnNames = { "code" }))
public class Terminal {

	private Long id;
	private String code;
	private String Libelle;
	private List<Pointage> pointages;
	private CodeGTA codeGTA ;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLibelle() {
		return Libelle;
	}

	public void setLibelle(String libelle) {
		Libelle = libelle;
	}

	@OneToMany(mappedBy = "terminal", cascade = CascadeType.ALL)
	public List<Pointage> getPointages() {
		return pointages;
	}

	public void setPointages(List<Pointage> pointages) {
		this.pointages = pointages;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

}
