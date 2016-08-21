package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Groupe
 * 
 */
@Entity
public class Groupe implements Serializable {

	private int id_groupe;
	private String lib_groupe;

	private List<Assignment> assignments;
	private List<Role> roles;
	private static final long serialVersionUID = 1L;

	public Groupe() {

	}

	public Groupe(int id_groupe, String lib_groupe) {
		super();
		this.id_groupe = id_groupe;
		this.lib_groupe = lib_groupe;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public int getId_groupe() {
		return this.id_groupe;
	}

	public void setId_groupe(int id_groupe) {
		this.id_groupe = id_groupe;
	}

	public String getLib_groupe() {
		return this.lib_groupe;
	}

	public void setLib_groupe(String lib_groupe) {
		this.lib_groupe = lib_groupe;
	}

	@OneToMany(mappedBy = "groupe", cascade = CascadeType.REMOVE)
	public List<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new ArrayList<Assignment>();
		}
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}

	@OneToMany(mappedBy = "groupe", cascade = CascadeType.ALL)
	public List<Role> getRoles() {
		if (roles == null) {
			roles = new ArrayList<Role>();
		}
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
