package com.mooveit.cars.manager.support;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.net.URISyntaxException;

import org.junit.Before;
import org.junit.Test;

import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.mooveit.cars.domain.FileProcess;
import com.mooveit.cars.manager.EnginesManager;
import com.mooveit.cars.manager.ModelsManager;
import com.mooveit.cars.manager.WheelsManager;
import com.mooveit.cars.repositories.FileProcessRepository;

public class FileProcessManagerImplTest {
	@Mock
	private  FileProcessRepository<FileProcess> fileProcessRepository;
	@Mock
	private EnginesManager enginesManager;
	@Mock
	private WheelsManager wheelsManager;
	@Mock
	private ModelsManager modelsManager;
	@InjectMocks
	private FileProcessManagerImpl fileProcessManagerImpl;
	@Before
	public void setUp() throws Exception {
		
		 MockitoAnnotations.initMocks(this);
	}

	@Test
	public void testGetModelsManager() {
		fileProcessManagerImpl.getModelsManager();
	}



	@Test
	public void testGetWheelsManager() {
		fileProcessManagerImpl.getWheelsManager();
	}

	

	@Test
	public void testGetFileProcessRepository() {
		fileProcessManagerImpl.getFileProcessRepository();
	}


	@Test
	public void testGetEnginesManager() {
		fileProcessManagerImpl.getEnginesManager();
	}

	

	@Test
	public void testSaveFileProcess() {
		FileProcess fileProcess=new FileProcess();
		fileProcessManagerImpl.saveFileProcess(fileProcess);
	}

	@Test
	public void testFindFileProcessByFileName() {
		String filename="";
		when(fileProcessRepository.findByFileName(filename))
		.thenReturn(null);
		assertNull(fileProcessManagerImpl.findFileProcessByFileName(filename));
	}

	@Test
	public void testProcessedFile() {
		String filename="";
		when(fileProcessRepository.findByFileName(filename))
		.thenReturn(null);
		try {
			fileProcessManagerImpl.processedFile();
		} catch (URISyntaxException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	

}
