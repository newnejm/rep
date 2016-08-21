package com.yesserp.sessionbean.pg.gestionRechercheAvancee;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.DiplomeGa;
import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.DateEmbauche;
import com.yesserp.domain.pg.RechercheAvancee;

@Stateless
@LocalBean
public class GestionRechercheAvancee implements GestionRechercheAvanceeLocal{

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
	
	@Override
	public void enregistrerRechercheAvancee(RechercheAvancee ra) {
		try {
			em.persist(ra);
		} catch (Exception e) {
			e.printStackTrace();
		}
		}
	


	@Override
	public List<RechercheAvancee> AfficherRechercheAvancee() {
		Query query = em.createQuery("select e from RechercheAvancee e");
		return query.getResultList();
	}

	@Override
	public List<DateEmbauche> AfficherDatesEmbaucheParRechercheAvancee(
			RechercheAvancee ra) {
		Query q = em
				.createQuery("select de from DateEmbauche de join de.rechercheAvancee ra where ra.id = :id");
		q.setParameter("id", ra.getIdR());
		
		List<DateEmbauche> li = null;
		try {
			li = (List<DateEmbauche>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<Age> AfficherAgesParRechercheAvancee(RechercheAvancee ra) {
		Query q = em
				.createQuery("select a from Age a join a.rechercheAvancee ra where ra.id = :id");
		q.setParameter("id", ra.getIdR());	
		List<Age> li = null;
		try {
			li = (List<Age>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}


	@Override
	public void enregistrerDateEmbauche(RechercheAvancee ra, List<DateEmbauche> da) {
		try {
			ArrayList<DateEmbauche> maArrayList = (ArrayList<DateEmbauche>) da;
			for (int i = 0; i < maArrayList.size(); i++) {
				DateEmbauche d = maArrayList.get(i);
				d.setRechercheAvancee(ra);
				em.persist(d);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
	}


	@Override
	public void enregistrerAge(RechercheAvancee ra, List<Age> a) {
		try {
			ArrayList<Age> maArrayList = (ArrayList<Age>) a;
			for (int i = 0; i < maArrayList.size(); i++) {
				Age aa = maArrayList.get(i);
				aa.setRechercheAvancee(ra);
				em.persist(aa);
			}
		} catch (Exception e) {
			e.printStackTrace();

		}
		
		
	}



	@Override
	public void supprimerRechercheAvancee(RechercheAvancee ra, List<Age> a, List<DateEmbauche> de) {
		try {
			ArrayList<Age> maArrayList = (ArrayList<Age>) a;
			for (int i = 0; i < maArrayList.size(); i++) {
				Age aa = maArrayList.get(i);
				aa.setRechercheAvancee(ra);
				em.remove(aa);
			}
				ArrayList<DateEmbauche> maArrayList2 = (ArrayList<DateEmbauche>) de;
				for (int j = 0; j < maArrayList2.size(); j++) {
					DateEmbauche d = maArrayList2.get(j);
					d.setRechercheAvancee(ra);
					em.remove(d);
			}
				em.remove(em.merge(ra));	
				}
		 catch (Exception e) {
			e.printStackTrace();

		}
		
	}

}
