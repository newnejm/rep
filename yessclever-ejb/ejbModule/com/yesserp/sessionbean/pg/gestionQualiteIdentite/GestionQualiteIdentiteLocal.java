package com.yesserp.sessionbean.pg.gestionQualiteIdentite;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.pg.QualiteIdentite;

@Local
public interface GestionQualiteIdentiteLocal {
	public void ajouterQualiteIdentite(QualiteIdentite i);
	public void supprimerQualiteIdentite(QualiteIdentite i);
	public void modifierQualiteIdentite(QualiteIdentite i);
	public List<QualiteIdentite> findall();

}
