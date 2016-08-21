package com.yesserp.domain.crm;

import java.io.Serializable;
import java.lang.String;
import java.util.Date;

import javax.persistence.*;

/**
 * Entity implementation class for Entity: Tache
 * 
 */
@Entity
@Table(name = "crm_tachrh01")
public class Tache implements Serializable {

	String id;
	String title;
	Date startDate;
	Date endDate;
	boolean allDay = false;
	String styleClass;

	private static final long serialVersionUID = 1L;

	public Tache() {
		super();
	}

	public Tache(String title, Date startDate, Date endDate, boolean allDay) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;
		this.allDay = allDay;
	}

	public Tache(String title, Date startDate, Date endDate) {
		this.title = title;
		this.startDate = startDate;
		this.endDate = endDate;

	}


	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}
	@Temporal(TemporalType.TIMESTAMP)
	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public boolean isAllDay() {
		return allDay;
	}

	public void setAllDay(boolean allDay) {
		this.allDay = allDay;
	}

	public String getStyleClass() {
		return styleClass;
	}

	public void setStyleClass(String styleClass) {
		this.styleClass = styleClass;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public String getId() {
		return this.id;
	}
	
	public void setId(String id) {
		this.id = id;
	}

	


	
	

}
