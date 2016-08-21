package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Role
 *
 */
@Entity

public class Role implements Serializable {

	
	private int id_role;
	private String nom_role;
	private Groupe groupe;
	private List<Habilitation> habilitations;
	private static final long serialVersionUID = 1L;

	public Role() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId_role() {
		return this.id_role;
	}

	public void setId_role(int id_role) {
		this.id_role = id_role;
	}   
	public String getNom_role() {
		return this.nom_role;
	}

	public void setNom_role(String nom_role) {
		this.nom_role = nom_role;
	}
	@ManyToOne
	@JoinColumn(name="groupe_fk")
	public Groupe getGroupe() {
		return groupe;
	}
	public void setGroupe(Groupe groupe) {
		this.groupe = groupe;
	}
	@OneToMany(mappedBy = "role", cascade = CascadeType.ALL)
	public List<Habilitation> getHabilitations() {
		if (habilitations == null) {
			habilitations = new ArrayList<Habilitation>();
		}
		return habilitations;
	}
	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}
   
}
