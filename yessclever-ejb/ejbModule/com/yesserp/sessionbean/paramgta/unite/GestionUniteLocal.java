package com.yesserp.sessionbean.paramgta.unite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.Unite;

@Local
public interface GestionUniteLocal {
	
	public void ajoutUnite(Unite unite);

	public void supprimerUnite(Unite unite);

	public void modifierUnite(Unite unite);

	public List<Unite> listerUnite();

	public Unite findUniteById(int id);
}
