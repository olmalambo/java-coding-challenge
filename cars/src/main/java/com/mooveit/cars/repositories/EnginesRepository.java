package com.mooveit.cars.repositories;
import org.springframework.data.repository.CrudRepository;

import com.mooveit.cars.domain.Engines;
public interface EnginesRepository<P> extends CrudRepository<Engines,Long> {

}
