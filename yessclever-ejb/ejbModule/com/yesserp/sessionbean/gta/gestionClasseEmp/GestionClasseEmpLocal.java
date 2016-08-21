package com.yesserp.sessionbean.gta.gestionClasseEmp;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.ClasseEmp;

@Local
public interface GestionClasseEmpLocal {
	
	public void supprimerClasseEmp(ClasseEmp classeEmp);

	public void modifierClasseEmp(ClasseEmp classeEmp);
	
	
	
	//
	
	public List<ClasseEmp> trouverClasseEmpParIdentite(Identite identite);
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentite(Identite identite, int n);
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<ClasseEmp> trouverPremiersHistoriqueClasseEmpParIdentiteEtDateMin(Identite identite, Date min, int n);
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMax(Identite identite, Date max, int n);
	public List<ClasseEmp> trouverHistoriqueClasseEmpParIdentiteEtDateMinMax(Identite identite, Date min, Date max, int n);
	public List<ClasseEmp> trouverPremiersHistoriqueGClasseEmpParIdentite(Identite identite, int n);
	
	public Long trouverNombreOccurrencesParIdentite(Identite identite);

	public Long trouverNombreOccurrencesActivesParIdentite(Identite identite);

}
