package com.yesserp.type.gs;

public enum TypeEtat {
	nv("non valider"), 
	va("valider");

	private String nom;

	TypeEtat(String nom) {
		this.nom = nom;
	}
}
