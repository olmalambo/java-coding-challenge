package com.mooveit.cars.manager;

import java.net.URISyntaxException;

import com.mooveit.cars.domain.FileProcess;

public interface FileProcessManager {
	
	public void saveFileProcess(FileProcess fileProcess);
	public FileProcess findFileProcessByFileName(String fileName);
	public void processedFile() throws URISyntaxException ;
}
