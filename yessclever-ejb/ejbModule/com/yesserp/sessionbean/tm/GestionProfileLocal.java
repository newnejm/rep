package com.yesserp.sessionbean.tm;

import java.util.List;

import javax.ejb.Local;



import com.yesserp.domain.tm.Offre;
import com.yesserp.domain.tm.Profile;

@Local
public interface GestionProfileLocal {
	
	public void ajouterProfile();		
	public List<Profile> findProfilesById(Offre of);
    public void deleteProfile(Offre of);
}
