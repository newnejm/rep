package com.yesserp.domain.access;

import java.io.Serializable;

import javax.persistence.*;

import com.yesserp.domain.access.Utilisateur;

/**
 * Entity implementation class for Entity: Collaborateur
 *
 */
@Entity
public class Collaborateur extends Utilisateur implements Serializable {

	
	private static final long serialVersionUID = 1L;

	public Collaborateur() {
		super();
	}

	public Collaborateur(int id_utilisateur, String login, String password,
			String nom, String prenom, String unite_gestion, String email) {
		super(id_utilisateur, login, password, nom, prenom, unite_gestion, email);
		// TODO Auto-generated constructor stub
	}
   
}
