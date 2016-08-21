package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Inventaire;
import com.yesserp.domain.gs.Inventaire_stock;

@Local
public interface GestionInv_stockLocal {

	void create(Integer key, Double double1);

	List<Inventaire_stock> consulter(Inventaire inv);

	void update(Inventaire selectedInv, Integer key, Double double1);

}
