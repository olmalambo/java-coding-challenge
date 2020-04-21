package com.mooveit.cars.repositories;
import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mooveit.cars.domain.FileProcess;
public interface FileProcessRepository<P> extends CrudRepository<FileProcess,Long> {

	List<FileProcess> findByFileName(String fileName);
}
