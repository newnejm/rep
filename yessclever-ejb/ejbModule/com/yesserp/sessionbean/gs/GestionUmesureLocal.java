package com.yesserp.sessionbean.gs;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gs.Umesure;

@Local
public interface GestionUmesureLocal {

	public void delete(Umesure umes);

	public void create(Umesure umes);

	public Umesure consult(String nom);

	public List<Umesure> consult();
}
