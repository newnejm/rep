package com.yesserp.domain.gta;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 * Entity implementation class for Entity: TypeCalucle
 * 
 */
@Entity
@Table(name="gta_typeCalcul")
public class TypeCalucle implements Serializable {

	private int id;
	private String type;
	private List<DateCalculGta> dateCalculGtas;
	private static final long serialVersionUID = 1L;

	public TypeCalucle() {
		super();
	}

	@Id
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	@ManyToMany(mappedBy = "typeCalucles")
	public List<DateCalculGta> getDateCalculGtas() {
		return dateCalculGtas;
	}

	public void setDateCalculGtas(List<DateCalculGta> dateCalculGtas) {
		this.dateCalculGtas = dateCalculGtas;
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
		TypeCalucle other = (TypeCalucle) obj;
		if (type == null) {
			if (other.type != null)
				return false;
		} else if (!type.equals(other.type))
			return false;
		return true;
	}
	

}
