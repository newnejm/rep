package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DossierDocument
 *
 */
@Entity
@Table(name="crm_dsdcrh01")
public class DossierDocument implements Serializable {

	
	private Long id;
	private String nom;
	
	private List<DocumentCompte> documentComptes;
	private List<DocumentFournisseur> documentFournisseurs;

	
	private static final long serialVersionUID = 1L;

	public DossierDocument() {
		super();
	}   
	@Id    
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	@OneToMany(mappedBy="dossierDocument" ,cascade=CascadeType.ALL)
	public List<DocumentCompte> getDocumentComptes() {
		return documentComptes;
	}
	public void setDocumentComptes(List<DocumentCompte> documentComptes) {
		this.documentComptes = documentComptes;
	}
	
	@OneToMany(mappedBy="dossierDocument" ,cascade=CascadeType.ALL)
	public List<DocumentFournisseur> getDocumentFournisseurs() {
		return documentFournisseurs;
	}
	public void setDocumentFournisseurs(List<DocumentFournisseur> documentFournisseurs) {
		this.documentFournisseurs = documentFournisseurs;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
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
		DossierDocument other = (DossierDocument) obj;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		return true;
	}
   
	
}
