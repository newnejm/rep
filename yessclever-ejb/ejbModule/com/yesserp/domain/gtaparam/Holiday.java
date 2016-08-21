package com.yesserp.domain.gtaparam;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "GTA_HOLY")
public class Holiday implements Serializable {

		/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
		@Id
		@GeneratedValue(strategy = GenerationType.AUTO)
		private int id;
		private String title;
		private Date startDate;
		private Date endDate;
		private boolean editable;
		private String type;

		public int getId() {
			return id;
		}

		public void setId(int id) {
			this.id = id;
		}

		
		
		public String getTitle() {
			return title;
		}

		public void setTitle(String title) {
			this.title = title;
		}

		public Date getStartDate() {
			return startDate;
		}

		public void setStartDate(Date startDate) {
			this.startDate = startDate;
		}

		public Date getEndDate() {
			return endDate;
		}

		public void setEndDate(Date endDate) {
			this.endDate = endDate;
		}

		public boolean isEditable() {
			return editable;
		}

		public void setEditable(boolean editable) {
			this.editable = editable;
		}

		public String getType() {
			return type;
		}

		public void setType(String type) {
			this.type = type;
		}

		@Override
		public int hashCode() {
			return getId();
		}
		
		@Override
		public boolean equals(Object obj) {
			
			if(obj instanceof Holiday){
				Holiday Holiday = (Holiday) obj;
				return Holiday.getId() == getId();
			}
			
			return false;
		}
	}


