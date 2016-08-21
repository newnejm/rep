package com.yesserp.domain.access;

import java.io.Serializable;
import java.lang.String;
import javax.persistence.*;

/**
 * Entity implementation class for Entity: Menu
 *
 */
@Entity

public class Menu implements Serializable {

	
	private int id_menu;
	private String menu;
	private String lien;
	private String parentee;
	private String ordre;
	private Operation operation;
	private static final long serialVersionUID = 1L;

	public Menu() {
		super();
	}  
	
	public Menu(int id_menu, String menu, String lien, String parentee,
			String ordre) {
		super();
		this.id_menu = id_menu;
		this.menu = menu;
		this.lien = lien;
		this.parentee = parentee;
		this.ordre = ordre;
	}

	@Id    
	@GeneratedValue(strategy=GenerationType.AUTO)
	public int getId_menu() {
		return this.id_menu;
	}

	public void setId_menu(int id_menu) {
		this.id_menu = id_menu;
	}   
	public String getMenu() {
		return this.menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}   
	public String getLien() {
		return this.lien;
	}

	public void setLien(String lien) {
		this.lien = lien;
	}   
	public String getParentee() {
		return this.parentee;
	}

	public void setParentee(String parentee) {
		this.parentee = parentee;
	}
	public String getOrdre() {
		return ordre;
	}
	public void setOrdre(String ordre) {
		this.ordre = ordre;
	}
	@ManyToOne
	@JoinColumn(name="operation_fk")
	public Operation getOperation() {
		return operation;
	}
	public void setOperation(Operation operation) {
		this.operation = operation;
	}
   
}
