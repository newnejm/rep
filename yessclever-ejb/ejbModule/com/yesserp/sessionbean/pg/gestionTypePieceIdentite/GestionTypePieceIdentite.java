package com.yesserp.sessionbean.pg.gestionTypePieceIdentite;

import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.pg.TypePieceIdentite;
import com.yesserp.sessionbean.pg.gestionTypePieceIdentite.GestionTypePieceIdentiteLocal;

@Stateless
@LocalBean
public class GestionTypePieceIdentite implements GestionTypePieceIdentiteLocal{
	

	
    public GestionTypePieceIdentite() {
      
    }
    @PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public void ajouterTypePieceIdentite(TypePieceIdentite i) {
		em.persist(i);
	}


	public void supprimerTypePieceIdentite(TypePieceIdentite i) {
		
		i = em.merge(i);
		em.remove(i);
	}


	public void modifierTypePieceIdentite(TypePieceIdentite i) {
		
		em.merge(i);
		
	}
	

	@Override
	public List<TypePieceIdentite> findAll() {
		Query query = em.createQuery("SELECT c FROM TypePieceIdentite c");
        return query.getResultList();
	}

	
	
}
