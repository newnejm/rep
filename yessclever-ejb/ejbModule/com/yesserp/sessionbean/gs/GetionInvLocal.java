package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Inventaire;

@Local
public interface GetionInvLocal {

	List<Inventaire> consulter();

	Inventaire consulter(int id);

	void update(Inventaire inventaire);

	void create();

	void delete(int id);

}
