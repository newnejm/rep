package com.yesserp.sessionbean.tm;

import java.util.List;

import javax.ejb.Local;






import com.yesserp.domain.tm.Competence;
import com.yesserp.domain.tm.Diplome;
import com.yesserp.domain.tm.Offre;
import com.yesserp.domain.tm.Profile;

@Local
public interface GestionOffreLocal {

	public void ajouterOffre(Offre of,List<Diplome> ld,List<Profile> lp,List<Competence> lc);
	public void ajouter(Offre of,List<Diplome> ld,List<Profile> lp,List<Competence> lc);
	public List<Offre> findAllOffress();	
	public void deleteOffre(Offre of);
	public void updateOffre(Offre of);
	
}
