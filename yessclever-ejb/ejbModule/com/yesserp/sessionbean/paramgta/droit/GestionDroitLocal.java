package com.yesserp.sessionbean.paramgta.droit;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.Droit;

@Local
public interface GestionDroitLocal {
	
	public void ajoutDroit(Droit droit);

	public void supprimerDroit(Droit droit);

	public void modifierDroit(Droit droit);

	public List<Droit> listerDroit();

	public Droit findDroitById(int id);

}
