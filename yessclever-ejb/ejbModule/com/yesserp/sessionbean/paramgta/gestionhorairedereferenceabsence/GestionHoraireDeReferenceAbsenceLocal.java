package com.yesserp.sessionbean.paramgta.gestionhorairedereferenceabsence;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.HoraireDeReferenceAbsence;
import com.yesserp.domain.gtaparam.JourneeType;

@Local
public interface GestionHoraireDeReferenceAbsenceLocal {
	public List<HoraireDeReferenceAbsence> findByJourneeType(JourneeType journeeType);
}
