package com.yesserp.sessionbean.gta.gestionjobs;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Administrateur;
import com.yesserp.domain.gta.ContratGta;
import com.yesserp.domain.gta.GroupeIdentity;
import com.yesserp.domain.gta.Jobs;
import com.yesserp.domain.gta.Jobscreate;
import com.yesserp.domain.gta.ParametreJobs;

@Local
public interface gestionJobsLocal {
	public void addJobs(Jobs jobs);
	public void addparam(ParametreJobs param_Jobs_Excute);

	public void deleteJobs(Jobs jobs);
	public void addAdmin(Administrateur admin);
	public void modifierJobs(Jobs jobs);
	public void addnewJobs(Jobs jobs,ParametreJobs param_Jobs_Excute);
	public void addnewJobs(Administrateur admin,ParametreJobs param_Jobs_Excute,Date date_create,String Statut,int gp_id);
	//public void addnewJobscrate(Administrateur admin,ParametreJobs parametreJobs,GroupeIdentity groupeIdentity, Date dateCreate,String Statut);
	public void modifierJobscreate(Jobscreate jobscreate);
	public void ajouterJobscreate(Jobscreate jobscreate);
	public List<Jobscreate> listeJobs();
	public Administrateur trouveradminbyid(int code);
	

}
