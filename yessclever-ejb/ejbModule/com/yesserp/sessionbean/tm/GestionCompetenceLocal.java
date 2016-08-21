package com.yesserp.sessionbean.tm;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.tm.Competence;
import com.yesserp.domain.tm.Offre;


@Local
public interface GestionCompetenceLocal {
	

	public void ajouterCompetence();		
	public List<Competence> findCompetencesById(Offre of);
    public void deleteCompetence(Offre of);

}
