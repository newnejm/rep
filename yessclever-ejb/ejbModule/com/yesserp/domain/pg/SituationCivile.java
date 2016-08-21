package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;




@Entity(name="pg_SituationCivile")
@Table(name="pg_SituationCivile")
public class SituationCivile implements Serializable{
	
	private static final long serialVersionUID = 1L;
	

	private String code ;
	private List<Libelle> libelles;
	
	public SituationCivile() {
		super();
	}

	
	
	
	@Id
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	
	
	@OneToMany(mappedBy = "situationCivile")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	

}
