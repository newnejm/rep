package com.yesserp.sessionbean.pg.gestionTempsDeService;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.TempsDeService;



@Local
public interface GestionTempsDeServiceLocal {
	
	
	public void ajouterTempsDeService(TempsDeService i);
	public void supprimerTempsDeService(TempsDeService i);
	public void modifierTempsDeService(TempsDeService i);
	public List<TempsDeService> AfficherTousTempsDeService();
	
/*
	
	public List<TempsDeService> trouverParNumTempsDeService(String numTempsDeService);
	public List<TempsDeService> trouverParNom(String nom);
	*/
	

	

}
