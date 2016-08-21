package com.yesserp.sessionbean.paramgta.gestionFormuleCompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.FormuleCompteur;
import com.yesserp.domain.gtaparam.ParamClass;

@Local
public interface GestionFormuleCompteurLocal {
	public void ajouterFormuleCompteur(FormuleCompteur formuleCompteur);

	public void modifierFormuleCompteur(FormuleCompteur formuleCompteur);

	public void ajouterParmClass(ParamClass paramClass);

	public FormuleCompteur findFormuleCompteurByCode(String code);

	public List<FormuleCompteur> listeFormuleCompteurs();

	public FormuleCompteur getFormuleByCompteur(Compteur cmp);

	public FormuleCompteur getFormuleByContrat(ContratGta contratGta);

	public ClasseEmp getClasseEmpByFormule(FormuleCompteur fc);
 
	public ParamClass getParmByCompteur(Compteur c ,Date d);
	
}
