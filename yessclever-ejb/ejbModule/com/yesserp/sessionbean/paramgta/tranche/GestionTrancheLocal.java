package com.yesserp.sessionbean.paramgta.tranche;

import java.util.Date;
import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.gta.Absence;
import com.yesserp.domain.gta.Tranche;
import com.yesserp.domain.gtaparam.TrancheDroit;

@Local
public interface GestionTrancheLocal {

	public void ajoutTranche(TrancheDroit tranche);

	public void supprimerTranche(TrancheDroit tranche);

	public void modifierTranche(TrancheDroit tranche);

	public List<TrancheDroit> listerTranche();

	public TrancheDroit findTrancheById(int id);

	public List<Tranche> findByAbsence(Absence absence, Date date);
}
