package com.yesserp.sessionbean.pg.gestionSituationContratIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.SituationContratIdentite;

@Local
public interface GestionSituationContratIdentiteLocal {
	public void ajouterSituationContratIdentite(SituationContratIdentite i);
	public void supprimerSituationContratIdentite(SituationContratIdentite i);
	public void modifierSituationContratIdentite(SituationContratIdentite i);
	public List<SituationContratIdentite> findall();

}
