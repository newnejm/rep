package com.yesserp.sessionbean.crm.gestionpersonnel;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.CommercialInterne;
import com.yesserp.domain.crm.Personnel_identity;

@Local
public interface GestionPersonnelLocal {
	public List<CommercialInterne> getListePersonnel();
	public CommercialInterne Chercherpersonnel(String nompersonnel);
}
