package com.yesserp.domain.gtaparam;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: SaisieHeure
 * 
 */
@Entity
@Table(name = "GTA_SHP_UF01")
public class SaisieHeure implements Serializable {

	private int idsh;
	private String codesh;
	private int heure;
	private static final long serialVersionUID = 1L;

	public SaisieHeure() {
		super();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdsh() {
		return this.idsh;
	}

	public void setIdsh(int idsh) {
		this.idsh = idsh;
	}

	public String getCodesh() {
		return this.codesh;
	}

	public void setCodesh(String codesh) {
		this.codesh = codesh;
	}

	public int getHeure() {
		return this.heure;
	}

	public void setHeure(int heure) {
		this.heure = heure;
	}

}
