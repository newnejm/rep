package com.yesserp.sessionbean.pg.gestionParametrageTM;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageTM;



@Local
public interface GestionParametrageTMLocal {
	
	
	public void ajouterParametrageTM(ParametrageTM i);
	public void supprimerParametrageTM(ParametrageTM i);
	public void modifierParametrageTM(ParametrageTM i);
	public List<ParametrageTM> AfficherTousParametrageTM();
	
/*
	
	public List<ParametrageTM> trouverParNumParametrageTM(String numParametrageTM);
	public List<ParametrageTM> trouverParNom(String nom);
	*/
	

	

}
