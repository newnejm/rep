package com.yesserp.sessionbean.crm.gestionservice;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Personnel_identity;
import com.yesserp.domain.crm.Priorite_service;
import com.yesserp.domain.crm.Remise;
import com.yesserp.domain.crm.Service;
import com.yesserp.domain.crm.Statut_service;
import com.yesserp.domain.crm.TypeService;
import com.yesserp.domain.crm.Origine;

@Local
public interface GestionServiceLocal {

	public void ajouterService(Service i);

	public void supprimerService(Service i);

	public void modifierService(Service i);
	public void  ajouterTypeServices(TypeService i);

	public List<Service> AfficherTousService();

	public Service trouverParNom(String nom);

	public Service trouverParCode(String code);

	public List<TypeService> getListeTypeService();

	public List<Statut_service> getListeStatut();
	
	public List<Priorite_service> getListpriorite();
	public List<Remise>  getListremise();
	
	public TypeService ChercherTypeService(String nom);
	public List<Service> AfficherserviceActif();
	public List<Service> AfficherserviceNonActif();
	
	//public List<Origine> getListeTypeTravailInt() ;
	
	public Origine ChercherOrigine(String nom);
	
	public Statut_service ChercherStatut(String nom);
	
	public Priorite_service Chercherpriorite(String nom);
	
	public List<Origine> getListeorigine();

	public Service ChercherService(String nom);

	public List<Statut_service> getstatutinit();
	


}
