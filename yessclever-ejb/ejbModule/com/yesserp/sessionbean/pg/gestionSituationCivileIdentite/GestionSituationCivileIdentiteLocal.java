package com.yesserp.sessionbean.pg.gestionSituationCivileIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.SituationCivileIdentite;
@Local
public interface GestionSituationCivileIdentiteLocal {
	public void ajouterSituationCivileIdentite(SituationCivileIdentite i);
	public void supprimerSituationCivileIdentite(SituationCivileIdentite i);
	public void modifierSituationCivileIdentite(SituationCivileIdentite i);
	public List<SituationCivileIdentite> findall();
}
