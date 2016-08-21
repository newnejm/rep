package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.Long;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Suivi
 *
 */
@Entity

public class SuivieAction implements Serializable {

	private Long id;
	private Date dateSuivi;
	private String Note;
	private Action action;
	
	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateSuivi() {
		return dateSuivi;
	}
	public void setDateSuivi(Date dateSuivi) {
		this.dateSuivi = dateSuivi;
	}
	public String getNote() {
		return Note;
	}
	public void setNote(String note) {
		Note = note;
	}
	
	@ManyToOne
	public Action getAction() {
		return action;
	}
	public void setAction(Action action) {
		this.action = action;
	}

	private static final long serialVersionUID = 1L;

	public SuivieAction() {
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
