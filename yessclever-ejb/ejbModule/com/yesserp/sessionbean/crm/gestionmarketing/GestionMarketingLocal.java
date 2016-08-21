package com.yesserp.sessionbean.crm.gestionmarketing;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Compagne;
import com.yesserp.domain.crm.Devise;
import com.yesserp.domain.crm.Marketing;
import com.yesserp.domain.crm.StatusCompagne;
import com.yesserp.domain.crm.StatusMarketing;

@Local
public interface GestionMarketingLocal {
	public void ajouterMarketing(Marketing marketing);

	public void supprimerMarketing(Marketing marketing);

	public void modifierMarketing(Marketing marketing);

	public List<Marketing> AfficherTousMarketing();
	public Marketing afficherMarketingParId(Long id);

	public Devise ChercherDevise(String devise);

	public List<Compagne> FindMarketingByCompagne(Marketing marketing);
	public List< Devise> afficherDevise() ;
	public StatusMarketing ChercherStatusMarketing(String status) ;
}
