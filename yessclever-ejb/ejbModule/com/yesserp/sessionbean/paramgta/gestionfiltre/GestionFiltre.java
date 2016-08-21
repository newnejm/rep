package com.yesserp.sessionbean.paramgta.gestionfiltre;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.gtaparam.CodeJour;
import com.yesserp.domain.gtaparam.Compteur;
import com.yesserp.domain.gtaparam.Filtre;
import com.yesserp.domain.gtaparam.PlageHoraire;

/**
 * Session Bean implementation class GestionFiltre
 */
@Stateless
@LocalBean
public class GestionFiltre implements GestionFiltreLocal {

	/**
	 * Default constructor.
	 */
	public GestionFiltre() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterFiltre(Filtre filtre) {
		entityManager.persist(filtre);

	}
	
	@Override
	public void supprimerFiltre(Filtre filtre) {

		entityManager.remove(entityManager.merge(filtre));
	}
	
	@Override
	public void modifierFiltre(Filtre filtre) {
		entityManager.merge(filtre);

	}

	@Override
	public Filtre rechercheFilterParNom(String formule) {
		Query query = entityManager
				.createQuery("Select f from Fi f where codef=:x");
		query.setParameter("x", formule);
		return (Filtre) query.getSingleResult();

	}
	

	@Override
	public Filtre getFilterById(int id) {
		// TODO Auto-generated method stub
		return entityManager.find(Filtre.class, id);
	}

	@Override
	public List<Filtre> findFilterByCompteur(Compteur compteur) {
		Query query = entityManager
				.createQuery("Select f from Fi f  inner join f.formuleCompteurs p  inner join p.compteur c where c=:x");
		query.setParameter("x",compteur );
		return (List<Filtre>) query.getResultList();
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Filtre> listeFiltres() {
		Query query = entityManager.createQuery("SELECT f FROM Fi f order by idf");
		return query.getResultList();
	}

}
