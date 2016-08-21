package com.yesserp.sessionbean.ga.infosphysiques;

import javax.ejb.Local;
import com.yesserp.domain.ga.*;

@Local
public interface GestionInfosPhysiquesLocal {

	public void ajouterInfosPhysiques(InfosPhysiques physiques);

	public void supprimerInfosPhysiques(InfosPhysiques physiques);

	public void modifierInfosPhysiques(InfosPhysiques physiques);

	public InfosPhysiques trouverParId(Long id);

	public InfosPhysiques trouverParIdentite(Identite identite);

}
