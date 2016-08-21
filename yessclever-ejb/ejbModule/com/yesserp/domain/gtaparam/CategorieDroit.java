package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the gta_param_catg database table.
 * 
 */
@Entity
@Table(name="gta_param_catg")
public class CategorieDroit implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer idc;

	private String code;

	public CategorieDroit() {
	}

	public Integer getIdc() {
		return this.idc;
	}

	public void setIdc(Integer idc) {
		this.idc = idc;
	}

	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}

}