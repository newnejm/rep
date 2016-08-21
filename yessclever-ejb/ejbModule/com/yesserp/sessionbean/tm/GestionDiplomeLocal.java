package com.yesserp.sessionbean.tm;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.Diplome;
import com.yesserp.domain.tm.Offre;

@Local
public interface GestionDiplomeLocal {
	public void ajouterDiplome();	
	public List<Diplome> findDiplomesById(Offre Of);
	public void deleteDiplome(Offre of);
	
	

}
