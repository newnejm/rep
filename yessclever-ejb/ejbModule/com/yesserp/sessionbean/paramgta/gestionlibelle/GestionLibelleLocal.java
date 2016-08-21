package com.yesserp.sessionbean.paramgta.gestionlibelle;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.ActiviteAbsence;

import com.yesserp.domain.pg.Filiale;
import com.yesserp.domain.pg.Module;
import com.yesserp.domain.pg.ParametrageAlerte;
import com.yesserp.domain.pg.ParametrageModuleGlobale;
import com.yesserp.domain.pg.Societe;
import com.yesserp.domain.gtaparam.ActivitePresence;

import com.yesserp.domain.gtaparam.GroupeImputation;
import com.yesserp.domain.gtaparam.ImputaCentreCout;
import com.yesserp.domain.gtaparam.ImputaCodeFact;
import com.yesserp.domain.gtaparam.ImputaCompte;
import com.yesserp.domain.gtaparam.ImputaSousCompte;
import com.yesserp.domain.gtaparam.Imputation;
import com.yesserp.domain.gtaparam.Libelle;

@Local
public interface GestionLibelleLocal {
	public void ajoutLibelle(Libelle libelle);

	public void supprimerLibelle(Libelle libelle);

	public void modifierLibelle(Libelle libelle);

	public List<Libelle> listerLibelle();

	public Libelle findLibelleById(int id);

	public List<Libelle> findLibelleByPlageHoraire(int id);

	public List<Libelle> findLibelleByCodeJour(int idcj);

	public List<Libelle> findLibelleByjourneeType(int idjt);
	
	public List<Libelle> findLibelleByjourneeType2(int idjt2);

	public List<Libelle> findLibelleByCycleTravail(int idct);
	
	public List<Libelle> findLibelleBySexeIdentite(long id);
	public List<Libelle> findLibelleByQualiteIdentite(long id);
	public List<Libelle> findLibelleBySituationCivileIdentite(long id);
	public List<Libelle> findLibelleByTypeStatutIdentite(long id);
	public List<Libelle> findLibelleByTypeContratIdentite(long id);
	public List<Libelle> findLibelleByNatureContratIdentite(long id);
	public List<Libelle> findLibelleBySituationContratIdentite(long id);
	public List<Libelle> findLibelleByPosteAffectationIdentite(long id);
	public List<Libelle> findLibelleByUOAffectationIdentite(long id);
	public List<Libelle> findLibelleByEmploiAffectationIdentite(long id);
	public List<Libelle> findLibelleByCategorieAffectationIdentite(long id);
	public List<Libelle> findLibelleByTypePieceIdentite(long id);
	public List<Libelle> findLibelleByActivitePresence(
			int id);
	
	public List<Libelle> findLibelleByGroupeActivite(int idga);


	public List<Libelle> findLibelleByParametrageAlerte(
			ParametrageAlerte parametrageAlerte);
	
	
	public List<Libelle> findLibelleBySociete(
			Societe societe);
	
	public List<Libelle> findLibelleByModule(
			Module module);
	
	public List<Libelle> findLibelleByParametrageModuleGlobale(
			ParametrageModuleGlobale parametrageModuleGlobale);
	
	
	public List<Libelle> findLibelleByFiliale(
			Filiale filiale);
	
	

	public List<Libelle> findLibelleByActiviteAbsence(
			ActiviteAbsence activiteAbsence);

	public List<Libelle> findLibelleByImputation(Imputation imputation);

	public List<Libelle> findLibelleByGroupeImputation(
			GroupeImputation groupeImputation);

	public List<Libelle> findLibelleByImputaCompte(ImputaCompte imputaCompte);

	public List<Libelle> findLibelleByImputaSousCompte(
			ImputaSousCompte imputaSousCompte);

	public List<Libelle> findLibelleByImputaCentreCout(
			ImputaCentreCout imputaCentreCout);

	public List<Libelle> findLibelleByImputaCodeFact(
			ImputaCodeFact imputaCodeFact);

	public List<Libelle> findLibelleByFiltre(int idf);

	List<Libelle> findLibelleBySemaineType(int idst);

//	void insertLib(Societe societe, String lib);

}
