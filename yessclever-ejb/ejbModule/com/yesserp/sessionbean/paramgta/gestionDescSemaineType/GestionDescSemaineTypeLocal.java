package com.yesserp.sessionbean.paramgta.gestionDescSemaineType;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dao.BaseDao;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescSemaineType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.SemaineType;

@Local
public interface GestionDescSemaineTypeLocal extends BaseDao<DescSemaineType> {

	public List<DescSemaineType> getDescSemaineTypesBySemaineType(SemaineType semaineType);

	public void associateJourneeTypeToDescSemaineType(Integer id,
			JourneeType journeeType, Integer idcj);
	
	public void ajouterDescSemaineType(DescSemaineType i);

	public	void supprimerDescSemaineType(DescSemaineType i);

	
	
	
}
