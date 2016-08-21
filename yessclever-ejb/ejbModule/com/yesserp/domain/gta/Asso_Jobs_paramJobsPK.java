package com.yesserp.domain.gta;

import java.io.Serializable;

import javax.persistence.Embeddable;
@Embeddable
public class Asso_Jobs_paramJobsPK implements Serializable{
	private int id_job;
	private int id_job_excute;
	public int getId_job() {
		return id_job;
	}
	public void setId_job(int id_job) {
		this.id_job = id_job;
	}
	public int getId_job_excute() {
		return id_job_excute;
	}
	public void setId_job_excute(int id_job_excute) {
		this.id_job_excute = id_job_excute;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id_job;
		result = prime * result + id_job_excute;
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
		Asso_Jobs_paramJobsPK other = (Asso_Jobs_paramJobsPK) obj;
		if (id_job != other.id_job)
			return false;
		if (id_job_excute != other.id_job_excute)
			return false;
		return true;
	}

	
	
}

