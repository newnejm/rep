package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: SaisieJour
 *
 */
@Entity
@Table(name="GTA_SJP_UF01")
public class SaisieJour implements Serializable {

	
	private int idsj;
	private String codesj;
	private Date datej;
	private static final long serialVersionUID = 1L;

	public SaisieJour() {
		super();
	}   
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public int getIdsj() {
		return this.idsj;
	}

	public void setIdsj(int idsj) {
		this.idsj = idsj;
	}   
	public String getCodesj() {
		return this.codesj;
	}

	public void setCodesj(String codesj) {
		this.codesj = codesj;
	}   
	public Date getDatej() {
		return this.datej;
	}

	public void setDatej(Date datej) {
		this.datej = datej;
	}
   
}
