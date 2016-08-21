package com.yesserp.sessionbean.paramgta.tranchedroit;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gtaparam.TrancheDroit;

@Local
public interface GestionTrancheDroitLocal {
	
	public void ajoutTrancheDroit(TrancheDroit trancheDroit);

	public void supprimerTrancheDroit(TrancheDroit trancheDroit);

	public void modifierTrancheDroit(TrancheDroit trancheDroit);

	public List<TrancheDroit> listerTrancheDroit();

	public TrancheDroit findTrancheDroitById(int id);
}
