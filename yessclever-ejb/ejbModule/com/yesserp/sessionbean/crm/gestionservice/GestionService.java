package com.yesserp.sessionbean.crm.gestionservice;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.*;
import com.yesserp.domain.ga.Identite;



/**
 * Session Bean implementation class GestionIdentite
 */
@Stateless
@LocalBean
public class GestionService implements GestionServiceLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionService() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterService(Service i) {
		em.persist(i);
	}
    
    
    @Override
    public void ajouterTypeServices(TypeService i) {
		em.persist(i);
	}    

	@Override
	public void supprimerService(Service i) {
		// TODO Auto-generated method stub

		Service p = em.find(Service.class, i.getId());
          if (p != null) 
          {
                em.remove(p);
         
          }	}


	@Override
	public void modifierService(Service i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	

	@Override
	public List<Service> AfficherTousService() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Service c");
        return query.getResultList();
	}

	@Override
	public List<Service> AfficherserviceActif(){
		Query query=em.createQuery("SELECT c FROM Service c WHERE c.statut.nom  LIKE '%actif%' ");
		return query.getResultList();
	}
	
	@Override
	public List<Service> AfficherserviceNonActif(){
		Query query=em.createQuery("SELECT c FROM Service c WHERE c.statut.nom LIKE '%initial%' ");
		return query.getResultList();
	}
	

	
	
	@Override
	public Service trouverParNom(String nom) {
		return em.find(Service.class, nom);

	}



	@Override
	public Service trouverParCode(String code) {
		return em.find(Service.class, code);

	}


	@Override
	public List<TypeService> getListeTypeService() {
		Query query = em.createQuery("SELECT c FROM TypeService c");
        return query.getResultList();	
	}
	@Override
	public List<Statut_service> getListeStatut() {
		Query query = em.createQuery("SELECT c FROM Statut_service c ");
        return query.getResultList();	
	}
	
	public List<Statut_service> getstatutinit()
	{
		Query query = em.createQuery("SELECT c FROM Statut_service c WHERE c.nom LIKE '%initial%'");
        return query.getResultList();
	}
	
	@Override
	public List<Origine> getListeorigine() {
		Query query = em.createQuery("SELECT c FROM Origine c");
        return query.getResultList();	
	}
	
	@Override
	public List<Remise>  getListremise(){
		Query query = em.createQuery("SELECT c FROM Remise c");
        return query.getResultList();
	}
	@Override
	public List<Priorite_service> getListpriorite(){
		Query query = em.createQuery("SELECT c FROM Priorite_service c");
        return query.getResultList();	
	}
	
	@Override
	public TypeService ChercherTypeService(String nom) {
		Query query = em.createQuery("select t from TypeService t where t.nom = :nom");
		query.setParameter("nom",nom);
        return (TypeService) query.getSingleResult();		

	}
	/*
	@Override
	public List<Origine> getListeTypeTravailInt() {
		Query query = em.createQuery("SELECT c FROM Type_travail_interne c");
        return query.getResultList();	
	}
	*/
	@Override
	public Origine ChercherOrigine(String nom) {
		Query query = em.createQuery("select t from Origine t where t.nom = :nom");
		query.setParameter("nom",nom);
        return (Origine) query.getSingleResult();		

	}
	
	@Override
	public Priorite_service Chercherpriorite(String nom) {
		Query query = em.createQuery("select t from Priorite_service t where t.nom = :nom");
		query.setParameter("nom",nom);
        return (Priorite_service) query.getSingleResult();		

	}

	@Override
	public Statut_service ChercherStatut(String nom) {
		Query query = em.createQuery("select t from Statut_service t where t.nom = :nom");
		query.setParameter("nom",nom);
        return (Statut_service) query.getSingleResult();		

	}
	
	
	

	
	
	@Override
	public Service ChercherService(String nom) {
		Query query = em.createQuery("select t from Service t where t.nom = :nom");
		query.setParameter("nom",nom);
        return (Service) query.getSingleResult();		
	}
/*
 * @Override
	public List<Identite> findAll() {
		Query query = em.createQuery("select i from Identite i");
		return query.getResultList();
	}
 * 
 */
	
	
}
