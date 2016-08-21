package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Operation
 * 
 */
@Entity
public class Operation implements Serializable {

	private int id_operation;
	private String lib_operation;
	private List<Menu> menus;
	private List<Habilitation> habilitations;
	private static final long serialVersionUID = 1L;

	public Operation() {
		super();
	}

	public Operation(int id_operation, String lib_operation) {
		super();
		this.id_operation = id_operation;
		this.lib_operation = lib_operation;
	}

	@Id
	public int getId_operation() {
		return this.id_operation;
	}

	public void setId_operation(int id_operation) {
		this.id_operation = id_operation;
	}

	public String getLib_operation() {
		return this.lib_operation;
	}

	public void setLib_operation(String lib_operation) {
		this.lib_operation = lib_operation;
	}

	@OneToMany(mappedBy = "operation", cascade = CascadeType.PERSIST)
	public List<Menu> getMenus() {
		if (menus == null) {
			menus = new ArrayList<Menu>();
		}
		return menus;
	}

	public void setMenus(List<Menu> menus) {
		this.menus = menus;
	}

	public void addMenu(Menu menu) {
		menu.setOperation(this);
		this.getMenus().add(menu);

	}

	@OneToMany(mappedBy = "operation", cascade = CascadeType.ALL)
	public List<Habilitation> getHabilitations() {
		if (habilitations == null) {
			habilitations = new ArrayList<Habilitation>();
		}
		return habilitations;
	}

	public void setHabilitations(List<Habilitation> habilitations) {
		this.habilitations = habilitations;
	}

}
