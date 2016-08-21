package com.yesserp.sessionbean.gs;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Lot;
import com.yesserp.domain.gs.Stock;
import com.yesserp.type.gs.TypeLivr;

@Local
public interface GestionLotLocal {
	void create(Lot lot);

	void create(List<Lot> llot);

	void delete(Lot lot);

	void delete(List<Lot> llot);

	List<Lot> consulter();

	List<Lot> consulter(Stock s);

	Lot consuler(String code);

	void update(Lot l, Date den, Date dlim, double lotqte, double qterebu,
			String descrebu);

	List<Lot> consulter(Stock stock, int x);

	void update(Lot l);
}
