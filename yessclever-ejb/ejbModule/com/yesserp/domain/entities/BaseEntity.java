package com.yesserp.domain.entities;

import java.util.UUID;

public abstract class BaseEntity {

	private transient String id = createId();

	public String getId() {
		return this.id;
	}

	public void setId(String value) {
		this.id = value;
	}

	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || !(o instanceof BaseEntity)) {
			return false;
		}

		BaseEntity other = (BaseEntity) o;

		// if the id is missing, return false
		if (id == null)
			return false;

		// equivalence by id
		return id.equals(other.getId());
	}

	public int hashCode() {
		if (id != null) {
			return id.hashCode();
		} else {
			return super.hashCode();
		}
	}

	public String toString() {
		return this.getClass().getName() + "[id=" + id + "]";
	}

	public static String createId() {
		UUID uuid = java.util.UUID.randomUUID();
		return uuid.toString();
	}

	public void regenerateId() {
		id = createId();
	}
}
