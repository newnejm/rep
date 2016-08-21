package com.yesserp.sessionbean.ga.infosindividuelles;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.InfosIndividuelles;

@Local
public interface GestionInfosIndividuellesLocal {

	public void ajouterInfosIndividuelles(InfosIndividuelles individuelles);

	public void supprimerInfosIndividuelles(InfosIndividuelles individuelles);

	public void modifierInfosIndividuelles(InfosIndividuelles individuelles);

	public InfosIndividuelles trouverParId(Long id);

	public InfosIndividuelles trouverParIdentite(Identite identite);
}
