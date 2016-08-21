package com.yesserp.sessionbean.crm.gestioncompagne;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Action;
import com.yesserp.domain.crm.CommercialInterne;
import com.yesserp.domain.crm.Compagne;
import com.yesserp.domain.crm.Opportunite;
import com.yesserp.domain.crm.TravailInterne;
import com.yesserp.domain.crm.TypeCompagne;
import com.yesserp.domain.crm.StatusCompagne;;

@Local
public interface GestionCompagneLocal {

	public void ajouterCompagne(Compagne i);

	public void ajouterTravailInterne(TravailInterne i);

	public void supprimerCompagne(Compagne i);

	public void modifierCompagne(Compagne i);

	public List<Compagne> AfficherTousCompagne();

	public List<Compagne> trouverParNom(String nom);

	public List<TypeCompagne> getType();

	public TypeCompagne ChercherTypeCompagne(String type);

	public TypeCompagne findTypeCompagneById(int id);

	public CommercialInterne findById(Long i);

	public Opportunite FindOneOpportuniteByCompagne(Compagne Compagne);

	public List<Opportunite> FindOpportuniteByCompagne(Compagne Compagne);
	public List<Action> FindActionByCompagne(Compagne Compagne);
	
	public void ajouterTypeCompagne(TypeCompagne i);
	public void ajouterStatusCompagne(StatusCompagne status);
	public  Compagne afficherCompagneParNom(String nom);
	public StatusCompagne ChercherStatusCompagne(String status);
	public List<StatusCompagne> getStatus() ;
}
