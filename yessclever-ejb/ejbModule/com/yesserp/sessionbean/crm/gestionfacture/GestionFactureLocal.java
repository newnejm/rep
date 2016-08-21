package com.yesserp.sessionbean.crm.gestionfacture;

import java.util.List;

import javax.ejb.Local;

import com.yesserp.domain.crm.Bc;
import com.yesserp.domain.crm.Bl;
import com.yesserp.domain.crm.Compte;
import com.yesserp.domain.crm.Devis;
import com.yesserp.domain.crm.EtatProcess;
import com.yesserp.domain.crm.Facture;
import com.yesserp.domain.crm.Fournisseur;
import com.yesserp.domain.crm.ParamFacture;
import com.yesserp.domain.crm.ParametrageTaxe;
import com.yesserp.domain.crm.TabAvoirProduit;
import com.yesserp.domain.crm.TabAvoirService;
import com.yesserp.domain.crm.TabBcProduit;
import com.yesserp.domain.crm.TabBcService;
import com.yesserp.domain.crm.TabBlProduit;
import com.yesserp.domain.crm.TabBlService;
import com.yesserp.domain.crm.TabDevisProduit;
import com.yesserp.domain.crm.TabDevisService;
import com.yesserp.domain.crm.TabFactureProduit;
import com.yesserp.domain.crm.TabFactureService;
import com.yesserp.domain.crm.TauxCompte;
import com.yesserp.domain.crm.Taxe;
import com.yesserp.domain.crm.TypePayementFacture;
import com.yesserp.domain.crm.TypeProcess;

@Local
public interface GestionFactureLocal {

	public void ajouterFacture(Facture i);

	public void supprimerFacture(Facture i);

	public void modifierFacture(Facture i);

	public List<Facture> AfficherTousFacture();

	public TypePayementFacture ChercherTypePayementFacture(String nom);

	public List<TypePayementFacture> AfficherTousTypePayementFacture();

	public TauxCompte ChercherTauxCompteFodec(Compte compte);

	public TauxCompte ChercherTauxCompteRetenu(Compte compte);

	public ParametrageTaxe ChercherTauxTVA(int nomtaux, int nomtaxe);

	public TauxCompte ChercherTauxCompteTVA(Compte compte);

	public List<ParamFacture> AfficherTousParamFacture();

	public void ajouterParamFacture(List<ParamFacture> ParamFactures);

	public void modifierParamFacture(ParamFacture i);

	public ParamFacture ChercherParamFactureParNom(String nom);


	public List<EtatProcess> AfficherEtatProcessVente(Compte compte);

	public List<EtatProcess> AfficherEtatProcessAchat(Fournisseur fournisseur);

	public EtatProcess ChercherEtatProcess(String nom);

	public void ajouterDevis(Devis i);

	public void ajouterBc(Bc i);

	public void ajouterBl(Bl i);

	
	public void modifierDevis(Devis i);

	public void modifierBl(Bl i);

	public void modifierBc(Bc i);

	
	public TypeProcess ChercherTypeProcess(String nom);

	public void ajouterEtatProcess(EtatProcess i);

	public void modifierEtatProcess(EtatProcess i);

	public void ajouterTabDevisProduit(TabDevisProduit i);

	public void ajouterTabDevisService(TabDevisService i);

	public void ajouterTabBcProduit(TabBcProduit i);

	public void ajouterTabBcService(TabBcService i);



	public void modifierTabDevisProduit(TabDevisProduit i);

	public void modifierTabDevisService(TabDevisService i);

	public void modifierTabBcProduit(TabBcProduit i);

	public void modifierTabBcService(TabBcService i);



	public List<TabDevisProduit> FindTabProduitByDevis(Devis devis);

	public List<TabDevisService> FindTabServiceByDevis(Devis devis);

	public List<TabBcProduit> FindTabProduitByBc(Bc bc);

	public List<TabBcService> FindTabServiceByBc(Bc bc);





	public void supprimerTabBcService(TabBcService i);

	public void supprimerTabBcProduit(TabBcProduit i);

	public void supprimerTabDevisService(TabDevisService i);

	public void supprimerTabDevisProduit(TabDevisProduit i);

	public void ajouterTabBlProduit(TabBlProduit i);

	public void ajouterTabBlService(TabBlService i);

	public void ajouterTabFactureProduit(TabFactureProduit i);

	public void ajouterTabFactureService(TabFactureService i);

	public void ajouterTabAvoirProduit(TabAvoirProduit i);

	public void ajouterTabAvoirService(TabAvoirService i);

	public void modifierTabBlProduit(TabBlProduit i);

	public void modifierTabBlService(TabBlService i);

	public void modifierTabFactureProduit(TabFactureProduit i);

	public void modifierTabFactureService(TabFactureService i);

	public void modifierTabAvoirProduit(TabAvoirProduit i);

	public void modifierTabAvoirService(TabAvoirService i);

	public void supprimerTabBlProduit(TabBlProduit i);

	public void supprimerTabBlService(TabBlService i);

	public void supprimerTabFactureProduit(TabFactureProduit i);

	public void supprimerTabFactureService(TabFactureService i);

	public void supprimerTabAvoirProduit(TabAvoirProduit i);

	public void supprimerTabAvoirService(TabAvoirService i);

	public List<TabFactureProduit> FindTabProduitByFacture(Facture facture);

	public List<TabFactureService> FindTabServiceByFacture(Facture facture);

	public List<TabBlProduit> FindTabProduitByBl(Bl bl);

	public List<TabBlService> FindTabServiceByBl(Bl bl);


}
