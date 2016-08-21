package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Prod;

@Local
public interface GestionProdLocal {

	void create(Prod p);

	void delete(String code);

	void create(List<Prod> lpa);

	void delete(List<Prod> lpd);

	List<Prod> consulter();

	Prod consulter(int id);

	void delete(Prod selectedProd);

}
