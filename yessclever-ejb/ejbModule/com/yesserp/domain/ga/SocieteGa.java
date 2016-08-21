package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SocieteGa
 *
 */
@Entity
@Table(name="ga_socirh01")

public class SocieteGa implements Serializable {

	
	private Long id;
	private String code;
	private List<Identite> identites;
	
	private static final long serialVersionUID = 1L;

	public SocieteGa() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   
	   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}
	
	@OneToMany(mappedBy = "societe", cascade = CascadeType.REMOVE)
	public List<Identite> getIdentites() {
		return identites;
	}
	public void setIdentites(List<Identite> identites) {
		this.identites = identites;
	}
   
}
