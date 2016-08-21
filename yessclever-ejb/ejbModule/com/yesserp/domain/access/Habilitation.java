package com.yesserp.domain.access;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Habilitation
 * 
 */
@Entity
public class Habilitation implements Serializable {

	private int id_habilitation;
	private boolean insertion;
	private boolean modification;
	private boolean suppression;
	private Role role;
	private Operation operation;

	private static final long serialVersionUID = 1L;

	public Habilitation() {
		super();
	}

	public Habilitation(int id_habilitation, boolean insertion,
			boolean modification, boolean suppression) {
		super();
		this.id_habilitation = id_habilitation;
		this.insertion = insertion;
		this.modification = modification;
		this.suppression = suppression;
	}

	@Id
	public int getId_habilitation() {
		return this.id_habilitation;
	}

	public void setId_habilitation(int id_habilitation) {
		this.id_habilitation = id_habilitation;
	}

	public boolean isInsertion() {
		return insertion;
	}

	public void setInsertion(boolean insertion) {
		this.insertion = insertion;
	}

	public boolean isModification() {
		return modification;
	}

	public void setModification(boolean modification) {
		this.modification = modification;
	}

	public boolean isSuppression() {
		return suppression;
	}

	public void setSuppression(boolean suppression) {
		this.suppression = suppression;
	}

	@ManyToOne
	@JoinColumn(name = "role_fk")
	public Role getRole() {
		return role;
	}

	public void setRole(Role role) {
		this.role = role;
	}

	@ManyToOne
	@JoinColumn(name = "operation_fk")
	public Operation getOperation() {
		return operation;
	}

	public void setOperation(Operation operation) {
		this.operation = operation;
	}
}
