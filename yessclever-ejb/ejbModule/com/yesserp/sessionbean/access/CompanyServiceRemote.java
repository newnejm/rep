package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Remote;

import com.yesserp.domain.access.Company;

@Remote
public interface CompanyServiceRemote {

	public void creeCompany(Company company);
	public void modifierCompany(Company company);
	public void supprimerCompany(Company company);
	public Company trouverCompanyById(int id);
	public List<Company> listCompanies();
	
}
