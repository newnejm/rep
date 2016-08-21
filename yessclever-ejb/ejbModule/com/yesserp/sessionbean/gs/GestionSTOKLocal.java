package com.yesserp.sessionbean.gs;

import javax.ejb.Local;

import com.yesserp.domain.gs.STOK;
import com.yesserp.type.gs.TypeEval;

@Local
public interface GestionSTOKLocal {

	STOK consulter();

	void create(STOK s);

	void update(STOK s);
	
	double calc(TypeEval typeeval);
}
