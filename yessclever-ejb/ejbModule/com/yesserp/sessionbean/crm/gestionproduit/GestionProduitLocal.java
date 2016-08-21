package com.yesserp.sessionbean.crm.gestionproduit;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Compte;
import com.yesserp.domain.crm.Concurrent;
import com.yesserp.domain.crm.Opportunite;
import com.yesserp.domain.crm.Produit;
import com.yesserp.domain.crm.ProduitConcurrent;
import com.yesserp.domain.crm.Remise;
import com.yesserp.domain.crm.Taxe;
import com.yesserp.domain.crm.TypeProduit;
import com.yesserp.domain.crm.TypeTaxe;

@Local
public interface GestionProduitLocal {


	public void ajouterProduit(Produit i);
	public void supprimerProduit(Produit i);
	public void modifierProduit(Produit i);
	public List<Produit> AfficherTousProduit();
	
	
	public Produit trouverParNomprod(String nomprod);
	public Produit trouverParCodeprod(String codeprod);
	public Produit trouverPaRref(String ref);
	

	
	public List<Opportunite> getListeOpportunite();
	public List<Remise> getListeRemise();

	
	public Opportunite ChercherOpportunite(String nomopp);
	public Remise ChercherRemise(int id);
	public void ajouterRemise(Remise i);
	public Concurrent FindOneConcurrentByProduit(Produit Produit);
	public List<Concurrent> FindConcurrentByProduit(Produit Produit);
	public TypeProduit ChercherTypeProduit(String type);
	public List<TypeProduit> getListeTypeProduit();
	public void ajouterTypeProduit(TypeProduit i);
	public List<ProduitConcurrent> FindProduitConcurrentByProduit(Produit Produit);
	public List<Taxe> AfficherTousTaxe();

	public Taxe ChercherTaxe(int type);
	public TypeTaxe ChercherTypeTaxe(String type);

	
	
}
