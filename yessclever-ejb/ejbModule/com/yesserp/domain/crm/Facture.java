package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.lang.String;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Facture
 *
 */
@Entity
@Table(name="crm_fctruf01")
public class Facture implements Serializable {

	   
	
	private Long id;
	private String num;
	private String titre;
	private Date datedeb;
	private Date datefin;
	private double montantttc;
	private int tauxFodec;
	private int tauxRetenu;
	private double timbre;
	private boolean payement;
	private Achat achat;
	private Vente vente;
	private TypePayementFacture typePayementFacture;
	
	private List<EtatProcess> etatProcesses;
	private List<TabFactureService> tabFactureServices;
	private List<TabFactureProduit> tabFactureProduits;

	
	private static final long serialVersionUID = 1L;

	public Facture() {
		super();
	}   
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}   

	
	@ManyToOne
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat achat) {
		this.achat = achat;
	}
	
	@ManyToOne
	public Vente getVente() {
		return vente;
	}
	public void setVente(Vente vente) {
		this.vente = vente;
	}
	
	
	

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	


	
	
	@ManyToOne
	public TypePayementFacture getTypePayementFacture() {
		return typePayementFacture;
	}

	public void setTypePayementFacture(TypePayementFacture typePayementFacture) {
		this.typePayementFacture = typePayementFacture;
	}

	public boolean isPayement() {
		return payement;
	}

	public void setPayement(boolean payement) {
		this.payement = payement;
	}

	public double getMontantttc() {
		return montantttc;
	}

	public void setMontantttc(double montantttc) {
		this.montantttc = montantttc;
	}

	
	@OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
	public List<EtatProcess> getEtatProcesses() {
		return etatProcesses;
	}

	public void setEtatProcesses(List<EtatProcess> etatProcesses) {
		this.etatProcesses = etatProcesses;
	}

	
	@OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
	public List<TabFactureService> getTabFactureServices() {
		return tabFactureServices;
	}

	public void setTabFactureServices(List<TabFactureService> tabFactureServices) {
		this.tabFactureServices = tabFactureServices;
	}

	@OneToMany(mappedBy="facture",cascade=CascadeType.ALL)
	public List<TabFactureProduit> getTabFactureProduits() {
		return tabFactureProduits;
	}

	public void setTabFactureProduits(List<TabFactureProduit> tabFactureProduits) {
		this.tabFactureProduits = tabFactureProduits;
	}

	public int getTauxFodec() {
		return tauxFodec;
	}

	public void setTauxFodec(int tauxFodec) {
		this.tauxFodec = tauxFodec;
	}

	public int getTauxRetenu() {
		return tauxRetenu;
	}

	public void setTauxRetenu(int tauxRetenu) {
		this.tauxRetenu = tauxRetenu;
	}

	public double getTimbre() {
		return timbre;
	}

	public void setTimbre(double timbre) {
		this.timbre = timbre;
	}

	
	
	
   
}
