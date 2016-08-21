package com.yesserp.domain.crm;

import java.io.Serializable;

import javax.persistence.*;

import java.util.List;

import com.yesserp.domain.gs.Categorie;
import com.yesserp.domain.gs.Sous_Categorie;
import com.yesserp.domain.gs.Stock;
import com.yesserp.domain.gs.Umesure;
import com.yesserp.type.gs.TypeProd;

/**
 * Entity implementation class for Entity: Produit
 * 
 */
@Entity
@Table(name = "crm_prodrh01")
public class Produit implements Serializable {

	private Long id;
	private String nomprod;
	private String codeprod;
	private double prixht;
	private String ref;

	private Opportunite opportunite;
	private Remise remise;
	private TypeProduit typeProduit;
	
	
	private List<TabDevisProduit> tabDevisProduits;
	private List<TabBcProduit> tabBcProduits;
	private List<TabBlProduit> tabBlProduits;
	private List<TabFactureProduit> tabFactureProduits;
	private List<TabAvoirProduit> tabAvoirProduits;




	
	private String code;
	private TypeProd type;
	private double c_achat;
	private double c_vente;
	private double TVA;
	private boolean peris;
	private Umesure umes;

	private Categorie cat;
	private Sous_Categorie s_cat;
	private Stock stock;
	
	private List<Concurrent> concurrents;
	private List<Compagne>compagnes;
	private Taxe taxe;
	
	

	private static final long serialVersionUID = 1L;

	public Produit() {
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

	public String getNomprod() {
		return this.nomprod;
	}

	public void setNomprod(String nomprod) {
		this.nomprod = nomprod;
	}

	public String getCodeprod() {
		return this.codeprod;
	}

	public void setCodeprod(String codeprod) {
		this.codeprod = codeprod;
	}

	public double getPrixht() {
		return this.prixht;
	}

	public void setPrixht(double prixht) {
		this.prixht = prixht;
	}

	public String getRef() {
		return this.ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	@ManyToOne
	public Opportunite getOpportunite() {
		return opportunite;
	}

	public void setOpportunite(Opportunite opportunite) {
		this.opportunite = opportunite;
	}

	@ManyToOne
	public Remise getRemise() {
		return remise;
	}

	public void setRemise(Remise remise) {
		this.remise = remise;
	}


	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<Concurrent> getConcurrents() {
		return concurrents;
	}

	public void setConcurrents(List<Concurrent> concurrents) {
		this.concurrents = concurrents;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nomprod == null) ? 0 : nomprod.hashCode());
		return result;
	}

	@ManyToOne
	public TypeProduit getTypeProduit() {
		return typeProduit;
	}
	public void setTypeProduit(TypeProduit typeProduit) {
		this.typeProduit = typeProduit;
	}
	

	@ManyToOne
	public Taxe getTaxe() {
		return taxe;
	}

	public void setTaxe(Taxe taxe) {
		this.taxe = taxe;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produit other = (Produit) obj;
		if (nomprod == null) {
			if (other.nomprod != null)
				return false;
		} else if (!nomprod.equals(other.nomprod))
			return false;
		return true;
	}
   

	/* deb ajout Omar */
	

	@Column(unique = true)
	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public TypeProd getType() {
		return type;
	}

	public void setType(TypeProd type) {
		this.type = type;
	}

	public double getC_achat() {
		return c_achat;
	}

	public void setC_achat(double c_achat) {
		this.c_achat = c_achat;
	}

	public double getC_vente() {
		return c_vente;
	}

	public void setC_vente(double c_vente) {
		this.c_vente = c_vente;
	}

	public double getTVA() {
		return TVA;
	}

	public void setTVA(double tVA) {
		TVA = tVA;
	}

	public boolean isPeris() {
		return peris;
	}

	public void setPeris(boolean peris) {
		this.peris = peris;
	}

	@ManyToOne
	public Categorie getCat() {
		return cat;
	}

	public void setCat(Categorie cat) {
		this.cat = cat;
	}

	@ManyToOne
	public Sous_Categorie getS_cat() {
		return s_cat;
	}

	public void setS_cat(Sous_Categorie s_cat) {
		this.s_cat = s_cat;
	}

	@OneToOne
	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	@ManyToOne
	public Umesure getUmes() {
		return umes;
	}

	public void setUmes(Umesure umes) {
		this.umes = umes;
	}
	/* fin ajout Omar */

	@ManyToMany
	public List<Compagne> getCompagnes() {
		return compagnes;
	}

	public void setCompagnes(List<Compagne> compagnes) {
		this.compagnes = compagnes;
	}
	
	
	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<TabDevisProduit> getTabDevisProduits() {
		return tabDevisProduits;
	}

	public void setTabDevisProduits(List<TabDevisProduit> tabDevisProduits) {
		this.tabDevisProduits = tabDevisProduits;
	}

	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<TabBcProduit> getTabBcProduits() {
		return tabBcProduits;
	}

	public void setTabBcProduits(List<TabBcProduit> tabBcProduits) {
		this.tabBcProduits = tabBcProduits;
	}

	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<TabBlProduit> getTabBlProduits() {
		return tabBlProduits;
	}

	public void setTabBlProduits(List<TabBlProduit> tabBlProduits) {
		this.tabBlProduits = tabBlProduits;
	}

	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<TabFactureProduit> getTabFactureProduits() {
		return tabFactureProduits;
	}

	public void setTabFactureProduits(List<TabFactureProduit> tabFactureProduits) {
		this.tabFactureProduits = tabFactureProduits;
	}

	@OneToMany(mappedBy="produit",cascade=CascadeType.ALL)
	public List<TabAvoirProduit> getTabAvoirProduits() {
		return tabAvoirProduits;
	}

	public void setTabAvoirProduits(List<TabAvoirProduit> tabAvoirProduits) {
		this.tabAvoirProduits = tabAvoirProduits;
	}

}
