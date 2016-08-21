package com.yesserp.sessionbean.pg.gestionParametrageAbsence;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageAbsence;



@Local
public interface GestionParametrageAbsenceLocal {
	
	
	public void ajouterParametrageAbsence(ParametrageAbsence i);
	public void supprimerParametrageAbsence(ParametrageAbsence i);
	public void modifierParametrageAbsence(ParametrageAbsence i);
	public List<ParametrageAbsence> AfficherTousParametrageAbsence();
	
/*
	
	public List<ParametrageAbsence> trouverParNumParametrageAbsence(String numParametrageAbsence);
	public List<ParametrageAbsence> trouverParNom(String nom);
	*/
	

	

}
