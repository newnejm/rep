package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Utilistateur
 *
 */
@Entity

public class Utilisateur implements Serializable {

	
	private int id_utilisateur;
	private String login;
	private String password;
	private String nom;
	private String prenom;
	private String unite_gestion;
	private String email;
	private List<Assignment> assignments;
	private Company company;
	private static final long serialVersionUID = 1L;

	public Utilisateur() {
		super();
	}   
	
	public Utilisateur(int id_utilisateur, String login, String password,
			String nom, String prenom, String unite_gestion, String email) {
		super();
		this.id_utilisateur = id_utilisateur;
		this.login = login;
		this.password = password;
		this.nom = nom;
		this.prenom = prenom;
		this.unite_gestion = unite_gestion;
		this.email = email;
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_utilisateur() {
		return this.id_utilisateur;
	}

	public void setId_utilisateur(int id_utilisateur) {
		this.id_utilisateur = id_utilisateur;
	}   
	public String getLogin() {
		return this.login;
	}

	public void setLogin(String login) {
		this.login = login;
	}   
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}   
	public String getPrenom() {
		return this.prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}   
	public String getUnite_gestion() {
		return this.unite_gestion;
	}

	public void setUnite_gestion(String unite_gestion) {
		this.unite_gestion = unite_gestion;
	}   
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}


    @ManyToOne
    @JoinColumn(name="company_fk")
	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	@OneToMany(mappedBy="utilisateur", cascade = CascadeType.REMOVE)
	public List<Assignment> getAssignments() {
		if (assignments == null) {
			assignments = new ArrayList<Assignment>();
		}
		return assignments;
	}

	public void setAssignments(List<Assignment> assignments) {
		this.assignments = assignments;
	}
   
}
