package com.yesserp.domain.gs;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Inventaire_stock_pk implements Serializable {

	private int idstock;
	private int idinv;

	public int getIdstock() {
		return idstock;
	}

	public void setIdstock(int idstock) {
		this.idstock = idstock;
	}

	public int getIdinv() {
		return idinv;
	}

	public void setIdinv(int idinv) {
		this.idinv = idinv;
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof Consomation_lot_pk)
				&& ((this.idinv + "") != null) ? (this.idinv + "")
				.equals(((Inventaire_stock_pk) other).idinv + "")
				: (other == this);
	}

	@Override
	public int hashCode() {
		return ((this.idinv + "") != null) ? (getClass().hashCode() + (this.idinv + "")
				.hashCode()) : super.hashCode();
	}
}
