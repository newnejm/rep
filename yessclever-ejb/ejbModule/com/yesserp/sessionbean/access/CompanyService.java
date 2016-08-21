package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import com.yesserp.domain.access.Company;

/**
 * Session Bean implementation class CompanyService
 */
@Stateless
public class CompanyService implements CompanyServiceRemote, CompanyServiceLocal {


	@PersistenceContext
	private EntityManager em;
	
    public CompanyService() {
        // TODO Auto-generated constructor stub
    }

	public void creeCompany(Company company) {
		em.persist(company);
	}

	public void modifierCompany(Company company) {
		em.merge(company);
	}

	public void supprimerCompany(Company company) {
		em.remove(em.merge(company));
	}

	public Company trouverCompanyById(int id) {
		return em.find(Company.class, id);
	}

	public List<Company> listCompanies() {
		return em.createQuery("select c from Company c", Company.class).getResultList();
	}

}
