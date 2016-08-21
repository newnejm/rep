package com.yesserp.sessionbean.gta.gestionexceptionplage;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.ExceptionPlageHoraire;

@Local
public interface GestionExceptionPlageLocal {
	public void ajouterExceptionPlageHoraire(ExceptionPlageHoraire exceptionPlageHoraire);
	public void supprimerExceptionPlageHoraire(ExceptionPlageHoraire exceptionPlageHoraire);
	public void modifierExceptionPlageHoraire(ExceptionPlageHoraire exceptionPlageHoraire);
	public ExceptionPlageHoraire findExceptionPlageHoraireById(int id);
	public List<ExceptionPlageHoraire> findAllExceptionPlageHoraire();

}
