package com.yesserp.sessionbean.paramgta.gestionDescJourneeType;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.PlageHoraire;
import com.yesserp.domain.gtaparam.RefAbscence;
import com.yesserp.domain.gtaparam.SemaineType;

@Stateless
@LocalBean
public class GestionDescJourneeType implements GestionDescJourneeTypeLocal {

	public GestionDescJourneeType() {

	}

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	@Override
	public void ajouterDescJourneeType(DescJourneeType i) {
		configDateEffet(i.getDateEffet(), i.getJourneeType());
		em.persist(i);
	}

	@Override
	public void supprimerDescJourneeType(DescJourneeType i) {

		i = em.merge(i);
		em.remove(i);
	}

	@Override
	public void modifierDescJourneeType(DescJourneeType i) {

		em.merge(i);

	}

	@Override
	public List<DescJourneeType> AfficherTousDescJourneeType() {

		Query query = em.createQuery("SELECT c FROM DescJourneeType c");
		return query.getResultList();
	}

	public List<DescJourneeType> getSortedDescJourneeType() {

		Query query = em
				.createQuery("SELECT c FROM DescJourneeType c ORDER BY c.dateEffet ASC");
		return query.getResultList();
	}

	public void configDateEffet(Date newDateEffet, JourneeType journeeType) {

		Query query = em
				.createQuery("SELECT c FROM DescJourneeType c where c.journeeType = :jt  ORDER BY c.id ASC");
		query.setParameter("jt", journeeType);

		List<DescJourneeType> descJourneeTypes = query.getResultList();

		DescJourneeType descJourneeType = null;
		if (descJourneeTypes != null && !descJourneeTypes.isEmpty()) {
			descJourneeType = descJourneeTypes.get(descJourneeTypes.size() - 1);
		}
		if (descJourneeType != null) { // s'il n'est pas null alors on a
										// récuperé le dernier enregistrement
			descJourneeType.setDateFin(new Date(
					newDateEffet.getTime() - 24 * 3600 * 1000));
		}
	}

	@Override
	public void associatePlageHoraireToDescJourneeType(Integer descJt,
			PlageHoraire plageHoraire, Date heure) {

		Query query = em
				.createNativeQuery("insert into PlageHoraireDescJourneeType (idDescJourneetype,idPlageHoraire,heure)"
						+ "values(?,?,?)");

		query.setParameter(1, descJt);
		query.setParameter(2, plageHoraire.getIdph());
		query.setParameter(3, heure);
		query.executeUpdate();

	}

	@Override
	public void updatePlageHoraireDescJourneeType(PlageHoraire oldPlageHoraire, DescJourneeType oldDescJourneeType, PlageHoraire plageHoraire, Date heure) {
		
		Query query = em
				.createNativeQuery("update PlageHoraireDescJourneeType  set idPlageHoraire = ?"
						+ ", heure = ? WHERE idDescJourneetype = ? AND idPlageHoraire = ?");

		
		
		query.setParameter(1, plageHoraire.getIdph());
		query.setParameter(2, heure);
		query.setParameter(3, oldDescJourneeType.getId());
		query.setParameter(4, oldPlageHoraire.getIdph());
		query.executeUpdate();
	}

	@Override
	public void associateRefAbscenceToDescJourneeType(Integer descJt,
			RefAbscence refAbscence, Date heure) {
		Query query = em
				.createNativeQuery("insert into RefAbscenceDescJourneeType (idDescJourneetype,idRefAbscence,heure)"
						+ "values(?,?,?)");
		query.setParameter(1, descJt);
		query.setParameter(2, refAbscence.getIdap());
		query.setParameter(3, heure);
		query.executeUpdate();

	}

	@Override
	public List<DescJourneeType> getDescJourneeTypesByJourneeType(
			JourneeType journeeType) {
		Query query = em
				.createQuery("SELECT c FROM DescJourneeType c where c.journeeType = :jt");
		query.setParameter("jt", journeeType);
		return query.getResultList();
	}

	/*
	 * 
	 * @Override public List<DescJourneeType> trouverParNom(String nom) {
	 * 
	 * Query q=em.createQuery("select from DescJourneeType i where nom = :nom");
	 * q.setParameter("nom",nom); List<DescJourneeType> li=null; try { li=
	 * (List<DescJourneeType>) q.getResultList(); } catch (Exception e) {
	 * 
	 * } return li; }
	 * 
	 * @Override public List<DescJourneeType>
	 * trouverParNumDescJourneeType(String numDescJourneeType) {
	 * 
	 * Query q=em.createQuery(
	 * "select from DescJourneeType i where numDescJourneeType = :numDescJourneeType"
	 * ); q.setParameter("numDescJourneeType",numDescJourneeType);
	 * List<DescJourneeType> li=null; try { li= (List<DescJourneeType>)
	 * q.getResultList(); } catch (Exception e) {
	 * 
	 * } return li; }
	 */

}
