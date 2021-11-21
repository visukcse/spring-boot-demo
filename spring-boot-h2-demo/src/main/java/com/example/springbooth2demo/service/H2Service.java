package com.example.springbooth2demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.springbooth2demo.entity.H2Entity;
import com.example.springbooth2demo.repository.H2Repository;

@Service
public class H2Service {
	
	@Autowired
	private H2Repository h2Repository;

	public List<H2Entity> findAll() {
		return (List<H2Entity>) h2Repository.findAll();
	}

	public Optional<H2Entity> findById(Integer id) {
		return h2Repository.findById(id);
	}

	public H2Entity save(H2Entity entity) {
		return h2Repository.save(entity);
	}

	public List<H2Entity> saveAll(List<H2Entity> entities) {
		return (List<H2Entity>) h2Repository.saveAll(entities);
	}

	public void delete(Integer id) {
		h2Repository.deleteById(id);
	}

}
