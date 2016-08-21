package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.pg.CodeGTA;

/**
 * Entity implementation class for Entity: CodeCalendrier
 * 
 */
@Entity
@Table(name = "gta_codeCal")
public class CodeCalendrier implements Serializable {

	private int idCalendrier;
	private String code;
	private List<Calendrier> calendriers;
	private List<Identite> identites;
	private CodeGTA codeGTA ;
	private static final long serialVersionUID = 1L;

	public CodeCalendrier() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdCalendrier() {
		return this.idCalendrier;
	}

	public void setIdCalendrier(int idCalendrier) {
		this.idCalendrier = idCalendrier;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	@ManyToMany
	public List<Calendrier> getCalendriers() {
		return calendriers;
	}

	public void setCalendriers(List<Calendrier> calendriers) {
		this.calendriers = calendriers;
	}

	@OneToMany(mappedBy = "codeCalendrier")
	public List<Identite> getIdentites() {
		return identites;
	}

	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
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
		CodeCalendrier other = (CodeCalendrier) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		return true;
	}

	@ManyToOne
	public CodeGTA getCodeGTA() {
		return codeGTA;
	}

	public void setCodeGTA(CodeGTA codeGTA) {
		this.codeGTA = codeGTA;
	}

	
	

}
