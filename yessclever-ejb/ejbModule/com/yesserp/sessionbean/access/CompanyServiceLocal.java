package com.yesserp.sessionbean.access;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.access.Company;

@Local
public interface CompanyServiceLocal {

	public void creeCompany(Company company);
	public void modifierCompany(Company company);
	public void supprimerCompany(Company company);
	public Company trouverCompanyById(int id);
	public List<Company> listCompanies();
}
