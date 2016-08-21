package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: ObjectifCommercialExterne
 *
 */
@Entity
@Table(name="crm_obcerh01")
public class ObjectifCommercialExterne implements Serializable {

	
	private Long id;
	private Long nombre;
	private String type;
	private Date datDebut;
	private Date datFin;
    private String Descrip;
	
    private CommercialExterne commercialExterne;     
	
    public Long getNombre() {
		return nombre;
	}
	public void setNombre(Long nombre) {
		this.nombre = nombre;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatDebut() {
		return datDebut;
	}
	public void setDatDebut(Date datDebut) {
		this.datDebut = datDebut;
	}
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDatFin() {
		return datFin;
	}
	public void setDatFin(Date datFin) {
		this.datFin = datFin;
	}
	public String getDescrip() {
		return Descrip;
	}
	public void setDescrip(String descrip) {
		Descrip = descrip;
	}
	
	
	@ManyToOne
	public CommercialExterne getCommercialExterne() {
		return commercialExterne;
	}
	public void setCommercialExterne(CommercialExterne commercialExterne) {
		this.commercialExterne = commercialExterne;
	}

	private static final long serialVersionUID = 1L;

	public ObjectifCommercialExterne() {
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
   
}
