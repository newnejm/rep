package com.yesserp.sessionbean.ga.embauche;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Salaire;

/**
 * Session Bean implementation class GestionEmbauche
 */
@Stateless
@LocalBean
public class GestionEmbauche implements GestionEmbaucheLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionEmbauche() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterEmbauche(Embauche embauche) {
		try {
			em.persist(embauche);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerEmbauche(Embauche embauche) {
		try {
			em.remove(em.merge(embauche));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierEmbauche(Embauche embauche) {
		try {
			em.merge(embauche);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Embauche trouverParId(Long id) {
		Query q = em.createQuery("select i from Embauche i where id = :id");
		q.setParameter("id", id);
		Embauche i = null;
		try {
			i = (Embauche) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	@Override
	public void ajouterAffectation(Embauche embauche, Affectation affectation) {
		try {
			affectation.setEmbauche(embauche);
			em.persist(affectation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void modifierAffectation(Embauche embauche, Affectation affectation) {
		try {
			affectation.setEmbauche(embauche);
			em.merge(affectation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterSalaire(Embauche embauche, Salaire salaire) {
		try {
			salaire.setEmbauche(embauche);
			em.persist(salaire);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	@Override
	public void modifierSalaire(Embauche embauche, Salaire salaire) {
		try {
			salaire.setEmbauche(embauche);
			em.merge(salaire);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public Embauche trouverEmbaucheActifParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id and i.datefin IS NULL order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(1);

		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return null;
	}

	@Override
	public void ajouterListeAffectations(Embauche embauche,
			List<Affectation> affectations) {
		try {
			ArrayList<Affectation> teArrayList = (ArrayList<Affectation>) affectations;
			for (int i = 0; i < teArrayList.size(); i++) {
				Affectation affectation = teArrayList.get(i);
				affectation.setEmbauche(embauche);
				em.persist(affectation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterContrat(Embauche embauche, Contrat contrat) {
		try {
			contrat.setEmbauche(embauche);
			em.persist(contrat);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierListeAffectations(Embauche embauche,
			List<Affectation> affectations) {
		try {
			ArrayList<Affectation> teArrayList = (ArrayList<Affectation>) affectations;
			for (int i = 0; i < teArrayList.size(); i++) {
				Affectation affectation = teArrayList.get(i);
				affectation.setEmbauche(embauche);
				em.merge(affectation);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierContrat(Embauche embauche, Contrat contrat) {
		try {
			contrat.setEmbauche(embauche);
			em.merge(contrat);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Embauche> trouverHistoriqueEmbaucheParIdentite(
			Identite identite, int n) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParIdentite(Identite identite) {
		Query q = em
				.createQuery("select count(i) from Embauche i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Embauche trouverPrecedentEmbaucheParIdentite(Identite identite,
			Date max) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("max", max);
		q.setMaxResults(1);

		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return null;
	}

	@Override
	public Embauche trouverSuivantEmbaucheParIdentite(Identite identite,
			Date min) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("min", min);
		q.setMaxResults(1);

		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return null;
	}

	@Override
	public Embauche trouverPremierEmbaucheParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id order by i.datedeb");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(1);

		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return null;
	}

	@Override
	public Embauche trouverDernierEmbaucheParIdentite(Identite identite) {
		Query q = em
				.createQuery("select i from Embauche i join i.identite iden where iden.numedoss = :id order by i.datedeb desc");
		q.setParameter("id", identite.getNumedoss());

		q.setMaxResults(1);

		List<Embauche> li = null;
		try {
			li = (List<Embauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		if (li != null && li.size() > 0)
			return li.get(0);
		return null;
	}

}
