package com.yesserp.sessionbean.ga.telephone;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Telephone;

@Local
public interface GestionTelephoneLocal {

	public void ajouterTelephone(Telephone telephone);

	public void supprimerTelephone(Telephone telephone);

	public void modifierTelephone(Telephone telephone);

	public Telephone trouverParId(Long id);

	public List<Telephone> trouverTelephonesParIdentite(Identite identite);
}
