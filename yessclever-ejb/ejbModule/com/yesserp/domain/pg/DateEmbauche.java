package com.yesserp.domain.pg;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: DateEmbauche
 *
 */
@Entity
@Table(name = "pg_DateEmbauche")
@NamedQuery(name = "DateEmbauche.findAll", query = "SELECT g FROM DateEmbauche g")
public class DateEmbauche implements Serializable {

	
	private Long id;
	private Date MinDateEmbauche;
	private Date MaxDateEmbauche;
	private RechercheAvancee rechercheAvancee;
	private static final long serialVersionUID = 1L;

	public DateEmbauche() {
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

	public Date getMinDateEmbauche() {
		return MinDateEmbauche;
	}

	public void setMinDateEmbauche(Date minDateEmbauche) {
		MinDateEmbauche = minDateEmbauche;
	}

	public Date getMaxDateEmbauche() {
		return MaxDateEmbauche;
	}

	public void setMaxDateEmbauche(Date maxDateEmbauche) {
		MaxDateEmbauche = maxDateEmbauche;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idR")
	public RechercheAvancee getRechercheAvancee() {
		return rechercheAvancee;
	}

	public void setRechercheAvancee(RechercheAvancee rechercheAvancee) {
		this.rechercheAvancee = rechercheAvancee;
	}
	
   
}
