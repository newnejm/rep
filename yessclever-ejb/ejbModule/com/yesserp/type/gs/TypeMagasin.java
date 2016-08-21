package com.yesserp.type.gs;

public enum TypeMagasin {

	standar("standar"),
	froid("equipé de refri"),
	chaud("equipé de chauffage");
	
	private String nom;
	
	TypeMagasin(String nom)
	{
		this.nom=nom;
	}
}
