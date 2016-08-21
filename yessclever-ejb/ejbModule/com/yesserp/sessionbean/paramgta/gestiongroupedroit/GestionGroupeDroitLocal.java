package com.yesserp.sessionbean.paramgta.gestiongroupedroit;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.GroupeDroit;

@Local
public interface GestionGroupeDroitLocal
{
	public void ajouterGroupeDroit(GroupeDroit groupeDroit) ;
	public void modifierGroupeDroit(GroupeDroit groupeDroit);
}
