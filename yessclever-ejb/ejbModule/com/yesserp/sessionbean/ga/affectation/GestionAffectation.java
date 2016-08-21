package com.yesserp.sessionbean.ga.affectation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Affectation;
import com.yesserp.domain.ga.AttachementEmploye;
import com.yesserp.domain.ga.AttachementManager;
import com.yesserp.domain.ga.Embauche;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gf.Frais;

import com.yesserp.domain.ga.ImputationGa;


/**
 * Session Bean implementation class GestionAffectation
 */
@Stateless
@LocalBean
public class GestionAffectation implements GestionAffectationLocal {

	/**
	 * Default constructor.
	 */
	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;

	public GestionAffectation() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void ajouterAffectation(Affectation affectation) {
		try {
			em.persist(affectation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void supprimerAffectation(Affectation affectation) {
		try {
			em.remove(em.merge(affectation));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierAffectation(Affectation affectation) {
		try {
			em.merge(affectation);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Affectation> trouverParPoste(String poste) {
		Query q = em
				.createQuery("select i from Affectation i where poste = :poste");
		q.setParameter("poste", poste);
		List<Affectation> affectations = null;
		try {
			affectations = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectations;
	}

	@Override
	public List<Affectation> trouverParUniteOrganisationnelle(
			String uniteOrganisationnelle) {
		Query q = em
				.createQuery("select i from Affectation i where uniteorga = :uniteorganisationnelle");
		q.setParameter("uniteorganisationnelle", uniteOrganisationnelle);
		List<Affectation> affectations = null;
		try {
			affectations = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return affectations;
	}

	@Override
	public Affectation trouverParId(Long id) {

		return em.find(Affectation.class, id);
	}

	@Override
	public void attacherManager(Affectation affectation,
			AttachementManager attachementManager) {
		try {
			attachementManager.setAffectationManager(affectation);
			em.persist(attachementManager);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void attacherEmploye(Affectation affectation,
			AttachementEmploye attachementEmploye) {
		try {
			attachementEmploye.setAffectea(affectation);
			em.persist(attachementEmploye);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@Override
	public void modifierAttachementManager(Affectation affectation,
			AttachementManager attachementManager) {
		try {
			attachementManager.setAffectationManager(affectation);
			em.merge(attachementManager);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierAttachementEmploye(Affectation affectation,
			AttachementEmploye attachementEmploye) {
		try {
			attachementEmploye.setAffectea(affectation);
			em.merge(attachementEmploye);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attacherListManagers(Affectation affectation,
			List<AttachementManager> attachementManagers) {

		try {
			ArrayList<AttachementManager> managers = (ArrayList<AttachementManager>) attachementManagers;
			for (int i = 0; i < managers.size(); i++) {
				AttachementManager attachementManager = managers.get(i);
				attachementManager.setAffectationManager(affectation);
				em.persist(attachementManager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void attacherListEmployes(Affectation affectation,
			List<AttachementEmploye> attachementEmployes) {
		try {
			ArrayList<AttachementEmploye> employers = (ArrayList<AttachementEmploye>) attachementEmployes;
			for (int i = 0; i < employers.size(); i++) {
				AttachementEmploye attachementEmploye = employers.get(i);
				attachementEmploye.setAffectea(affectation);
				em.persist(attachementEmploye);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void modifierAttachementListManagers(Affectation affectation,
			List<AttachementManager> attachementManagers) {

		try {
			ArrayList<AttachementManager> managers = (ArrayList<AttachementManager>) attachementManagers;
			for (int i = 0; i < managers.size(); i++) {
				AttachementManager attachementManager = managers.get(i);
				attachementManager.setAffectationManager(affectation);
				em.merge(attachementManager);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void modifierAttachementListEmployes(Affectation affectation,
			List<AttachementEmploye> attachementEmployes) {
		try {
			ArrayList<AttachementEmploye> employers = (ArrayList<AttachementEmploye>) attachementEmployes;
			for (int i = 0; i < employers.size(); i++) {
				AttachementEmploye attachementEmploye = employers.get(i);
				attachementEmploye.setAffectea(affectation);
				em.merge(attachementEmploye);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public List<Affectation> trouverAffectationsActivesParEmbauche(
			Embauche embauche) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id and i.datefin IS NULL order by i.datedeb desc");
		q.setParameter("id", embauche.getId());
		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}

		return li;
	}

	@Override
	public List<Affectation> trouverHistoriqueAffectationsParEmbauche(
			Embauche embauche, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id order by i.datedeb desc");
		q.setParameter("id", embauche.getId());
		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id and i.datedeb > :min order by i.datedeb desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public Affectation TrouverFonctionByIdentite(Identite identite) {
		Query q = em
				.createQuery("select a from Affectation a join a.embauche emba join emba.identite ident where ident.numedoss = :numedoss");
		
		q.setParameter("numedoss", identite.getNumedoss());
		try {
			return (Affectation) q.getSingleResult();
		} catch (Exception e) {
			return null;
		}
	}


	@Override
	public List<Affectation> trouverPremiersHistoriqueAffectationsParEmbaucheEtDateMin(
			Embauche embauche, Date min, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id and i.datedeb > :min order by i.datedeb");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}

	@Override
	public List<Affectation> trouverPremiersHistoriqueAffectationsParEmbauche(
			Embauche embauche, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id order by i.datedeb");
		q.setParameter("id", embauche.getId());

		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		Collections.reverse(li);
		return li;
	}
	
	@Override
	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMax(
			Embauche embauche, Date max, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Affectation> trouverHistoriqueAffectationsParEmbaucheEtDateMinMax(
			Embauche embauche, Date min, Date max, int n) {
		Query q = em
				.createQuery("select i from Affectation i join i.embauche emba where emba.id = :id and i.datedeb > :min and i.datedeb < :max order by i.datedeb desc");
		q.setParameter("id", embauche.getId());
		q.setParameter("min", min);
		q.setParameter("max", max);
		q.setMaxResults(n);

		List<Affectation> li = null;
		try {
			li = (List<Affectation>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesParEmbauche(Embauche embauche) {
		Query q = em
				.createQuery("select count(i) from Affectation i join i.embauche emba where emba.id = :id");
		q.setParameter("id", embauche.getId());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public Long trouverNombreOccurrencesActivesParEmbauche(Embauche embauche) {

		Query q = em
				.createQuery("select count(i) from Affectation i join i.embauche emba where emba.id = :id and i.datefin IS NULL");
		q.setParameter("id", embauche.getId());

		Long li = new Long(0);
		try {
			li = (Long) q.getSingleResult();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public void ajouterImputationGa(Affectation affectation,
			ImputationGa imputationGa) {
		try {
			imputationGa.setAffectation(affectation);
			em.persist(imputationGa);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	@Override
	public void modifierImputationGa(Affectation affectation,
			ImputationGa imputationGa) {
		try {
			imputationGa.setAffectation(affectation);
			em.merge(imputationGa);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void modifierListImputationGas(Affectation affectation,
			List<ImputationGa> imputationGas) {
		try {
			ArrayList<ImputationGa> arrayListImputationGas = (ArrayList<ImputationGa>) imputationGas;
			for (int i = 0; i < arrayListImputationGas.size(); i++) {
				ImputationGa imputationGa = arrayListImputationGas.get(i);
				imputationGa.setAffectation(affectation);
				em.merge(imputationGa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	@Override
	public void ajouterListImputationGas(Affectation affectation,
			List<ImputationGa> imputationGas) {
		try {
			ArrayList<ImputationGa> arrayListImputationGas = (ArrayList<ImputationGa>) imputationGas;
			for (int i = 0; i < arrayListImputationGas.size(); i++) {
				ImputationGa imputationGa = arrayListImputationGas.get(i);
				imputationGa.setAffectation(affectation);
				em.persist(imputationGa);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public List<Affectation> findAll() {
		Query query = em.createQuery("select a from Affectation a");
		return query.getResultList();
	}


}
