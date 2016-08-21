package com.yesserp.sessionbean.gta.gestiondatecalculGta;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.DateCalculGta;

@Local
public interface GestionDateCalculLocal {
	public void ajouterDateCalculGta(DateCalculGta dateCalculGta);
	public void supprimerDateCalculGta(DateCalculGta dateCalculGta);
	public void modifierDateCalculGta(DateCalculGta dateCalculGta);
	public DateCalculGta findDateCalculGtaById(int id);
	public List<DateCalculGta> findAllDateCalculGta();

}
