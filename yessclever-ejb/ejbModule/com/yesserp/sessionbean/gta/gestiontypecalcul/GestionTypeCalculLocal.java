package com.yesserp.sessionbean.gta.gestiontypecalcul;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.TypeCalucle;

@Local
public interface GestionTypeCalculLocal {
	public void ajouterTypeCalucle(TypeCalucle typeCalucle);
	public void supprimerTypeCalucle(TypeCalucle typeCalucle);
	public void modifierTypeCalucle(TypeCalucle typeCalucle);
	public TypeCalucle findTypeCalucleById(int id);
	public List<TypeCalucle> findAllTypeCalucle();
	public TypeCalucle findTypeCalculParNom(String nom);

}
