package com.yesserp.sessionbean.crm.gestionconcurrence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Concurrent;
import com.yesserp.domain.crm.CordonneeConcurrent;
import com.yesserp.domain.crm.Produit;
import com.yesserp.domain.crm.ProduitConcurrent;
import com.yesserp.domain.crm.TravailInterne;
import com.yesserp.domain.crm.TypeProduitConcurrent;

@Local
public interface GestionConcurrenceLocal {

	public void ajouterConcurrent(Concurrent i);
	
	public void ajouterCordonneeConcurrent(CordonneeConcurrent i);


	public void supprimerConcurrent(Concurrent i);

	public void supprimerCordonneeConcurrent(CordonneeConcurrent i);

	public void modifierConcurrent(Concurrent i);

	public void modifierCordonneeConcurrent(CordonneeConcurrent i);

	public List<Concurrent> AfficherTousConcurrent();

	public List<Concurrent> trouverParNom(String nom);

	public List<Produit> getTousProduit();

	public Produit ChercherProduit(String nom);

	public List<CordonneeConcurrent> FindCordoneeByConcurrent(Concurrent Concurrent);

	public CordonneeConcurrent FindOneCordoneeByConcurrent(Concurrent Concurrent);

	public List<ProduitConcurrent> FindProduitConcurrentByConcurrent(
			Concurrent Concurrent);

	public ProduitConcurrent FindOneProduitConcurrentByConcurrent(Concurrent Concurrent);

	public List<TypeProduitConcurrent> getTousTypeProduitConcurrent();



}
