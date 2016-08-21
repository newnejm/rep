package com.yesserp.sessionbean.pg.gestionParametrageWorkFlow;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.ParametrageWorkFlow;



@Local
public interface GestionParametrageWorkFlowLocal {
	
	
	public void ajouterParametrageWorkFlow(ParametrageWorkFlow i);
	public void supprimerParametrageWorkFlow(ParametrageWorkFlow i);
	public void modifierParametrageWorkFlow(ParametrageWorkFlow i);
	public List<ParametrageWorkFlow> AfficherTousParametrageWorkFlow();
	
/*
	
	public List<ParametrageWorkFlow> trouverParNumParametrageWorkFlow(String numParametrageWorkFlow);
	public List<ParametrageWorkFlow> trouverParNom(String nom);
	*/
	

	

}
