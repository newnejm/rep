package com.yesserp.sessionbean.tm.gestionformationpl;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.*;
@Local
public interface GestionFormationplLocal {
	public List<FormationPl> findAll();
	public void updateFormation(String titre,Date debut,Date fin,String nvtitre,Date nvdebut,Date nvfin,String heuredebut,String heurefin);
    public void addFormation(FormationPl formation);
    public  Identite findIdentite(String titre,Date debut,Date fin);
    public  FormationPl findById(String titre,Date debut,Date fin);
}
