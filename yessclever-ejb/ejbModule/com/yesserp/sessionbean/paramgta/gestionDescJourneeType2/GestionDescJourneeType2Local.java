package com.yesserp.sessionbean.paramgta.gestionDescJourneeType2;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.DescJourneeType;
import com.yesserp.domain.gtaparam.DescJourneeType2;
import com.yesserp.domain.gtaparam.JourneeType;
import com.yesserp.domain.gtaparam.JourneeType2;
import com.yesserp.domain.gtaparam.PlageHoraire2;


@Local
public interface GestionDescJourneeType2Local {

//	public void ajouterDescJourneeType2(DescJourneeType2 i) ;
	public void supprimerDescJourneeType2(DescJourneeType2  i ) ;
	public void modifierDescJourneeType2(DescJourneeType2  i) ;
	public  List<DescJourneeType2> AfficherTousDescJourneeType2();  
	public List<DescJourneeType2> getDescJourneeTypes2ByJourneeType2(
			JourneeType2 journeeType2);
	
	void updatePlageHoraireDescJourneeType2( PlageHoraire2 oldplageHoraire2, DescJourneeType2 descJourneeType2 , PlageHoraire2 plageHoraire2 , Date heure ) ;
	
	
	
	
	
}
