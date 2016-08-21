 package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Devis
 *
 */
@Entity
@Table(name="crm_deviuf01")
public class Devis implements Serializable {

	   
	
	private Long id;
	private String num;
	private Date datedeb;
	private Date datefin;
	private double montantttc;
	private int tauxFodec;
	private int tauxRetenu;
	private double timbre;
	
	private List<EtatProcess> etatProcesses;
	private List<TabDevisService> tabDevisServices;
	private List<TabDevisProduit> tabDevisProduits;

	
	private static final long serialVersionUID = 1L;

	public Devis() {
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
	

	public double getMontantttc() {
		return montantttc;
	}

	public void setMontantttc(double montantttc) {
		this.montantttc = montantttc;
	}

	public String getNum() {
		return num;
	}

	public void setNum(String num) {
		this.num = num;
	}

	
	@Temporal(TemporalType.DATE)
	public Date getDatedeb() {
		return datedeb;
	}

	public void setDatedeb(Date datedeb) {
		this.datedeb = datedeb;
	}

	
	@Temporal(TemporalType.DATE)
	public Date getDatefin() {
		return datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	@OneToMany(mappedBy="devis",cascade=CascadeType.ALL)
	public List<EtatProcess> getEtatProcesses() {
		return etatProcesses;
	}

	public void setEtatProcesses(List<EtatProcess> etatProcesses) {
		this.etatProcesses = etatProcesses;
	}

	
	
	@OneToMany(mappedBy="devis",cascade=CascadeType.ALL)
	public List<TabDevisService> getTabDevisServices() {
		return tabDevisServices;
	}

	public void setTabDevisServices(List<TabDevisService> tabDevisServices) {
		this.tabDevisServices = tabDevisServices;
	}
	
	@OneToMany(mappedBy="devis",cascade=CascadeType.ALL)
	public List<TabDevisProduit> getTabDevisProduits() {
		return tabDevisProduits;
	}

	public void setTabDevisProduits(List<TabDevisProduit> tabDevisProduits) {
		this.tabDevisProduits = tabDevisProduits;
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
