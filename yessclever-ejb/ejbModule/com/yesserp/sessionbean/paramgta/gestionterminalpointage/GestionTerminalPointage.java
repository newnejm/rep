package com.yesserp.sessionbean.paramgta.gestionterminalpointage;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gta.Terminal;

/**
 * Session Bean implementation class GestionTerminalPointage
 */
@Stateless
@LocalBean
public class GestionTerminalPointage implements GestionTerminalPointageLocal {

	/**
	 * Default constructor.
	 */
	public GestionTerminalPointage() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterTerminalPointage(Terminal terminal) {
		entityManager.persist(terminal);

	}

	@Override
	public void modifierTerminalPointage(Terminal terminal) {
		entityManager.merge(terminal);

	}

	@Override
	public void supprimerTerminalPointage(Terminal terminal) {
		entityManager.remove(entityManager.merge(terminal));

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Terminal> findAll() {
		Query query = entityManager.createQuery("SELECT t FROM Terminal t");
		return query.getResultList();
	}

}
