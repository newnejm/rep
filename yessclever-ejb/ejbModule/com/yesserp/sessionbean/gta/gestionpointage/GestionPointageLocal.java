package com.yesserp.sessionbean.gta.gestionpointage;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Pointage;
import com.yesserp.domain.gta.Terminal;
import com.yesserp.domain.gta.TypePointage;

@Local
public interface GestionPointageLocal {

	public void createPointage(Pointage pointage);

	public void updatePointage(Pointage pointage);

	public void deletePointage(Pointage pointage);

	public Pointage findPointageById(int id  );
	public List<Pointage> findPointageByIdentite(Identite identite );

	public List<Pointage> listPointage();

	public List<Pointage> listPointageByDate(Date date);

	public List<Pointage> findPointageFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin);

	public List<Pointage> findByDate(Identite identite, Date date);

	public List<Pointage> findBetweenHours(Identite identite, Date date,
			Date heureDeb, Date heureFin);

	public void SauvegarderTypePointage(TypePointage sens);
	
	public void SauvegarderTerminal(Terminal terminal);
	public TypePointage findTypePointage(String nom);
	public Terminal findTerminal(String nom);
	
	public List<TypePointage> ChercherSensPointage();
	public List<Terminal> ChercherTerminaux();
	
	public void SupprimerTypePointage(TypePointage sens);
	public void SupprimerTerminal(Terminal terminal);
	public void ModifierTypePointage(TypePointage sens) ;
	public void ModifierTerminal(Terminal terminal);
	
}
