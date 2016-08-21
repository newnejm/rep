package com.yesserp.domain.pg;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.yesserp.domain.gtaparam.Libelle;


@Entity(name="pg_Tele")
@Table(name="pg_Tele")
public class Tel implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	public Tel() {	
	}
	
	private	int code;

	private List<Libelle> libelles;
	
	@Id
	public int getCode() {
		return code;
	}
	public void setCode(int code) {
		this.code = code;
	}

	
	
	
	
}
