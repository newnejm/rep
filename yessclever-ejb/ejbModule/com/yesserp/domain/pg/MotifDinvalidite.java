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





@Entity
@Table(name="pg_MotifDinvalidite")
public class MotifDinvalidite  implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public MotifDinvalidite () {	
	}
	
	
	
	private	int code;
	private List<Libelle> libelles;

	
	
	
	@Id
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	
	
	@OneToMany(mappedBy = "motifDinvalidite")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	
	
	
	
}
