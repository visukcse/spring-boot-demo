package com.example.springbooth2demo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springbooth2demo.entity.H2Entity;
import com.example.springbooth2demo.service.H2Service;

@RestController
@RequestMapping("/employee")
public class H2Controller {
	
	@Autowired
	H2Service h2Service;
	
	@GetMapping("/")
	public List<H2Entity> findAll(){
		return h2Service.findAll();
		
	}

	@GetMapping("/{id}")
	public ResponseEntity<H2Entity> findById(@PathVariable Integer id){
		H2Entity entity = h2Service.findById(id).orElse(null);
		if(entity==null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(entity);
		
	}
	
	@PostMapping("/")
	public H2Entity save(@RequestBody H2Entity entity) {
		System.out.println("H2 new entity: " + entity);
		return h2Service.save(entity);
	}

	@PostMapping("/more")
	public List<H2Entity> saveAll(@RequestBody List<H2Entity> entities) {
		System.out.println("H2 new entities: " + entities);
		return h2Service.saveAll(entities);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Integer id) {
		h2Service.delete(id);
		return "Employee Delete Successfuly";
	}

	@PutMapping("/{id}/{designation}")
	public ResponseEntity<H2Entity> update(@PathVariable Integer id, @PathVariable String designation) {
		System.out.println("Designation: " + designation);
		H2Entity entity = h2Service.findById(id).orElse(null);
		if(entity==null) {
			return ResponseEntity.notFound().build();
		} else {
			entity.setDesignation(designation);
			h2Service.save(entity);
			return ResponseEntity.ok(entity);
		}
	}
}
