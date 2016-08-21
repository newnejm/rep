package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;






import com.yesserp.domain.access.Groupe;
import com.yesserp.domain.access.Habilitation;
import com.yesserp.domain.access.Operation;

/**
 * Session Bean implementation class OperationService
 */
@Stateless
public class OperationService implements OperationServiceRemote, OperationServiceLocal {

	@PersistenceContext
	private EntityManager em;
	
    public OperationService() {
        // TODO Auto-generated constructor stub
    }

	@Override
	public void creeOperation(Operation operation) {

		em.persist(operation);
	}

	@Override
	public void modifierOperation(Operation operation) {
		
		em.merge(operation);
		
	}

	@Override
	public void supprimerOperation(Operation operation) {
		
		em.remove(em.merge(operation));
		
	}

	@Override
	public Operation trouverOperationById(int id) {
		
		return em.find(Operation.class, id);
	}

	@Override
	public List<Operation> listOperations() {
		return em.createQuery("select o from Operation o", Operation.class).getResultList();

	}



}
