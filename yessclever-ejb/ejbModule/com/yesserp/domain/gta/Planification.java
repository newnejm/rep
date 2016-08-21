package com.yesserp.domain.gta;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the "GTA_planuh01" database table.
 * 
 */
@Entity
@Table(name="\"gta_planuh01\"")
@NamedQuery(name="GTA_planuh01.findAll", query="SELECT g FROM Planification g")
public class Planification implements Serializable {
	private static final long serialVersionUID = 1L;

	private Integer id;

	public Planification() {
	}
    @Id
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

}