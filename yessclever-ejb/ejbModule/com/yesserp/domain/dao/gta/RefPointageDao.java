package com.yesserp.domain.dao.gta;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.dao.BaseDao;
import com.yesserp.domain.entities.RefPointage;
import com.yesserp.domain.gtaparam.DescJourneeType;

@Local
public interface RefPointageDao extends BaseDao<RefPointage> {

	List<RefPointage> findRefPointageByDescJourneeType(
			DescJourneeType descJourneeType);

}
