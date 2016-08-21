package com.yesserp.sessionbean.paramgta.gestionlibelle;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

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

/**
 * Session Bean implementation class GestionLibelle
 */
@Stateless
@LocalBean
public class GestionLibelle implements GestionLibelleLocal {

	/**
	 * Default constructor.
	 */
	public GestionLibelle() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajoutLibelle(Libelle libelle) {
		entityManager.persist(libelle);

	}

	@Override
	public void supprimerLibelle(Libelle libelle) {
		entityManager.remove(entityManager.merge(libelle));

	}

	@Override
	public void modifierLibelle(Libelle libelle) {
		entityManager.merge(libelle);

	}

	@Override
	public List<Libelle> listerLibelle() {
		Query query = entityManager.createQuery("SELECT l FROM Libelle l");
		return query.getResultList();
	}

	@Override
	public Libelle findLibelleById(int id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l where l.idlib = :id");
		query.setParameter("id", id);
		return (Libelle) query.getSingleResult();
	}

	@Override
	public List<Libelle> findLibelleByPlageHoraire(int id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.plageHoraire pl where pl.idph = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();

	}

	@Override
	public List<Libelle> findLibelleByCodeJour(int idcj) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.codeJour cj where cj.idcj = :id");
		query.setParameter("id", idcj);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByjourneeType(int idjt) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.journeeType jt where jt.idjt = :id");
		query.setParameter("id", idjt);
		return (List<Libelle>) query.getResultList();
	}
	
	
	
	@Override
	public List<Libelle> findLibelleByjourneeType2(int idjt2) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.journeeType2 jt2 where jt2.idjt2 = :id");
		query.setParameter("id", idjt2);
		return (List<Libelle>) query.getResultList();
	}
	
	
	
	@Override
	public List<Libelle> findLibelleBySemaineType(int idst) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.semaineType st where st.idst = :id");
		query.setParameter("id", idst);
		return (List<Libelle>) query.getResultList();
	}
	
	

	@Override
	public List<Libelle> findLibelleByCycleTravail(int idct) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.cycleTravail ct where ct.idct = :id");
		query.setParameter("id", idct);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByFiltre(int idf) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l join l.filtre f where f.idf = :id");
		query.setParameter("id", idf);
		return (List<Libelle>) query.getResultList();
	}



	


	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByActivitePresence(int id) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib JOIN lib.activitePresence ap WHERE ap.idap = :x");
		query.setParameter("x", id);
		return query.getResultList();
	}
	
	@Override
	public List<Libelle> findLibelleByParametrageAlerte(
			ParametrageAlerte parametrageAlerte) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.parametrageAlerte=:x");
		query.setParameter("x", parametrageAlerte);
		return query.getResultList();
	}
	
	
	@Override
	public List<Libelle> findLibelleBySociete(
			Societe societe) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.societe=:x");
		query.setParameter("x", societe);
		return query.getResultList();
		
	}
	
	@Override
	public List<Libelle> findLibelleByParametrageModuleGlobale(
			ParametrageModuleGlobale parametrageModuleGlobale) {
		Query query = entityManager
				.createQuery("SELECT lib FROM ParametrageModuleGlobale lib WHERE lib.parametrageModuleGlobale=:x");
		query.setParameter("x", parametrageModuleGlobale);
		return query.getResultList();
		
	}
	
	
	@Override
	public List<Libelle> findLibelleByModule(
			Module module) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.module=:x");
		query.setParameter("x", module);
		return query.getResultList();
		
	}
	
	
	@Override
	public List<Libelle> findLibelleByFiliale(
			Filiale filiale) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.societe=:x");
		query.setParameter("x", filiale);
		return query.getResultList();
	}
	
	
	
	
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByActiviteAbsence(
			ActiviteAbsence activiteAbsence) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.activiteAbsence=:x");
		query.setParameter("x", activiteAbsence);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByImputation(Imputation imputation) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.imputation=:x");
		query.setParameter("x", imputation);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByImputaCompte(ImputaCompte imputaCompte) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.imputaCompte=:x");
		query.setParameter("x", imputaCompte);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByImputaSousCompte(
			ImputaSousCompte imputaSousCompte) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.imputaSousCompte=:x");
		query.setParameter("x", imputaSousCompte);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByImputaCentreCout(
			ImputaCentreCout imputaCentreCout) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.imputaCentreCout=:x");
		query.setParameter("x", imputaCentreCout);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByImputaCodeFact(
			ImputaCodeFact imputaCodeFact) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.imputaCodeFact=:x");
		query.setParameter("x", imputaCodeFact);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByGroupeImputation(
			GroupeImputation groupeImputation) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib WHERE lib.groupeImputation=:x");
		query.setParameter("x", groupeImputation);
		return query.getResultList();
	}
	
	/*public void insertLib(Societe societe,String lib )
	    {
		if(societe!=null){
			ArrayList<Libelle> libelles = new ArrayList<>();
			Libelle libelle =new Libelle();
			libelle.setSociete(societe);
			libelle.setLib(lib);
			entityManager.persist(libelle);
		}
		
		
	}
*/
	

	@SuppressWarnings("unchecked")
	@Override
	public List<Libelle> findLibelleByGroupeActivite(int idga) {
		Query query = entityManager
				.createQuery("SELECT lib FROM Libelle lib JOIN lib.groupeActivite ga WHERE ga.idgrpa=:x");
		query.setParameter("x", idga);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleBySexeIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.sexeIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByQualiteIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.qualiteIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleBySituationCivileIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.situationCivileIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByTypeStatutIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.typeStatutIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByTypeContratIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.typeContratIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByNatureContratIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.natureContratIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleBySituationContratIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.situationContratIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByPosteAffectationIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.posteAffectationIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByUOAffectationIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.uOAffectationIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByEmploiAffectationIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.emploiAffectationIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByCategorieAffectationIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.categorieAffectationIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

	@Override
	public List<Libelle> findLibelleByTypePieceIdentite(long id) {
		Query query = entityManager
				.createQuery("SELECT l FROM Libelle l inner join l.typePieceIdentite si where si.id = :id");
		query.setParameter("id", id);
		return (List<Libelle>) query.getResultList();
	}

}
