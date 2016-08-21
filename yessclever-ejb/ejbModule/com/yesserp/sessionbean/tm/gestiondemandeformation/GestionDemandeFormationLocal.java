package com.yesserp.sessionbean.tm.gestiondemandeformation;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.ga.Identite;
import com.yesserp.domain.tm.DemandeFormation;
import com.yesserp.domain.tm.Offre;


@Local
public interface GestionDemandeFormationLocal {
public List<DemandeFormation> findDemandesById(Identite iden);
public void ajouterDemande(Identite iden,List<DemandeFormation>df);
public void ajouter(Identite iden,List<DemandeFormation>df);
public void deleteDemande(Identite iden);
public void updateFormation(Identite iden);


}
