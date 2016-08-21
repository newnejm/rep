package com.yesserp.sessionbean.gta.gestionactivitereelcalculer;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ActiviteReelCalculer;
import com.yesserp.domain.gtaparam.Filtre;

/**
 * Session Bean implementation class GestionActiviteReelCalculer
 */
@Stateless
@LocalBean
public class GestionActiviteReelCalculer implements
		GestionActiviteReelCalculerLocal {

	/**
	 * Default constructor.
	 */
	public GestionActiviteReelCalculer() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelCalculer> findAll(Identite identite) {
		Query query = entityManager
				.createQuery("select act from ActiviteReelCalculer act where act.identite=:ident order by act.date, act.heuredeb");
		query.setParameter("ident", identite);

		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelCalculer> findFromDateToDate(Identite identite,
			Date date1, Date date2) {
		Query query = entityManager
				.createQuery("select act from ActiviteReelCalculer act where act.identite=:ident and act.date between :datedeb and :datefin");
		query.setParameter("ident", identite);
		query.setParameter("datedeb", date1);
		query.setParameter("datefin", date2);
		return query.getResultList();
	}

	@Override
	public void ajouterActiviteReelCalculer(
			ActiviteReelCalculer activiteReelCalculer) {
		entityManager.persist(activiteReelCalculer);

	}

	@Override
	public void deleteAll() {
		Query query = entityManager
				.createQuery("delete from ActiviteReelCalculer");
		query.executeUpdate();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelCalculer> findActiviteReelAbsence(Filtre f, Date d) {
		// TODO Auto-generated method stub

		Query query = entityManager
				.createQuery("Select arc from ActiviteReelCalculer arc inner join arc.activiteAbsence p  inner join p.filtres f  where f=:x  and   arc.date=:d");
		query.setParameter("x", f);
		query.setParameter("d", d);

		return (List<ActiviteReelCalculer>) query.getResultList();

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<ActiviteReelCalculer> findActiviteReelPresence(Filtre f, Date d) {

		Query query = entityManager
				.createQuery("Select arc from ActiviteReelCalculer arc inner join arc.activitePresence p inner join p.filtres f where f=:x and   arc.date=:d");
		query.setParameter("x", f);
		query.setParameter("d", d);
		return (List<ActiviteReelCalculer>) query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Date> findAllByDate(Identite identite) {
		Query query = entityManager
				.createQuery("	select distinct(a.date) from ActiviteReelCalculer  a inner join a.identite i  where i.numedoss=:x order by a.date");
		query.setParameter("x", identite.getNumedoss());
		return query.getResultList();
	}

}
