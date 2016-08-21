package com.yesserp.domain.gs;

import java.io.Serializable;

import javax.persistence.Embeddable;

@Embeddable
public class Consomation_lot_pk implements Serializable {

	private int idLot;
	private int idConsomation;

	public Consomation_lot_pk() {

	}

	public int getIdLot() {
		return idLot;
	}

	public void setIdLot(int idLot) {
		this.idLot = idLot;
	}

	public int getIdConsomation() {
		return idConsomation;

	}

	public void setIdConsomation(int idConsomation) {
		this.idConsomation = idConsomation;
	}

	@Override
	public boolean equals(Object other) {
		return (other instanceof Consomation_lot_pk)
				&& ((this.idConsomation + "") != null) ? (this.idConsomation + "")
				.equals(((Consomation_lot_pk) other).idConsomation + "")
				: (other == this);
	}

	@Override
	public int hashCode() {
		return ((this.idConsomation + "") != null) ? (getClass().hashCode() + (this.idConsomation + "")
				.hashCode()) : super.hashCode();
	}

}
