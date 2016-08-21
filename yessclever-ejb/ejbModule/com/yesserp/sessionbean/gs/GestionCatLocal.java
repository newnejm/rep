package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Sous_Categorie;

@Local
public interface GestionCatLocal {
	void create(String nom);

	void create(List<Categorie> lsc);

	void delete(String nom);

	void delete(List<Categorie> lscd);

	Categorie consulter(String nom);

	List<Categorie> consulter();

	void create(Categorie sc);

	Categorie consulter(int id);
}
