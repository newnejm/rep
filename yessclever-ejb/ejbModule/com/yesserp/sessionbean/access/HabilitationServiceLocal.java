package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Habilitation;


@Local
public interface HabilitationServiceLocal {

	public void creeHabilitation(Habilitation habilitation);
	public void modifierHabilitation(Habilitation habilitation);
	public void supprimerHabilitation(Habilitation habilitation);
	public Habilitation trouverHabilitationById(int id);
	public List<Habilitation> listHabilitations();
}
