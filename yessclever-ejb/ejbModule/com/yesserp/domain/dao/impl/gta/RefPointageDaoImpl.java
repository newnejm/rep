package com.yesserp.domain.dao.impl.gta;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.Query;

import com.yesserp.domain.dao.gta.RefPointageDao;
import com.yesserp.domain.dao.impl.BaseDaoImpl;
import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gtaparam.DescJourneeType;

@Stateless
@LocalBean
public class RefPointageDaoImpl extends BaseDaoImpl<RefPointage> implements
		RefPointageDao {
	
	@Override
	public List<RefPointage> findRefPointageByDescJourneeType(DescJourneeType descJourneeType){
		if(descJourneeType != null){
			Query query = em.createQuery("select r from RefPointage r where r.descJourneeType = :djt");
			query.setParameter("djt", descJourneeType);
			return query.getResultList();
		}
		return null;
	}

}
