package com.yesserp.type.gs;

public enum TypeLivr {

	standar("standar"), 
	FIFO("FIFO"), 
	LIFO("LIFO");

	private String nom;

	TypeLivr(String nom) {
		this.nom = nom;
	}
}
