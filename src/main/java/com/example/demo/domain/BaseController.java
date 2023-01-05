package com.example.demo.domain;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

@RestController
public abstract class BaseController<T extends BaseDomain, K extends BaseDTO> {

	@Autowired private BaseService<T> baseService;
	private ModelMapper mapper = new ModelMapper();
	private Class<T> entityTarget;
	private Class<K> dtoTarget;
	
	public BaseController(Class<T> entity, Class<K> dto) {
		this.entityTarget = entity;
		this.dtoTarget = dto;
	}

	@GetMapping
	public ResponseEntity<List<K>> findAll() {
		List<T> entities = baseService.findAll();
		List<K> dtos = this.mapList(entities);
		
		return ResponseEntity.ok().body(dtos);
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<K> findById(@PathVariable String code) {
		T entity = baseService.findByCode(code);
		K dto = mapper.map(entity, dtoTarget);
		return ResponseEntity.ok().body(dto);
	}
	
	protected List<K> mapList(List<T> source) {
	    return source
	    	      .stream()
	    	      .map(element -> mapper.map(element, dtoTarget))
	    	      .collect(Collectors.toList());
	}
	
}
