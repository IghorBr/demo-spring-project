package com.example.demo.domain;

import java.util.List;

public interface BaseService<T extends BaseDomain> {

	T save(T entity);
	List<T> findAll();
	T findByCode(String code);
	void deleteByCode(String code);
}
