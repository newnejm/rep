package com.yesserp.sessionbean.pg.gestionRechercheAvancee;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.Age;
import com.yesserp.domain.pg.DateEmbauche;
import com.yesserp.domain.pg.RechercheAvancee;


@Local
public interface GestionRechercheAvanceeLocal {
	public void enregistrerRechercheAvancee(RechercheAvancee ra);
	public void supprimerRechercheAvancee(RechercheAvancee ra,List<Age> a,List<DateEmbauche> da);
	public List<RechercheAvancee> AfficherRechercheAvancee();
	public void enregistrerDateEmbauche(RechercheAvancee ra, List<DateEmbauche> da);
	public void enregistrerAge(RechercheAvancee ra, List<Age> a);
	public List<DateEmbauche> AfficherDatesEmbaucheParRechercheAvancee(RechercheAvancee ra);
	public List<Age> AfficherAgesParRechercheAvancee(RechercheAvancee ra);
}
