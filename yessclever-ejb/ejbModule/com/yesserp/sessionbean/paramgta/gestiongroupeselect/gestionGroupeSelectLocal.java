package com.yesserp.sessionbean.paramgta.gestiongroupeselect;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Contrat;
import com.yesserp.domain.ga.Embauche;
import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.List_Identity;

@Local
public interface gestionGroupeSelectLocal {
	public void ajouterGroupeSelect(GroupeIdentity groupeSelect );

	public void modifierGroupeSelect(GroupeIdentity groupeSelect);

	public void supprimerGroupeSelect(GroupeIdentity groupeSelect);

	public GroupeIdentity findGroupeSelectByCode(String code);

	public GroupeIdentity findGroupeSelecteById(int id);
	public List<GroupeIdentity> findListGroupeSelecteById(int id);
	public void ajouterListeidentity(List_Identity list_Identity,List<Identite> identites);
	/*public void ajouterListeidentitytogroupe(GroupeIdentity groupeIdentity,List<List_Identity> list_Identities);*/
	public List<GroupeIdentity> listeGroupeSelect();
	public void ajouterListToGroupe(List_Identity list_Identities, GroupeIdentity groupeIdentity) ;
	public void ajouterListToGroupe2(List_Identity list_Identities,
			List<Identite> identites);

	public void ajouterListToGroupe2(List_Identity list_Identities);
	public List<Identite> findidentiteByGroupeIdentity(GroupeIdentity groupeIdentity);

	

	

}
