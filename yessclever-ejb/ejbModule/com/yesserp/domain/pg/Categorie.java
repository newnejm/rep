package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Query;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity(name="pg_Categoriee")
@Table(name="pg_Categoriee")
public class Categorie implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Categorie() {	
	}
	
	private	int code;
	EntityManager em;
	private List<Libelle> libelles;
	
	@Id
	public int getCode() {
		
		Query q2=em.createNativeQuery("insert into pg_pays (code) values (1)");
		q2.executeUpdate();
	
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	@OneToMany(mappedBy = "categoriee")
	public List<Libelle> getLibelles() {
		return libelles;
	}
	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	 ;
	
}
