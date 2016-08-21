package com.yesserp.sessionbean.pg.gestionTypeContratIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.TypeContratIdentite;

@Local
public interface GestionTypeContratIdentiteLocal {
	public void ajouterTypeContratIdentite(TypeContratIdentite i);
	public void supprimerTypeContratIdentite(TypeContratIdentite i);
	public void modifierTypeContratIdentite(TypeContratIdentite i);
	public List<TypeContratIdentite> findall();


}
