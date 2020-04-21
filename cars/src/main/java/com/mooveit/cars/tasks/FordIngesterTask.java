package com.mooveit.cars.tasks;

import lombok.extern.slf4j.Slf4j;

import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import com.mooveit.cars.manager.FileProcessManager;

@Slf4j
@Service
public class FordIngesterTask {
	@Autowired
	private FileProcessManager fileProcessManager;
	
	
	

  public FileProcessManager getFileProcessManager() {
		return fileProcessManager;
	}




	public void setFileProcessManager(FileProcessManager fileProcessManager) {
		this.fileProcessManager = fileProcessManager;
	}




@Scheduled(cron = "${cars.ford.ingester.runCron}")
	 // @Scheduled(cron = "0 * * ? * *")
  public void ingestFile() {
	try {
		fileProcessManager.processedFile();
	} catch (URISyntaxException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
  }
}
