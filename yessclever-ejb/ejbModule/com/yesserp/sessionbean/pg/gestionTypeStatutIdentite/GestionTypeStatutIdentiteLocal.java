package com.yesserp.sessionbean.pg.gestionTypeStatutIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.TypeStatutIdentite;

@Local
public interface GestionTypeStatutIdentiteLocal {
	public void ajouterTypeStatutIdentite(TypeStatutIdentite i);
	public void supprimerTypeStatutIdentite(TypeStatutIdentite i);
	public void modifierTypeStatutIdentite(TypeStatutIdentite i);
	public List<TypeStatutIdentite> findall();

}
