package com.mooveit.cars.manager.support;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;

import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.util.Date;
import java.util.List;
import org.milyn.javabean.binding.xml.XMLBinding;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.xml.sax.SAXException;
import org.milyn.io.StreamUtils;
import com.mooveit.cars.domain.FileProcess;
import com.mooveit.cars.domain.Model;
import com.mooveit.cars.manager.EnginesManager;
import com.mooveit.cars.manager.FileProcessManager;
import com.mooveit.cars.manager.ModelsManager;
import com.mooveit.cars.manager.WheelsManager;
import com.mooveit.cars.repositories.FileProcessRepository;
import com.mooveit.cars.domain.Catalogue;
import com.mooveit.cars.domain.Engines;
import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.domain.Wheels;

import org.milyn.payload.StringSource;

@Component
public class FileProcessManagerImpl  implements FileProcessManager{
	
private final String filePath="ExtractModels.xml";
	@Autowired
	private  FileProcessRepository<FileProcess> fileProcessRepository;
	@Autowired
	private EnginesManager enginesManager;
	@Autowired
	private WheelsManager wheelsManager;
	
	@Autowired
	private ModelsManager modelsManager;
	
	public ModelsManager getModelsManager() {
		return modelsManager;
	}

	public void setModelsManager(ModelsManager modelsManager) {
		this.modelsManager = modelsManager;
	}

	public WheelsManager getWheelsManager() {
		return wheelsManager;
	}

	public void setWheelsManager(WheelsManager wheelsManager) {
		this.wheelsManager = wheelsManager;
	}

	public FileProcessRepository<FileProcess> getFileProcessRepository() {
		return fileProcessRepository;
	}

	public void setFileProcessRepository(FileProcessRepository<FileProcess> fileProcessRepository) {
		this.fileProcessRepository = fileProcessRepository;
	}

	public EnginesManager getEnginesManager() {
		return enginesManager;
	}

	public void setEnginesManager(EnginesManager enginesManager) {
		this.enginesManager = enginesManager;
	}

	@Override
	@Transactional
	public void saveFileProcess(FileProcess fileProcess) {
		// TODO Auto-generated method stub
		fileProcessRepository.save(fileProcess);
		
	}

	@Override
	@Transactional
	public FileProcess findFileProcessByFileName(String fileName) {
		// TODO Auto-generated method stub
		List<FileProcess> lstFileProcess=fileProcessRepository.findByFileName(fileName);
		return lstFileProcess != null ? !lstFileProcess.isEmpty()?lstFileProcess.get(0):null:null;
	}

	@Override
	public void processedFile() throws URISyntaxException {
				
		String fileName = "loadXml";
       // ClassLoader classLoader = new FileProcessManagerImpl().getClass().getClassLoader();
        
       
        File folder = new File(this.getClass().getClassLoader().getResource(fileName).toURI());
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isFile() && file.getName().contains(".xml")) {
            	  
				try {
					FileProcess fileProcess=findFileProcessByFileName(file.getName());
					if(fileProcess == null) {
						byte[]	fileData = Files.readAllBytes(file.toPath());
						procesingXmlToClass(fileData,file.getName());	
					}
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            	 
            	 
            }
        }
		
	}
	
	private String readInputSource(byte[] fileData)  {
        try {
            return StreamUtils.readStreamAsString(new ByteArrayInputStream(fileData));
        } catch (IOException e) {
            return "";
        }
    }
	
	public void procesingXmlToClass(byte[] fileData,String fileName) {
		
		 XMLBinding xmlBindingV1;
		try (InputStream inputStreamConfig = new FileInputStream(new File(this.getClass().getClassLoader().getResource(filePath).getFile()))) {
  		  xmlBindingV1 = new XMLBinding().add(inputStreamConfig);
            xmlBindingV1.intiailize();
           
            String inputSource = readInputSource(fileData);
            Catalogue catalogueValues = xmlBindingV1.fromXML(new StringSource(inputSource), Catalogue.class);
            saveAllData(catalogueValues,fileName);
  	} catch (IOException | SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
	}
	
	public void saveAllData(Catalogue dataCatalogue,String fileName) {
		 FileProcess  fileProcess =new FileProcess();
		 fileProcess.setCreationDate(new Date());
		 fileProcess.setFileName(fileName);
		 saveFileProcess(fileProcess);
		 
		 for(ModelsExtract model  : dataCatalogue.getModels()) {
			 saveModels(model);
				 
		 }
		 
		 
		
		
	}
	
	public void saveModels(ModelsExtract model) {
		
		Model minsert=new Model() ;
		Engines engine= enginesManager.saveEngines(model);
		Wheels wheels=wheelsManager.saveWheels(model);
		minsert.setEngines(engine);
		minsert.setWheels(wheels);
		
		minsert.setName(model.getName());
		minsert.setFrom(model.getFrom());
		minsert.setTo(model.getTo());
		
		minsert.setType(model.getType());
		modelsManager.SaveModels(minsert);
		
		for(ModelsExtract submodels:model.getSubModesls()) {
			
			Model subModelInsert=new Model() ;
			Engines engineSubModel= enginesManager.saveEngines(submodels);
			Wheels wheelsSubModel=wheelsManager.saveWheels(submodels);
			subModelInsert.setEngines(engineSubModel);
			subModelInsert.setWheels(wheelsSubModel);
			
			subModelInsert.setName(submodels.getName());
			subModelInsert.setFrom(submodels.getFrom());
			subModelInsert.setTo(submodels.getTo());
			subModelInsert.setParentModel(minsert);
			subModelInsert.setType(submodels.getType());
			modelsManager.SaveModels(subModelInsert);
			
		}
	}

}


