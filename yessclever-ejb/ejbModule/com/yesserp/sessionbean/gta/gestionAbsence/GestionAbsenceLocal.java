package com.yesserp.sessionbean.gta.gestionAbsence;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Absence;

@Local
public interface GestionAbsenceLocal {
	public void ajouterAbsence(Absence absence);

	public void modifierAbsence(Absence absence);

	public void suprimerAbsence(Absence absence);

	public List<Absence> finAll(Identite identite);

	public List<Absence> findFromDateToDate(Identite identite, Date dateDebut,
			Date dateFin);

}
