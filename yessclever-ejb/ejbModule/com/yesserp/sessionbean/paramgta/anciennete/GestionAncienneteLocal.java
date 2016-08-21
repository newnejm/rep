package com.yesserp.sessionbean.paramgta.anciennete;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.Anciennete;

@Local
public interface GestionAncienneteLocal {

	public void ajoutAnciennete(Anciennete anciennete);

	public void supprimerAnciennete(Anciennete anciennete);

	public void modifierAnciennete(Anciennete anciennete);

	public List<Anciennete> listerAnciennete();

	public Anciennete findAncienneteById(int id);

}
