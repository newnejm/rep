package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Avoir
 *
 */
@Entity
@Table(name="crm_avoiuf01")
public class Avoir implements Serializable {

	

	private Long id;
	private String num;
	private Date datedeb;
	private Date datefin;
	private double montantttc;
	
	private List<EtatProcess> etatProcesses;
	private List<TabAvoirProduit> tabAvoirProduits;
	private List<TabAvoirService> tabAvoirServices;

	private static final long serialVersionUID = 1L;

	public Avoir() {
		super();
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

	public double getMontantttc() {
		return montantttc;
	}

	public void setMontantttc(double montantttc) {
		this.montantttc = montantttc;
	}


	
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	@OneToMany(mappedBy="avoir",cascade=CascadeType.ALL)
	public List<EtatProcess> getEtatProcesses() {
		return etatProcesses;
	}
	public void setEtatProcesses(List<EtatProcess> etatProcesses) {
		this.etatProcesses = etatProcesses;
	}
	
	@OneToMany(mappedBy="avoir",cascade=CascadeType.ALL)
	public List<TabAvoirProduit> getTabAvoirProduits() {
		return tabAvoirProduits;
	}
	public void setTabAvoirProduits(List<TabAvoirProduit> tabAvoirProduits) {
		this.tabAvoirProduits = tabAvoirProduits;
	}
	
	@OneToMany(mappedBy="avoir",cascade=CascadeType.ALL)
	public List<TabAvoirService> getTabAvoirServices() {
		return tabAvoirServices;
	}
	public void setTabAvoirServices(List<TabAvoirService> tabAvoirServices) {
		this.tabAvoirServices = tabAvoirServices;
	}
 

   
}
