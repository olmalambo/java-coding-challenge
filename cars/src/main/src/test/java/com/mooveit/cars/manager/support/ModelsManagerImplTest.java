package com.mooveit.cars.manager.support;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.repositories.ModelRepository;

public class ModelsManagerImplTest {
	@Mock
	private ModelRepository<Model> modelRepository;
	
	 @InjectMocks
	 private ModelsManagerImpl modelsManagerImpl;

	@Before
	public void setUp() throws Exception {
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetModelRepository() {
		modelsManagerImpl.getModelRepository();
	}

	

	@Test
	public void testSaveModels() {
		Model model=new Model();
		modelsManagerImpl.SaveModels(model);
	}

	@Test
	public void testFindByName() {
		String name="";
		List<Model> lstModel=new ArrayList<>();
		when(modelRepository.findByName(name))
		.thenReturn(lstModel);
		modelsManagerImpl.findByName(name);
	}

	@Test
	public void testFindById() {
		Long id=new Long(0);
		Model modelObj =new Model();
		
		Optional<Model> model=Optional.of(modelObj);
		when(modelRepository.findById(id))
		.thenReturn(model);
		modelsManagerImpl.findById(id);
	}

}
