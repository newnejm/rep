package com.yesserp.sessionbean.paramgta.gestionrubriquepaie;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.RubriquePaie;

@Local
public interface GestionRubriquePaieLocal {
	public void ajouterRubriquePaie(RubriquePaie rubriquePaie);

	public void modifierRubriquePaie(RubriquePaie rubriquePaie);

	public List<RubriquePaie> listeRubriquePaie();

}
