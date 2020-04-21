package com.mooveit.cars.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.mooveit.cars.domain.Model;

public interface ModelRepository<P> extends CrudRepository<Model,Long> {
	//@Query("SELECT u.name,u.from,u.to,u.type,u.engines,u.wheels FROM Model u WHERE u.name = ?1")
	public List<Model> findByName(String name);
}
