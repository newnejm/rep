package com.yesserp.sessionbean.paramgta.gestionhorairesdereference;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.HoraireDeReference;

@Local
public interface GestionHeureDeReferenceLocal {
	public void ajouterHoraireDeRef(List<HoraireDeReference> horaireDeReferences);
	public void modifierHoraireDeRef(HoraireDeReference horaireDeReference);
	public List<HoraireDeReference> findAll();
}
