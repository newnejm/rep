package com.yesserp.sessionbean.tm.gestionidentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;

import com.yesserp.domain.tm.Offre;

@Local
public interface GestionIdentitLocal {
	public List<Identite> findAll();
	public void delete(Identite iden);
	public Identite findById(Offre of);
	public Identite findManagerById(Identite idn);
	
	public Identite findById(Identite iden);
}
