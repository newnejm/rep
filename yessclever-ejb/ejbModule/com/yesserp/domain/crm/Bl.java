package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Bl
 *
 */
@Entity
@Table(name="crm_bnlvuf01")
public class Bl implements Serializable {

	   
	
	private Long id;
	private String num;
	private Date datedeb;
	private Date datefin;
	private double montantttc;
	private int tauxFodec;
	private int tauxRetenu;
	private double timbre;
	
	private List<EtatProcess> etatProcesses;
	private List<TabBlService> tabBlServices;
	private List<TabBlProduit> tabBlProduits;


	
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

	public double getMontantttc() {
		return montantttc;
	}

	public void setMontantttc(double montantttc) {
		this.montantttc = montantttc;
	}

	private static final long serialVersionUID = 1L;

	public Bl() {
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

	@OneToMany(mappedBy="bl",cascade=CascadeType.ALL)
	public List<EtatProcess> getEtatProcesses() {
		return etatProcesses;
	}

	public void setEtatProcesses(List<EtatProcess> etatProcesses) {
		this.etatProcesses = etatProcesses;
	}

	

	@OneToMany(mappedBy="bl",cascade=CascadeType.ALL)
	public List<TabBlService> getTabBlServices() {
		return tabBlServices;
	}

	public void setTabBlServices(List<TabBlService> tabBlServices) {
		this.tabBlServices = tabBlServices;
	}
	
	@OneToMany(mappedBy="bl",cascade=CascadeType.ALL)
	public List<TabBlProduit> getTabBlProduits() {
		return tabBlProduits;
	}

	public void setTabBlProduits(List<TabBlProduit> tabBlProduits) {
		this.tabBlProduits = tabBlProduits;
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
