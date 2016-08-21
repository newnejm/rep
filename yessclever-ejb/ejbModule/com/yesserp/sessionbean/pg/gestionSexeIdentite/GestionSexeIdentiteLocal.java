package com.yesserp.sessionbean.pg.gestionSexeIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.SexeIdentite;

@Local
public interface GestionSexeIdentiteLocal {
	public void ajouterSexeIdentite(SexeIdentite i);
	public void supprimerSexeIdentite(SexeIdentite i);
	public void modifierSexeIdentite(SexeIdentite i);
	public List<SexeIdentite> findall();

}
