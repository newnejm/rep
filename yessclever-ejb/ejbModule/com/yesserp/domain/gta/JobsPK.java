package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;
@Embeddable
public class JobsPK implements Serializable{
	
	private int adminId;
	private int paramId;
	private int groupeId;
	
	public JobsPK() {
	}
	
	
	
	@Column(name = "admin_fk" )
	public int getAdminId() {
		return adminId;
	}




	
	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}



	@Column(name = "param_fk" )
	public int getParamId() {
		return paramId;
	}




	public void setParamId(int paramId) {
		this.paramId = paramId;
	}


/*	@Column(name = "groupe_fk" )
	public int getGroupeId() {
		return groupeId;
	}

	public void setGroupeId(int groupeId) {
		this.groupeId = groupeId;
	}
*/

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + adminId;
		result = prime * result + paramId;
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
		JobsPK other = (JobsPK) obj;
		if (adminId != other.adminId)
			return false;
		if (paramId != other.paramId)
			return false;
		return true;
	}





	


	
	

}
