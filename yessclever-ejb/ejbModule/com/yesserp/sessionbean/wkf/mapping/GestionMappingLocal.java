package com.yesserp.sessionbean.wkf.mapping;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.wkf.Mapping;

@Local
public interface GestionMappingLocal {
	public void ajouterMapping(Mapping Mapping);

	public void supprimerMapping(Mapping Mapping);

	public void modifierMapping(Mapping Mapping);

	public Mapping trouverParId(Long id);

	public List<Mapping> trouverMappingsParEntite(String entite);
}


