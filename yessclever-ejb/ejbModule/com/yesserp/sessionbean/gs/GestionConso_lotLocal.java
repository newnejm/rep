package com.yesserp.sessionbean.gs;

import javax.ejb.Local;

import com.yesserp.domain.gs.Consomation_lot;

@Local
public interface GestionConso_lotLocal {

	void create(Consomation_lot cl);

}
