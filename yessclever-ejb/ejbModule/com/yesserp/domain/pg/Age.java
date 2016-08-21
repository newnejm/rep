package com.yesserp.domain.pg;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Age
 *
 */
@Entity
@Table(name = "pg_Age")
@NamedQuery(name = "Age.findAll", query = "SELECT g FROM Age g")
public class Age implements Serializable {

	
	private Long id;
	private int minAge;
	private  int maxAge;
	private Date MinDateNaissance;
	private Date MaxDateNaissance;
	private RechercheAvancee rechercheAvancee;
	private static final long serialVersionUID = 1L;

	public Age() {
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

	public int getMinAge() {
		return minAge;
	}

	public void setMinAge(int minAge) {
		this.minAge = minAge;
	}

	public int getMaxAge() {
		return maxAge;
	}

	public void setMaxAge(int maxAge) {
		this.maxAge = maxAge;
	}

	public Date getMinDateNaissance() {
		return MinDateNaissance;
	}

	public void setMinDateNaissance(Date minDateNaissance) {
		MinDateNaissance = minDateNaissance;
	}

	public Date getMaxDateNaissance() {
		return MaxDateNaissance;
	}

	public void setMaxDateNaissance(Date maxDateNaissance) {
		MaxDateNaissance = maxDateNaissance;
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
