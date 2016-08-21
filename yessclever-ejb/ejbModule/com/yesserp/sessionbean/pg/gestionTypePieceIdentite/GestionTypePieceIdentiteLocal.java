package com.yesserp.sessionbean.pg.gestionTypePieceIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.TypePieceIdentite;
@Local
public interface GestionTypePieceIdentiteLocal {
	public void ajouterTypePieceIdentite(TypePieceIdentite i);
	public void supprimerTypePieceIdentite(TypePieceIdentite i);
	public void modifierTypePieceIdentite(TypePieceIdentite i);
	public List<TypePieceIdentite> findAll();
	

}
