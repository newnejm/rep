package com.yesserp.sessionbean.paramgta.gestiongroupeimputation;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.Imputation;

@Local
public interface GestionGroupeImputationLocal {
	
	//crud
	public void ajouterGroupeImputation(GroupeImputation groupeImputation);

	public void modifierGroupeImputation(GroupeImputation groupeImputation);
	public void supprimerGroupeImputation(GroupeImputation groupeImputation);



	public List<GroupeImputation> listeGroupeImpuation();

	public GroupeImputation findGroupeImputationByCode(String code);
	public List<GroupeImputation> findAllImputationByIdentite(Identite identite,int n);
	
	
	//
	public List<GroupeImputation> trouverGroupesImputationsParIdentite(Identite identite);
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentite(Identite identite, int n);
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<GroupeImputation> trouverPremiersHistoriqueGroupesImputationsParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMax(Identite identite, Date max, int n);
	public List<GroupeImputation> trouverHistoriqueGroupesImputationsParIdentiteEtDateMinMax(Identite identite, Date min, Date max, int n);
	public List<GroupeImputation> trouverPremiersHistoriqueGroupesImputationssParIdentite(Identite identite, int n);
	

	



	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

	public List<Imputation> findImputationsByGroupeImputations(
			GroupeImputation groupeImputation);


}
