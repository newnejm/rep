 package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;
import com.yesserp.domain.gtaparam.Libelle;

@Entity
@Table(name="pg_Emploie")
public class Emploie implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Emploie() {
		super();
	}
	
	private	int id ;
	private	int code;
	private List<Libelle> libelles;
	private	String type;
	private	List<Poste> poste ;
	private	Person person ;
	
	
	
	@Id   
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}
	
	@OneToMany(mappedBy = "emploie")
	public List<Libelle> getLibelles() {
		return libelles;
	}

	public void setLibelles(List<Libelle> libelles) {
		this.libelles = libelles;
	}
	
	
	@OneToMany(targetEntity=Poste.class,mappedBy="emploie",cascade=CascadeType.ALL)
	public List<Poste> getPoste() {
		return poste;
	}
	
	public void setPoste(List<Poste> poste) {
		this.poste = poste;
	}
	
	@ManyToOne
	public Person getPerson() {
		return person;
	}
	public void setPerson(Person person) {
		this.person = person;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	

	
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	

	//
}
