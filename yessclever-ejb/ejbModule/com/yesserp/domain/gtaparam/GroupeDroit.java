package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the gta_param_gdroit database table.
 * 
 */
@Entity
@Table(name="gta_param_gdroit")
public class GroupeDroit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idgrpd;

	private String code;

	//bi-directional many-to-one association to GtaParamDroit
	@OneToMany(mappedBy="gtaParamGdroit")
	private List<Droit> gtaParamDroits;

	public GroupeDroit() {
	}

	public Integer getIdgrpd() {
		return this.idgrpd;
	}

	public void setIdgrpd(Integer idgrpd) {
		this.idgrpd = idgrpd;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<Droit> getGtaParamDroits() {
		return this.gtaParamDroits;
	}

	public void setGtaParamDroits(List<Droit> gtaParamDroits) {
		this.gtaParamDroits = gtaParamDroits;
	}

	public Droit addGtaParamDroit(Droit gtaParamDroit) {
		getGtaParamDroits().add(gtaParamDroit);
		gtaParamDroit.setGtaParamGdroit(this);

		return gtaParamDroit;
	}

	public Droit removeGtaParamDroit(Droit gtaParamDroit) {
		getGtaParamDroits().remove(gtaParamDroit);
		gtaParamDroit.setGtaParamGdroit(null);

		return gtaParamDroit;
	}

}