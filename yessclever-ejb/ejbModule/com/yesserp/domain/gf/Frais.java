package com.yesserp.domain.gf;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: Frais
 * 
 */
@Entity
@Table(name = "gf_frairh01")
public class Frais implements Serializable {

	private Long id;
	private String type;
	private int montantLimite;
	private int dureeMax;
	private List<Remboursement> remboursements;
	private List<ModaliteConsommation> modaliteConsommations;
	private List<FourFrais> fourFrais;
	private List<DemandeFrais> demandesFrais = new ArrayList<DemandeFrais>();
	private static final long serialVersionUID = 1L;

	public Frais() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getMontantLimite() {
		return this.montantLimite;
	}

	public void setMontantLimite(int montantLimite) {
		this.montantLimite = montantLimite;
	}

	public int getDureeMax() {
		return this.dureeMax;
	}

	public void setDureeMax(int dureeMax) {
		this.dureeMax = dureeMax;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<Remboursement> getRemboursements() {
		return remboursements;
	}

	public void setRemboursements(List<Remboursement> remboursements) {
		this.remboursements = remboursements;
	}

	@ManyToMany(fetch = FetchType.EAGER)
	public List<ModaliteConsommation> getModaliteConsommations() {
		return modaliteConsommations;
	}

	public void setModaliteConsommations(
			List<ModaliteConsommation> modaliteConsommations) {
		this.modaliteConsommations = modaliteConsommations;
	}

	@OneToMany(mappedBy = "frais")
	public List<FourFrais> getFourFrais() {
		return fourFrais;
	}

	public void setFourFrais(List<FourFrais> fourFrais) {
		this.fourFrais = fourFrais;
	}

	@OneToMany(mappedBy = "frais")
	public List<DemandeFrais> getDemandesFrais() {
		return demandesFrais;
	}

	public void setDemandesFrais(List<DemandeFrais> demandesFrais) {
		this.demandesFrais = demandesFrais;
	}

	@Override
	public String toString() {
		return type;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((type == null) ? 0 : type.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Frais other = (Frais) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}

}
