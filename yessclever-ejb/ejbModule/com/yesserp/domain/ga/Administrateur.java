package com.yesserp.domain.ga;

import java.io.Serializable;
import java.lang.String;
import java.util.List;

import javax.persistence.*;

import com.yesserp.domain.gta.Jobs;
import com.yesserp.domain.gta.Jobscreate;

/**
 * Entity implementation class for Entity: Admin
 *
 */
@Entity
@Table(name = "administrateur")
public class Administrateur implements Serializable {

	   
	
	private int adminId;
	private String nom;
	private String login;
	private String password;
	private String mail;
	private String statut;
	private static final long serialVersionUID = 1L;
	private List<Jobs>listjobs;
	private List<Jobscreate>jobscreates;
	

	public Administrateur() {
		super();
	}   
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getId_admin() {
		return this.adminId;
	}

	public void setId_admin(int adminId) {
		this.adminId = adminId;
	}   
	public String getNom() {
		return this.nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
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
	public String getMail() {
		return this.mail;
	}

	public void setMail(String mail) {
		this.mail = mail;
	}   
	public String getStatut() {
		return this.statut;
	}

	public void setStatut(String statut) {
		this.statut = statut;
	}
	@ManyToMany(fetch = FetchType.LAZY,cascade={CascadeType.ALL})
	public List<Jobs> getListjobs() {
		return listjobs;
	}
	public void setListjobs(List<Jobs> listjobs) {
		this.listjobs = listjobs;
	}
	/**
	 * @return the jobscreates
	 */
	@OneToMany(mappedBy="admin")
	public List<Jobscreate> getJobscreates() {
		return jobscreates;
	}
	/**
	 * @param jobscreates the jobscreates to set
	 */
	public void setJobscreates(List<Jobscreate> jobscreates) {
		this.jobscreates = jobscreates;
	}


   
}
