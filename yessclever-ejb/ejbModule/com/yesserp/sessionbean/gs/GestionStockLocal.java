package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeEval;
import com.yesserp.type.gs.TypeLivr;

@Local
public interface GestionStockLocal {

	Stock consulter(int id);

	void update(Stock s,double nsec,TypeLivr t);

	void update(Stock s,double qte);

	double calc(Stock stock,TypeEval selectedTypeval);

	List<Stock> consulter();

	void delete(int id);
}
