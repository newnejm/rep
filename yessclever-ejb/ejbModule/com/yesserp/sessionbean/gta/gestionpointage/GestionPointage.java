package com.yesserp.sessionbean.gta.gestionpointage;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.Pointage;
import com.yesserp.domain.gta.Terminal;
import com.yesserp.domain.gta.TypePointage;

/**
 * Session Bean implementation class GestionPointage
 */
@Stateless
@LocalBean
public class GestionPointage implements GestionPointageLocal {

	@PersistenceContext
	EntityManager entityManager;

	public GestionPointage() {
		// TODO Auto-generated constructor stub
	}


	public void createPointage(Pointage pointage) {
		entityManager.persist(pointage);
	}

	public void updatePointage(Pointage pointage) {
		entityManager.merge(pointage);
	}

	public void deletePointage(Pointage pointage) {
		entityManager.remove(entityManager.merge(pointage));
	}

	public Pointage findPointageById(int id) {
		return entityManager.find(Pointage.class, id);
	}

	public List<Pointage> findPointageByIdentite(Identite identite) {

		Query query = entityManager
				.createQuery("select p from Pointage p where p.identite=:identite");
		query.setParameter("identite", identite);
		return query.getResultList();
	}

	public List<Pointage> listPointage() {
		List<Pointage> pointages= new ArrayList<Pointage>();
		pointages=entityManager.createQuery("select p from Pointage p",
				Pointage.class).getResultList();
		return pointages;
	}


	public List<Pointage> listPointageByDate(Date date) {
		return entityManager
				.createQuery("select p from Pointage p where p.date=:d")
				.setParameter("d", date).getResultList();
	}


	@SuppressWarnings("unchecked")
	@Override
	public List<Pointage> findPointageFromDateToDate(Identite identite,
			Date dateDeb, Date dateFin) {
		Query query = entityManager
				.createQuery("select p from Pointage p where p.identite=:x and p.date between :y and :z");
		query.setParameter("x", identite);
		query.setParameter("y", dateDeb);
		query.setParameter("z", dateFin);
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Pointage> findByDate(Identite identite, Date date) {
		Query query = entityManager
				.createQuery("select p from Pointage p where p.identite=:x and p.date=:y");
		query.setParameter("x", identite);
		query.setParameter("y", date);
		return query.getResultList();
	}
	
	@Override
	public List<TypePointage> ChercherSensPointage(){
		Query query = entityManager
				.createQuery("select t from TypePointage t");

		return query.getResultList();
	}
	
	@Override
	public List<Terminal> ChercherTerminaux(){
		Query query = entityManager
				.createQuery("select t from Terminal t");
	
		return query.getResultList();
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Pointage> findBetweenHours(Identite identite, Date date,
			Date heureDeb, Date heureFin) {
		Query query = entityManager
				.createQuery("select p from Pointage p where p.identite=:x and p.date=:y and p.heurep between :z and :w");
		query.setParameter("x", identite);
		query.setParameter("y", date);
		query.setParameter("z", heureDeb);
		query.setParameter("w", heureFin);
		return query.getResultList();

	}

	@Override
	public void SauvegarderTypePointage(TypePointage sens) {
		entityManager.persist(sens);
	}
	
	@Override
	public void SupprimerTypePointage(TypePointage sens) {
		entityManager.remove(entityManager.merge(sens));
	}
	
	@Override
	public void ModifierTypePointage(TypePointage sens) {
		entityManager.merge(sens);
	}


	@Override
	public void SauvegarderTerminal(Terminal terminal) {
		entityManager.persist(terminal);
	}
	@Override
	public void SupprimerTerminal(Terminal terminal) {
		entityManager.remove(entityManager.merge(terminal));
	}
	
	@Override
	public void ModifierTerminal(Terminal terminal) {
	entityManager.merge(terminal);
	}
	
	@Override
	public TypePointage findTypePointage(String nom) {
		Query query = entityManager
				.createQuery("select t from TypePointage t where t.libelle=:x");
		query.setParameter("x", nom);
		return (TypePointage) query.getSingleResult();}
	
	@Override
	public Terminal findTerminal(String nom) {
		Query query = entityManager
				.createQuery("select t from Terminal t where t.libelle=:x");
		query.setParameter("x", nom);
		return (Terminal) query.getSingleResult();}
	
}
