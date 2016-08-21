
package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gta.CalculGta;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: CodeJour
 *
 */
@Entity
@Table(name="GTA_CJP_UF01")
public class CodeJour implements Serializable {

	
	private int idcj;
	private String codecj;
	private List<SemaineType> semaineTypes;
	private List<Filtre> filtres;
	private List<Libelle> libelles;
	private List<SemaineJournees> semaineJournees;
	private List<CalculGta> calculGtas;
	private CodeGTA codeGTA ;
	private List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes;
	private static final long serialVersionUID = 1L;

	public CodeJour() {
		super();
	}   
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdcj() {
		return this.idcj;
	}

	public void setIdcj(int idcj) {
		this.idcj = idcj;
	}   
	public String getCodecj() {
		return this.codecj;
	}

	public void setCodecj(String codecj) {
		this.codecj = codecj;
	}   
	
	@ManyToMany(mappedBy="codeJours")
	public List<SemaineType> getSemaineTypes() {
		return semaineTypes;
	}
	public void setSemaineTypes(List<SemaineType> semaineTypes) {
		this.semaineTypes = semaineTypes;
	}
	@ManyToMany(mappedBy="codeJours")
	public List<Filtre> getFiltres() {
		return filtres;
	}
	public void setFiltres(List<Filtre> filtres) {
		this.filtres = filtres;
	}
	
	
	@OneToMany(mappedBy = "codeJour")
    public List<JourneeTypeDescSemaineType> getJourneeTypeDescSemaineTypes() {
		return journeeTypeDescSemaineTypes;
	}
	public void setJourneeTypeDescSemaineTypes(
			List<JourneeTypeDescSemaineType> journeeTypeDescSemaineTypes) {
		this.journeeTypeDescSemaineTypes = journeeTypeDescSemaineTypes;
	}
	
	
	
	@OneToMany(mappedBy="codeJour", cascade=CascadeType.ALL, fetch = FetchType.EAGER)
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codecj == null) ? 0 : codecj.hashCode());
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
		CodeJour other = (CodeJour) obj;
		if (codecj == null) {
			if (other.codecj != null)
				return false;
		} else if (!codecj.equals(other.codecj))
			return false;
		return true;
	}
	@OneToMany(mappedBy="codeJour")
	public List<SemaineJournees> getSemaineJournees() {
		return semaineJournees;
	}
	public void setSemaineJournees(List<SemaineJournees> semaineJournees) {
		this.semaineJournees = semaineJournees;
	}
	@OneToMany(mappedBy="codeJour")
	public List<CalculGta> getCalculGtas() {
		return calculGtas;
	}
	public void setCalculGtas(List<CalculGta> calculGtas) {
		this.calculGtas = calculGtas;
	}
	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}
	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}
	
	
	
	
   
}
