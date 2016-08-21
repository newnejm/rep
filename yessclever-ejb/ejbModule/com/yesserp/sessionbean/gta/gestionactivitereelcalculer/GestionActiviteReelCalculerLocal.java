package com.yesserp.sessionbean.gta.gestionactivitereelcalculer;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.gtaparam.Filtre;

@Local
public interface GestionActiviteReelCalculerLocal {
	public List<ActiviteReelCalculer> findAll(Identite identite);

	public List<ActiviteReelCalculer> findFromDateToDate(Identite identite,
			Date date1, Date date2);

	public void ajouterActiviteReelCalculer(
			ActiviteReelCalculer activiteReelCalculer);

	public List<ActiviteReelCalculer> findActiviteReelAbsence(Filtre f, Date d);

	public List<ActiviteReelCalculer> findActiviteReelPresence(Filtre f, Date d);

	public List<Date> findAllByDate(Identite identite);

	public void deleteAll();

}