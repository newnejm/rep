package com.yesserp.sessionbean.crm.gestionSuivie;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.SuivieAction;

@Local
public interface GestionSuivieLocal {

	public void ajouterSuivi(SuivieAction Suivie);

	public void supprimerSuivi(SuivieAction Suivie);

	public void modifierSuivi(SuivieAction Suivie);

	public List<SuivieAction> AfficherTousSuivie();

	public SuivieAction afficherSuivieParId(Long id);

	public SuivieAction afficherSuivieParDescription(String description);

}
