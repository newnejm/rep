package com.yesserp.sessionbean.paramgta.gestionDescCycleTravail;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.dao.impl.BaseDaoImpl;
import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescCycleTravail;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.CycleTravail;
import com.yesserp.domain.gtaparam.SemaineType;

@Stateless
@LocalBean
public class GestionDescCycleTravail implements GestionDescCycleTravailLocal {

	
	public GestionDescCycleTravail() {

	}

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
	
	@Override
	public List<DescCycleTravail> getDescCycleTravailsByCycleTravail(
			CycleTravail cycleTravail) {
		Query query = em
				.createQuery("SELECT c FROM DescCycleTravail c where c.cycleTravail = :st");
		query.setParameter("st", cycleTravail);
		return query.getResultList();
	}

	public DescCycleTravail ajouterDescCycleTravail(DescCycleTravail i) {
		configDateEffet(i.getDateEffet(), i.getCycleTravail());
		em.persist(i);
		return i;
	}

	public List<DescCycleTravail> getSortedDescCycleTravail() {

		Query query = em
				.createQuery("SELECT c FROM DescCycleTravail c ORDER BY c.dateEffet ASC");
		return query.getResultList();
	}

	public void configDateEffet(Date newDateEffet, CycleTravail cycleTravail) {

		Query query = em
				.createQuery("SELECT c FROM DescCycleTravail c where c.cycleTravail = :st ORDER BY c.idDescCT ASC ");
	        	query.setParameter("st", cycleTravail);
	        	
		List<DescCycleTravail> descCycleTravails = query.getResultList();

		DescCycleTravail descCycleTravail = null;
		if (descCycleTravails != null && !descCycleTravails.isEmpty()) {
			descCycleTravail = descCycleTravails
					.get(descCycleTravails.size() - 1);
		}
		if (descCycleTravail != null) { // s'il n'est pas null alors on a
										// récuperé le dernier enregistrement
			descCycleTravail.setDateFin(new Date(
					newDateEffet.getTime() - 24 * 3600 * 1000));
		}
	}

	@Override
	public void associateJourneeTypeToDescCycleTravail(Integer idDescCycleTravail,
			Integer idJourneeType, Integer index) {

		Query query = em
				.createNativeQuery("insert into journeetypedesccycletravail (iddesccycletravail,idjourneetype,index)"
						+ "values(?,?,?)");

		query.setParameter(1, idDescCycleTravail);
		query.setParameter(2, idJourneeType);
		query.setParameter(3, index);
		query.executeUpdate();

	}

	@Override
	public void associateSemaineTypeToDescCycleTravail(Integer idDescCycleTravail,
			Integer idSemaineType, Integer index) {

		Query query = em
				.createNativeQuery("insert into semainetypedesccycletravail (iddesccycletravail,idsemainetype,index)"
						+ "values(?,?,?)");

		query.setParameter(1, idDescCycleTravail);
		query.setParameter(2, idSemaineType);
		query.setParameter(3, index);
		query.executeUpdate();

	}
	
	@Override
	public void supprimerDescCycleTravail(DescCycleTravail i) {

		i = em.merge(i);
		em.remove(i);
	}
	
	@Override
	public void modifierDescCycleTravail(DescCycleTravail i) {

		em.merge(i);

	}

	@Override
	public List<DescCycleTravail> AfficherTousDescCycleTravail() {

		Query query = em.createQuery("SELECT c FROM DescCycleTravail c");
		return query.getResultList();
	}

}
