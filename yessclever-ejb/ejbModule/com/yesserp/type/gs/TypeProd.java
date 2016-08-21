package com.yesserp.type.gs;

public enum TypeProd {
	MP("matiere premiere"),
	PSF("produit semi fini"),
	PF("produit fini"),
	Marchandise("marchandise");
	
	public String nom;
	
	TypeProd(String nom)
	{
		this.nom=nom;
	}
}
