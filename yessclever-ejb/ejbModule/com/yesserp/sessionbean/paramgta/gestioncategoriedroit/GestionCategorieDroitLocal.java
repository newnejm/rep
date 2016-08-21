package com.yesserp.sessionbean.paramgta.gestioncategoriedroit;

import java.util.List;
import javax.ejb.Local;
import com.yesserp.domain.gtaparam.CategorieDroit;

@Local
public interface GestionCategorieDroitLocal {

	public void ajouterCategorieDroit(CategorieDroit categorieDroit);
	public void modifierCategorieDroit(CategorieDroit categorieDroit);
	public CategorieDroit findCategorieDroitByCode(String code);
	public List<CategorieDroit> listeCategorieDroits();
	public List<CategorieDroit> findAll();
	
}
