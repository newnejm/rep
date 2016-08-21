package com.yesserp.sessionbean.paramgta.gestioncompteur;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gtaparam.Compteur;

/**
 * Session Bean implementation class GestionCompteur
 */
@Stateless
@LocalBean
public class GestionCompteur implements GestionCompteurLocal {

	/**
	 * Default constructor.
	 */
	public GestionCompteur() {
		// TODO Auto-generated constructor stub
	}

	@PersistenceContext(unitName = "yessclever")
	EntityManager entityManager;

	@Override
	public void ajouterCompteur(Compteur compteur) {
		entityManager.persist(compteur);

	}

	@Override
	public void modifierCompteur(Compteur compteur) {
		entityManager.merge(compteur);

	}

	@Override
	public Compteur findCompteurByCode(String code) {
		Query query = entityManager
				.createQuery("select cpt from Compteur cpt where cpt.codec=:x");
		query.setParameter("x", code);
		return (Compteur) query.getSingleResult();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compteur> listeCompteurs() {
		Query query = entityManager.createQuery("select cpt from Compteur cpt");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compteur> findAll() {
		Query query = entityManager.createQuery("select c from Compteur c");
		return query.getResultList();
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Compteur> findCompteurByIdentite(Identite identite) {
		// TODO Auto-generated method stub
		Query q = entityManager
				.createQuery("select c from Compteur c where identite = :id");
		q.setParameter("id", identite);
		List<Compteur> compteurs = null;
		try {
			compteurs = (List<Compteur>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compteurs;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Integer> getFilsCompteur(Compteur cmp) {
		Query q = entityManager
				.createQuery("select f.idFils from FilsCompteur f inner join f.compteur c where c=:cmp ");
		q.setParameter("cmp", cmp);
		List<Integer> compteurs = null;
		try {
			compteurs = (List<Integer>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return compteurs;
	}

	@Override
	public Compteur findCompteurById(int id) {
		Query query = entityManager
				.createQuery("select cpt from Compteur cpt where cpt.idc=:x");
		query.setParameter("x", id);
		return (Compteur) query.getSingleResult();

	}

	@Override
	public List<Compteur> getCompteurByUser(Identite identite ,Date d) {
		
           Query query = entityManager
                         .createQuery("select c from Compteur c inner join c.groupeCompteurs g inner join g.associateGroupeCompteurAssociateIdentites a where a.identite=:x and :y between a.associateIdentitePK.dateDeffet and a.associateIdentitePK.dateFin");
           query.setParameter("x", identite);
           query.setParameter("y", d);
           return  query.getResultList();
     }
	

}
