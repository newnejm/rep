package com.yesserp.sessionbean.ga.pieceidentite;

import java.util.Date;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.ga.Experience;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.ga.Nationalite;
import com.yesserp.domain.ga.PieceIdentite;

@Stateless
@LocalBean
public class GestionPieceIdentite  implements GestionPieceIdentiteLocal {

	@PersistenceContext(unitName = "yessclever")
	private EntityManager em;
	
	@Override
	public void ajouterPieceIdentite(PieceIdentite pieceIdentite) {
		// TODO Auto-generated method stub
		em.persist(pieceIdentite);
	}

	@Override
	public void supprimerPieceIdentite(PieceIdentite pieceIdentite) {
		// TODO Auto-generated method stub
		em.remove(em.merge(pieceIdentite));
	}

	@Override
	public void modifierPieceIdentite(PieceIdentite pieceIdentite) {
		// TODO Auto-generated method stub
		em.merge(pieceIdentite);
	}

	@Override
	public PieceIdentite trouverParId(Long id) {
		return em.find(PieceIdentite.class, id);
	}

	@Override
	public List<PieceIdentite> trouverPiecesIdentiteParIdentite(
			Identite identite, int n) {
		// TODO Auto-generated method stub
		Query q = em
				.createQuery("select i from PieceIdentie i join i.identite iden where iden.numedoss = :id");
		q.setParameter("id", identite.getNumedoss());
		q.setMaxResults(n);
		List<PieceIdentite> li = null;
		try {
			li = (List<PieceIdentite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<PieceIdentite> trouverPiecesIdentiteParType(Identite identite,
			String type) {
		Query q = em
				.createQuery("select i from PieceIdentie i join i.identite iden where iden.numedoss = :id and i.type = :type");
		q.setParameter("id", identite.getNumedoss());
		q.setParameter("type",type);
		
		List<PieceIdentite> li = null;
		try {
			li = (List<PieceIdentite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	@Override
	public List<PieceIdentite> findAll() {
		Query query = em.createQuery("select i from PieceIdentite i");
		return query.getResultList();
	}

	

	@Override
	public List<PieceIdentite> trouverPiecesIdentiteParIdentite(
			Identite identite) {
		Query q = em
				.createQuery("select i from PieceIdentite i join i.identite iden where iden.numedoss = :id ");
		q.setParameter("id", identite.getNumedoss());


		List<PieceIdentite> li = null;
		try {
			li = (List<PieceIdentite>) q.getResultList();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}

	@Override
	public List<PieceIdentite> trouverPremiersHistoriquePiecesIdentiteParIdentite(
			Identite identite, int n) {
		// TODO Auto-generated method stub
		return null;
	}

	


}
