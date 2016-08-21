package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Magasin;
import com.yesserp.type.gs.TypeMagasin;

@Local
public interface GestionMagasinLocal {

	void create(Magasin m);

	Magasin consulter(String nom);

	void delete(Magasin m);

	List<Magasin> consulter();

	void create(List<Magasin> lma);

	void delete(List<Magasin> lmd);

	void update(Magasin m, String editadres, String editdesc,
			TypeMagasin edittype);

}
