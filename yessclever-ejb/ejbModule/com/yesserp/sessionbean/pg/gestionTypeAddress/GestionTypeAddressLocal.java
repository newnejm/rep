package com.yesserp.sessionbean.pg.gestionTypeAddress;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.TypeAddress;



@Local
public interface GestionTypeAddressLocal {
	
	
	public void ajouterTypeAddress(TypeAddress i);
	public void supprimerTypeAddress(TypeAddress i);
	public void modifierTypeAddress(TypeAddress i);
	public List<TypeAddress> AfficherTousTypeAddress();
	
/*
	
	public List<TypeAddress> trouverParNumTypeAddress(String numTypeAddress);
	public List<TypeAddress> trouverParNom(String nom);
	*/
	

	

}
