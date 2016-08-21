package com.yesserp.sessionbean.gta.gestionimputationreel;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.ImputationReelCalculer;
import com.yesserp.domain.gtaparam.Filtre;

@Local
public interface gestionImputationReelCalculerLocal {

	void ajouterImputationReelCalculer(
			ImputationReelCalculer imputationReelCalculer);

	List<ImputationReelCalculer> findImputationReel(Filtre filtre, Date d);

}
