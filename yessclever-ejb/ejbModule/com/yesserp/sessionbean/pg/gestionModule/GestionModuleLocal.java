package com.yesserp.sessionbean.pg.gestionModule;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.pg.Module;



@Local
public interface GestionModuleLocal {
	
	
	public void ajouterModule(Module i);
	public void supprimerModule(Module i);
	public void modifierModule(Module i);
	public List<Module> AfficherTousModule();
	
/*
	
	public List<Module> trouverParNumModule(String numModule);
	public List<Module> trouverParNom(String nom);
	*/
	

	

}
