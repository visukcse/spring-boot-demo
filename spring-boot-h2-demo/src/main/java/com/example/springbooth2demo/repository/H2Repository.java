package com.example.springbooth2demo.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.springbooth2demo.entity.H2Entity;

@Repository
public interface H2Repository extends CrudRepository<H2Entity, Integer> {

}
