package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.lang.String;

import javax.persistence.*;

import com.yesserp.domain.gta.ContratGta;

/**
 * Entity implementation class for Entity: TerminalMobile
 *
 */
@Entity
@Table(name="gtaparam_TerminalMobile")

public class TerminalMobile implements Serializable {

	
	private int idTerminal;
	private String code;
	private String libelle;
	private ContratGta contratGta ;
	private static final long serialVersionUID = 1L;

	public TerminalMobile() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public int getIdTerminal() {
		return this.idTerminal;
	}

	public void setIdTerminal(int idTerminal) {
		this.idTerminal = idTerminal;
	}   
	public String getCode() {
		return this.code;
	}

	public void setCode(String code) {
		this.code = code;
	}   
	public String getLibelle() {
		return this.libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((code == null) ? 0 : code.hashCode());
		result = prime * result + idTerminal;
		result = prime * result + ((libelle == null) ? 0 : libelle.hashCode());
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
		TerminalMobile other = (TerminalMobile) obj;
		if (code == null) {
			if (other.code != null)
				return false;
		} else if (!code.equals(other.code))
			return false;
		if (idTerminal != other.idTerminal)
			return false;
		if (libelle == null) {
			if (other.libelle != null)
				return false;
		} else if (!libelle.equals(other.libelle))
			return false;
		return true;
	}
	
	@ManyToOne
	@JoinColumn(name="contratGta_fk")
	public ContratGta getContratGta() {
		return contratGta;
	}
	public void setContratGta(ContratGta contratGta) {
		this.contratGta = contratGta;
	}
	@Override
	public String toString() {
		return  code;
	}
	
	
   
	
}
