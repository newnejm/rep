package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Consomation;

@Local
public interface GestionConsLocal {

	void create(Consomation c);

	List<Consomation> consulter();

}
