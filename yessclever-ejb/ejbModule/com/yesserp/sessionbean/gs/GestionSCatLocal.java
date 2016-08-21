package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Sous_Categorie;
import com.yesserp.type.gs.TypeLivr;

@Local
public interface GestionSCatLocal {
	void create(String nom, Categorie c);

	void create(List<Sous_Categorie> lsc, Categorie c);

	void delete(String nom);

	void delete(List<Sous_Categorie> lscd);

	Sous_Categorie consulter(String nom);

	List<Sous_Categorie> consulter();

	List<Sous_Categorie> consulter(Categorie c);

	void delete(Sous_Categorie selectedScat);

}
