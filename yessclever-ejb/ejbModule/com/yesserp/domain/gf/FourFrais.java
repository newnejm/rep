package com.yesserp.domain.gf;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

/**
 * Entity implementation class for Entity: FourFrais
 * 
 */
@Entity
public class FourFrais implements Serializable {

	private static final long serialVersionUID = 1L;
	private FourFraisC fourFraisC;
	private Frais frais;
	private FournisseurFrais fournisseurFrais;

	public FourFrais() {
		super();
	}

	@EmbeddedId
	public FourFraisC getFourFraisC() {
		return fourFraisC;
	}

	public void setFourFraisC(FourFraisC fourFraisC) {
		this.fourFraisC = fourFraisC;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idfrais", referencedColumnName = "id")
	public Frais getFrais() {
		return frais;
	}

	public void setFrais(Frais frais) {
		this.frais = frais;
	}

	@ManyToOne(cascade = CascadeType.MERGE)
	@JoinColumn(name = "idfournisseur", referencedColumnName = "id")
	public FournisseurFrais getFournisseurFrais() {
		return fournisseurFrais;
	}

	public void setFournisseurFrais(FournisseurFrais fournisseurFrais) {
		this.fournisseurFrais = fournisseurFrais;
	}

}
