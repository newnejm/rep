package com.yesserp.sessionbean.paramgta.gestionDescCycleTravail;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dao.BaseDao;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescCycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.SemaineType;

@Local
public interface GestionDescCycleTravailLocal  {

	public List<DescCycleTravail> getDescCycleTravailsByCycleTravail(CycleTravail cycleTravail);
	
	public DescCycleTravail ajouterDescCycleTravail(DescCycleTravail i);

	void supprimerDescCycleTravail(DescCycleTravail i);

	public List<DescCycleTravail> AfficherTousDescCycleTravail();

	void modifierDescCycleTravail(DescCycleTravail i);

	void associateSemaineTypeToDescCycleTravail(Integer idDescCycleTravail,
			Integer idSemaineType, Integer index);

	void associateJourneeTypeToDescCycleTravail(Integer idDescCycleTravail,
			Integer idJourneeType, Integer index);

	
	
	
}
