package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity(name="pg_TypeDePointagee")
@Table(name="pg_TypeDePointagee")
public class TypeDePointage implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public TypeDePointage() {	
	}
	
	private	int code;

	private List<Libelle> libelles;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@OneToMany(mappedBy = "typeDePointage")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}

	
	
	
	
}
