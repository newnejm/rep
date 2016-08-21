package com.yesserp.sessionbean.pg.gestionParametrageMail;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageMail;



@Local
public interface GestionParametrageMailLocal {
	
	
	public void ajouterParametrageMail(ParametrageMail i);
	public void supprimerParametrageMail(ParametrageMail i);
	public void modifierParametrageMail(ParametrageMail i);
	public List<ParametrageMail> AfficherTousParametrageMail();
	
/*
	
	public List<ParametrageMail> trouverParNumParametrageMail(String numParametrageMail);
	public List<ParametrageMail> trouverParNom(String nom);
	*/
	

	

}
