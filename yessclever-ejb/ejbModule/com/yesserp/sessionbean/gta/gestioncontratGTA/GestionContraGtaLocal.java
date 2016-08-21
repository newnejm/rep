package com.yesserp.sessionbean.gta.gestioncontratGTA;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ClasseEmp;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gtaparam.GroupeCompteur;
import com.yesserp.domain.gtaparam.TerminalMobile;

@Local
public interface GestionContraGtaLocal {
	public void addContratGta(ContratGta contratGta);

	public void deleteContratGta(ContratGta contratGta);

	public void modifierContratGta(ContratGta contratGta);

	public ContratGta getContratGtaByUser(Identite identite);

	public String getClassByContrat(ContratGta cg);
	
	public Object findEntity(Identite identite);
	
	//a jouter par sofien
	
	public List<ContratGta> trouverContratGtaParIdentite(Identite identite);
	public List<ContratGta> trouverHistoriqueContratGtaParIdentite(Identite identite, int n);
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<ContratGta> trouverPremiersHistoriqueContratGtaParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMax(Identite identite, Date max, int n);
	public List<ContratGta> trouverHistoriqueContratGtaParIdentiteEtDateMinMax(Identite identite, Date min, Date max, int n);
	public List<ContratGta> trouverPremiersHistoriqueContratGtaParIdentite(Identite identite, int n);
	
	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);
	
	public List<TerminalMobile> listAllTerminal();
	public List<TerminalMobile> listAllTerminalByIdentite(Identite identite);
	 public void ajouterTerminalMobile(ContratGta contratGta , TerminalMobile terminalMobile);
	


}
