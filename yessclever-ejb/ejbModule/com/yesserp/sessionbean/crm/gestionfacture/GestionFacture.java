package com.yesserp.sessionbean.crm.gestionfacture;


import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import com.yesserp.domain.crm.*;
import com.yesserp.domain.gtaparam.PlageHoraire;



/**
 * Session Bean implementation class GestionIdentite
 */
@Stateless
@LocalBean
public class GestionFacture implements GestionFactureLocal {

    /**
     * Default constructor. 
     */
	@PersistenceContext(unitName="yessclever")
	private EntityManager em;
	
    public GestionFacture() {
        // TODO Auto-generated constructor stub
    }
    
    
	
    @Override
    public void ajouterFacture(Facture i) {
		em.persist(i);
	}
    @Override
    public void ajouterDevis(Devis i) {
		em.persist(i);
	} 
    @Override
    public void ajouterBc(Bc i) {
		em.persist(i);
	}
    @Override
    public void ajouterBl(Bl i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabDevisProduit(TabDevisProduit i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabDevisService(TabDevisService i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabBcProduit(TabBcProduit i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabBcService(TabBcService i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabBlProduit(TabBlProduit i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabBlService(TabBlService i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabFactureProduit(TabFactureProduit i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabFactureService(TabFactureService i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabAvoirProduit(TabAvoirProduit i) {
		em.persist(i);
	}
    @Override
    public void ajouterTabAvoirService(TabAvoirService i) {
		em.persist(i);
	}
    
    
    @Override
    public void ajouterEtatProcess(EtatProcess i) {
		em.persist(i);
	}
    
	@Override
	public void supprimerFacture(Facture i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		Facture c = em.find(Facture.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
		

	}
	
	

	@Override
	public void modifierFacture(Facture i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierDevis(Devis i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierBl(Bl i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierBc(Bc i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabDevisProduit(TabDevisProduit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabDevisService(TabDevisService i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabBcProduit(TabBcProduit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabBcService(TabBcService i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabBlProduit(TabBlProduit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabBlService(TabBlService i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	@Override
	public void modifierTabFactureProduit(TabFactureProduit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabFactureService(TabFactureService i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabAvoirProduit(TabAvoirProduit i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	@Override
	public void modifierTabAvoirService(TabAvoirService i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	
	@Override
	public void supprimerTabDevisProduit(TabDevisProduit i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabDevisProduit c = em.find(TabDevisProduit.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabDevisService(TabDevisService i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabDevisService c = em.find(TabDevisService.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabBcProduit(TabBcProduit i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabBcProduit c = em.find(TabBcProduit.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabBcService(TabBcService i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabBcService c = em.find(TabBcService.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabBlProduit(TabBlProduit i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabBlProduit c = em.find(TabBlProduit.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabBlService(TabBlService i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabBlService c = em.find(TabBlService.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabFactureProduit(TabFactureProduit i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabFactureProduit c = em.find(TabFactureProduit.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabFactureService(TabFactureService i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabFactureService c = em.find(TabFactureService.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabAvoirProduit(TabAvoirProduit i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabAvoirProduit c = em.find(TabAvoirProduit.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	@Override
	public void supprimerTabAvoirService(TabAvoirService i) {
		// TODO Auto-generated method stub
	//	 em.remove(em.merge(i));
		
		TabAvoirService c = em.find(TabAvoirService.class, i.getId());
          if (c != null) 
          {
                em.remove(c);
         
          }
	}
	
	
	@Override
	public void modifierEtatProcess(EtatProcess i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}

	@Override
	public void modifierParamFacture(ParamFacture i) {
		// TODO Auto-generated method stub
		em.merge(i);
		
	}
	
	
	
	@Override
	public List<Facture> AfficherTousFacture() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM Facture c");
        return query.getResultList();
	}

	
	@Override
	public List<TypePayementFacture> AfficherTousTypePayementFacture() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM TypePayementFacture c");
        return query.getResultList();
	}
	
	@Override
	public TypePayementFacture ChercherTypePayementFacture(String nom) {
		
		Query query = em.createQuery("select t from TypePayementFacture t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (TypePayementFacture) query.getSingleResult();	
	}

	@Override
	public TypeProcess ChercherTypeProcess(String nom) {
		
		Query query = em.createQuery("select t from TypeProcess t where t.nom = :nom");
		query.setParameter("nom",nom);


        return (TypeProcess) query.getSingleResult();	
	}
	
	
	@Override
	public TauxCompte ChercherTauxCompteFodec(Compte compte) {
		
	  Query query = em.createQuery("select t from TauxCompte t where t.compte.id = :id and t.taux.typeTaxe.nom LIKE '%Fodec%' ");

		query.setParameter("id",compte.getId());


        return (TauxCompte) query.getSingleResult();	
	}

	
	@Override
	public TauxCompte ChercherTauxCompteRetenu(Compte compte) {
		
	  Query query = em.createQuery("select t from TauxCompte t where t.compte.id = :id and t.taux.typeTaxe.nom LIKE '%Retenu%' ");

		query.setParameter("id",compte.getId());


        return (TauxCompte) query.getSingleResult();	
	}
	
	
	@Override
	public TauxCompte ChercherTauxCompteTVA(Compte compte) {
		
	  Query query = em.createQuery("select t from TauxCompte t where t.compte.id = :id and t.taux.typeTaxe.nom LIKE '%TVA%' ");

		query.setParameter("id",compte.getId());


        return (TauxCompte) query.getSingleResult();	
	}
	
	
	@Override
	public ParametrageTaxe ChercherTauxTVA(int nomtaux,int nomtaxe) {
		
	  Query query = em.createQuery("select t from ParametrageTaxe t where t.taux = :nomtaux and t.taxe = :nomtaxe ");

		query.setParameter("nomtaux",nomtaux);
		query.setParameter("nomtaxe",nomtaxe);



        return (ParametrageTaxe) query.getSingleResult();	
	}
	
	@Override
	public List<ParamFacture> AfficherTousParamFacture() {
		// TODO Auto-generated method stub
		Query query = em.createQuery("SELECT c FROM ParamFacture c ORDER BY c.id");
        return query.getResultList();
	}
	
	
	@Override
	public ParamFacture ChercherParamFactureParNom(String nom) {
		
	  Query query = em.createQuery("select t from ParamFacture t where t.nom = :nom ");

		query.setParameter("nom",nom);

        return (ParamFacture) query.getSingleResult();	
	}
	
	
	 @Override
	    public void ajouterParamFacture(List<ParamFacture> ParamFactures) {
			for (int i = 0; i < ParamFactures.size(); i++) {
	
		 em.persist(ParamFactures.get(i));
			}
		}
	
	 
		
		@Override
		public EtatProcess ChercherEtatProcess(String nom) {
			
		  Query query = em.createQuery("select t from EtatProcess t where t.nom = :nom ");

			query.setParameter("nom",nom);

	        return (EtatProcess) query.getSingleResult();	
		}
	 

		@Override
		public List<EtatProcess> AfficherEtatProcessVente(Compte compte) {
			// TODO Auto-generated method stub
			Query query = em.createQuery("SELECT e FROM EtatProcess e where e.typeProcess.nom LIKE '%Vente%' and e.compte.id = :id");
			query.setParameter("id",compte.getId());

	        return query.getResultList();
		}

		@Override
		public List<EtatProcess> AfficherEtatProcessAchat(Fournisseur fournisseur) {
			// TODO Auto-generated method stub
			Query query = em.createQuery("SELECT e FROM EtatProcess e where e.typeProcess.nom LIKE '%Achat%' and e.fournisseur.id = :id");
			query.setParameter("id",fournisseur.getId());

	        return query.getResultList();
		}
	
		// Tab devis produit
		@Override
		public List<TabDevisProduit> FindTabProduitByDevis(Devis devis) {
			Query q=em.createQuery("select i from TabDevisProduit i join i.devis c where c.id = :id");
			q.setParameter("id",devis.getId());
			List<TabDevisProduit> li=null;
			try {
				li= (List<TabDevisProduit>) q.getResultList();
			} catch (Exception e) {
				// TODO: handle exception
			}		
			return li;
		}
		
		// Tab devis service
				@Override
				public List<TabDevisService> FindTabServiceByDevis(Devis devis) {
					Query q=em.createQuery("select i from TabDevisService i join i.devis c where c.id = :id");
					q.setParameter("id",devis.getId());
					List<TabDevisService> li=null;
					try {
						li= (List<TabDevisService>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}

				// Tab Bc produit
				@Override
				public List<TabBcProduit> FindTabProduitByBc(Bc bc) {
					Query q=em.createQuery("select i from TabBcProduit i join i.bc c where c.id = :id");
					q.setParameter("id",bc.getId());
					List<TabBcProduit> li=null;
					try {
						li= (List<TabBcProduit>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				// Tab Bc Service
				@Override
				public List<TabBcService> FindTabServiceByBc(Bc bc) {
					Query q=em.createQuery("select i from TabBcService i join i.bc c where c.id = :id");
					q.setParameter("id",bc.getId());
					List<TabBcService> li=null;
					try {
						li= (List<TabBcService>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				// TabFactureProduit produit
				@Override
				public List<TabFactureProduit> FindTabProduitByFacture(Facture facture) {
					Query q=em.createQuery("select i from TabFactureProduit i join i.facture c where c.id = :id");
					q.setParameter("id",facture.getId());
					List<TabFactureProduit> li=null;
					try {
						li= (List<TabFactureProduit>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				// TabFactureService facture
				@Override
				public List<TabFactureService> FindTabServiceByFacture(Facture facture) {
					Query q=em.createQuery("select i from TabFactureService i join i.facture c where c.id = :id");
					q.setParameter("id",facture.getId());
					List<TabFactureService> li=null;
					try {
						li= (List<TabFactureService>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				
				
				// TabBlProduit 	Bl produit
				@Override
				public List<TabBlProduit> FindTabProduitByBl(Bl bl) {
					Query q=em.createQuery("select i from TabBlProduit i join i.bl c where c.id = :id");
					q.setParameter("id",bl.getId());
					List<TabBlProduit> li=null;
					try {
						li= (List<TabBlProduit>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				// TabBlService Bl service
				@Override
				public List<TabBlService> FindTabServiceByBl(Bl bl) {
					Query q=em.createQuery("select i from TabBlService i join i.bl c where c.id = :id");
					q.setParameter("id",bl.getId());
					List<TabBlService> li=null;
					try {
						li= (List<TabBlService>) q.getResultList();
					} catch (Exception e) {
						// TODO: handle exception
					}		
					return li;
				}
				
				
				
				
}

