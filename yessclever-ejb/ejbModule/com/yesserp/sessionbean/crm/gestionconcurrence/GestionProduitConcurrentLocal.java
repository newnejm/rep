package com.yesserp.sessionbean.crm.gestionconcurrence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Concurrent;
import com.yesserp.domain.crm.ProduitConcurrent;
import com.yesserp.domain.crm.TypeProduitConcurrent;

@Local
public interface GestionProduitConcurrentLocal {

	public void ajouterProduitConcurrent(ProduitConcurrent i);

	public void supprimerProduitConcurrent(ProduitConcurrent i);

	public void modifierProduitConcurrent(ProduitConcurrent i);

	public List<ProduitConcurrent> AfficherTousProduitConcurrent();

	public List<Concurrent> getTousConcurrent();

	public Concurrent ChercherConcurrent(String nom);

	public TypeProduitConcurrent ChercherTypeProduitConcurrent(String type);

	public void ajouterTypeProduitConcurrent(TypeProduitConcurrent i);

}
