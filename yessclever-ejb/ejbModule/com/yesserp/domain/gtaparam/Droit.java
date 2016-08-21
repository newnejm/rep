package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the gta_param_droit database table.
 * 
 */
@Entity
@Table(name="gta_param_droit")
public class Droit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idd;

	private String code;

	@Temporal(TemporalType.DATE)
	private Date dateeffet;

	@Temporal(TemporalType.DATE)
	private Date datefin;

	private Integer delaicarence;

	//bi-directional many-to-one association to GtaParamGdroit
	@ManyToOne
	@JoinColumn(name="idgrpd")
	private GroupeDroit gtaParamGdroit;



	//bi-directional one-to-one association to GtaParamTranche
	@OneToOne
	@JoinColumn(name="idt")
	private TrancheDroit gtaParamTranche;

	public Droit() {
	}

	public Integer getIdd() {
		return this.idd;
	}

	public void setIdd(Integer idd) {
		this.idd = idd;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getDateeffet() {
		return this.dateeffet;
	}

	public void setDateeffet(Date dateeffet) {
		this.dateeffet = dateeffet;
	}

	public Date getDatefin() {
		return this.datefin;
	}

	public void setDatefin(Date datefin) {
		this.datefin = datefin;
	}

	public Integer getDelaicarence() {
		return this.delaicarence;
	}

	public void setDelaicarence(Integer delaicarence) {
		this.delaicarence = delaicarence;
	}

	public GroupeDroit getGtaParamGdroit() {
		return this.gtaParamGdroit;
	}

	public void setGtaParamGdroit(GroupeDroit gtaParamGdroit) {
		this.gtaParamGdroit = gtaParamGdroit;
	}





	

	public TrancheDroit getGtaParamTranche() {
		return this.gtaParamTranche;
	}

	public void setGtaParamTranche(TrancheDroit gtaParamTranche) {
		this.gtaParamTranche = gtaParamTranche;
	}

}