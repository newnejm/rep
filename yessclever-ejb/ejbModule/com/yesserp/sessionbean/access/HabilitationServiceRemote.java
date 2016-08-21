package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Remote;

import com.yesserp.domain.access.Habilitation;

@Remote
public interface HabilitationServiceRemote {

	public void creeHabilitation(Habilitation habilitation);
	public void modifierHabilitation(Habilitation habilitation);
	public void supprimerHabilitation(Habilitation habilitation);
	public Habilitation trouverHabilitationById(int id);
	public List<Habilitation> listHabilitations();
}
