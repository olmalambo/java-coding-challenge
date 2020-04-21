package com.mooveit.cars.repositories;
import org.springframework.data.repository.CrudRepository;

import com.mooveit.cars.domain.Wheels;

public interface WheelsRepository<P> extends CrudRepository<Wheels,Long> {

}
