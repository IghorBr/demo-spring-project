package com.example.demo.domain;

import jakarta.persistence.MappedSuperclass;

import java.time.OffsetDateTime;
import java.util.Objects;
import java.util.UUID;

@MappedSuperclass
public abstract class BaseDomain {

	private final OffsetDateTime createdAt;
	private final String code;

	public BaseDomain() {
		this.createdAt = OffsetDateTime.now();
		this.code = UUID.randomUUID().toString();
	}

	public abstract Long getId();
	public abstract void setId(Long id);

	public OffsetDateTime getCreatedAt() {
		return createdAt;
	}

	public String getCode() {
		return code;
	}

	@Override
	public String toString() {
		return "" + getId() + "";
	}

	@Override
	public int hashCode() {
		return Objects.hash(getId());
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BaseDomain other = (BaseDomain) obj;
		return Objects.equals(getId(), other.getId());
	}

}
