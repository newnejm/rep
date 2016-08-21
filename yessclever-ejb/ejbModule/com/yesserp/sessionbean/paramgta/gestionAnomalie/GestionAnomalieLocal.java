package com.yesserp.sessionbean.paramgta.gestionAnomalie;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.Anomalie;

@Local
public interface GestionAnomalieLocal {

	public void ajouterAnomalie(Anomalie anomalie);

	public void modifierAnomalie(Anomalie anomalie);


	public List<Anomalie> listeAnomalies();

}
