package com.yesserp.sessionbean.gta.gestionexceptionsemaine;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ExceptionSemaineType;
import com.yesserp.domain.gtaparam.SemaineType;

@Local
public interface GestionExceptionSemaineLocal {
	public void ajouterExceptionSemaineType(ExceptionSemaineType exceptionSemaineType);
	public void supprimerExceptionSemaineType(ExceptionSemaineType exceptionSemaineType);
	public void modifierExceptionSemaineType(ExceptionSemaineType exceptionSemaineType);
	public ExceptionSemaineType findExceptionSemaineTypeById(int id);
	public List<ExceptionSemaineType> findAllExceptionSemaineType();
	public SemaineType findExceptionForSemainetype(Identite identite,Date date);
	public List<ExceptionSemaineType> findExceptionSemaineForEmployee(Identite identite);

}
