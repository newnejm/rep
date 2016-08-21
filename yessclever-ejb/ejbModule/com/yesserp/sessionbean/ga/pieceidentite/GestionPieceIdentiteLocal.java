package com.yesserp.sessionbean.ga.pieceidentite;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.PieceIdentite;
import com.yesserp.domain.ga.Identite;

@Local
public interface GestionPieceIdentiteLocal {
	public void ajouterPieceIdentite(PieceIdentite PieceIdentite);

	public void supprimerPieceIdentite(PieceIdentite PieceIdentite);

	public void modifierPieceIdentite(PieceIdentite PieceIdentite);

	public PieceIdentite trouverParId(Long id);

	public List<PieceIdentite> trouverPiecesIdentiteParIdentite(
			Identite identite, int n);
	
	public List<PieceIdentite> trouverPiecesIdentiteParType(
			Identite identite, String type);
	public List<PieceIdentite> findAll();
	
	
	
	public List<PieceIdentite> trouverPiecesIdentiteParIdentite(Identite identite);
	
	public List<PieceIdentite> trouverPremiersHistoriquePiecesIdentiteParIdentite(Identite identite, int n);
	


}
