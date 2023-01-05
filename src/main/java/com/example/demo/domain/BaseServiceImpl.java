package com.example.demo.domain;

import java.util.List;
import java.util.Optional;

import com.example.demo.exceptions.ObjectNotFoundException;
import org.springframework.stereotype.Service;

@Service
public abstract class BaseServiceImpl<T extends BaseDomain> implements BaseService<T> {

	private final BaseRepository<T> baseRepository;
	private final Class<T> entity;

	protected BaseServiceImpl(BaseRepository<T> baseRepository, Class<T> entity) {
		this.baseRepository = baseRepository;
		this.entity = entity;
	}

	@Override
	public T save(T entity) {
		return baseRepository.save(entity);
	}

	@Override
	public List<T> findAll() {
		return baseRepository.findAll();
	}

	@Override
	public T findByCode(String code) {
		return baseRepository.findByCode(code).orElseThrow(() -> new ObjectNotFoundException(
				String.format("Entity %s not found", entity.getSimpleName())
		));
	}

	@Override
	public void deleteByCode(String code) {
		T entity = this.findByCode(code);
		baseRepository.delete(entity);
	}
}
