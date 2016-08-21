package com.yesserp.domain.gs;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.*;

import com.yesserp.sessionbean.gs.GestionNotif;
import com.yesserp.type.gs.*;

/**
 * Entity implementation class for Entity: Notification
 * 
 */
@Entity
@Table(name = "gs_notif")
public class Notification implements Serializable {

	private int id;
	private String nom;
	private TypeNotif type;
	private TypeEtat etat;
	private String description;
	private Date date;

	private static final long serialVersionUID = 1L;

	public Notification() {
		super();
	}

	public Notification(String nom, TypeNotif type, String description) {
		this.nom = nom;
		this.type = type;
		this.etat = TypeEtat.nv;
		this.description = description;
	}

	@Id
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TypeEtat getEtat() {
		return etat;
	}

	public void setEtat(TypeEtat etat) {
		this.etat = etat;
	}

	public TypeNotif getType() {
		return type;
	}

	public void setType(TypeNotif type) {
		this.type = type;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

}
