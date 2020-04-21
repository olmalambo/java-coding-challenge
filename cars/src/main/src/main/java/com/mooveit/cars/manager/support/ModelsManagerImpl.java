package com.mooveit.cars.manager.support;


import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.manager.ModelsManager;
import com.mooveit.cars.repositories.ModelRepository;
@Component
public class ModelsManagerImpl implements ModelsManager{
	@Autowired
	private ModelRepository<Model> modelRepository;
	
	public ModelRepository<Model> getModelRepository() {
		return modelRepository;
	}

	public void setModelRepository(ModelRepository<Model> modelRepository) {
		this.modelRepository = modelRepository;
	}




	@Override
	@Transactional
	public void SaveModels(Model model) {
		// TODO Auto-generated method stub
		modelRepository.save(model);
	}

	@Override
	public List<ModelsExtract> findByName(String name) {
		List<Model> lstmodelData= modelRepository.findByName(name);
		List<ModelsExtract> lstRt=new ArrayList<>();
		for(Model modelData:lstmodelData) {
		// TODO Auto-generated method stub
				ModelsExtract modelReturn=new ModelsExtract();
				List<ModelsExtract> lstChild=new ArrayList<>();
				
				modelReturn.setTo(modelData.getTo());
				modelReturn.setFrom(modelData.getFrom());
				modelReturn.setName(modelData.getName());
				modelReturn.setType(modelData.getType());
				if(modelData.getEngines() != null) {
					modelReturn.setEnginePower( modelData.getEngines().getPower()+"" );
					modelReturn.setEngineType(modelData.getEngines().getType());
				}
				if(modelData.getWheels() != null) {
					modelReturn.setWheelsSize(modelData.getWheels().getSize());
					modelReturn.setWheelstype(modelData.getWheels().getType());
					
				}
				
				for(Model model: modelData.getSubModels()) {
					ModelsExtract modelDataChild=new ModelsExtract();
					modelDataChild.setTo(model.getTo());
					modelDataChild.setFrom(model.getFrom());
					modelDataChild.setName(model.getName());
					modelDataChild.setType(model.getType());
					if(model.getEngines() != null) {
						modelDataChild.setEnginePower( model.getEngines().getPower()+"" );
						modelDataChild.setEngineType(model.getEngines().getType());
					}
					if(model.getWheels() != null) {
						modelDataChild.setWheelsSize(model.getWheels().getSize());
						modelDataChild.setWheelstype(model.getWheels().getType());
						
					}
					
					lstChild.add(modelDataChild);
				}
				modelReturn.setSubModesls(lstChild);
				lstRt.add(modelReturn);
		}
		return lstRt;
	}

	@Override
	public ModelsExtract findById(Long id) {
		// TODO Auto-generated method stub
		ModelsExtract modelReturn=new ModelsExtract();
		List<ModelsExtract> lstChild=new ArrayList<>();
		Model modelData=modelRepository.findById(id).get();
		modelReturn.setTo(modelData.getTo());
		modelReturn.setFrom(modelData.getFrom());
		modelReturn.setName(modelData.getName());
		modelReturn.setType(modelData.getType());
		if(modelData.getEngines() != null) {
			modelReturn.setEnginePower( modelData.getEngines().getPower()+"" );
			modelReturn.setEngineType(modelData.getEngines().getType());
		}
		if(modelData.getWheels() != null) {
			modelReturn.setWheelsSize(modelData.getWheels().getSize());
			modelReturn.setWheelstype(modelData.getWheels().getType());
			
		}
		if(modelData.getSubModels() != null) {
		for(Model model: modelData.getSubModels()) {
			ModelsExtract modelDataChild=new ModelsExtract();
			modelDataChild.setTo(model.getTo());
			modelDataChild.setFrom(model.getFrom());
			modelDataChild.setName(model.getName());
			modelDataChild.setType(model.getType());
			if(model.getEngines() != null) {
				modelDataChild.setEnginePower( model.getEngines().getPower()+"" );
				modelDataChild.setEngineType(model.getEngines().getType());
			}
			if(model.getWheels() != null) {
				modelDataChild.setWheelsSize(model.getWheels().getSize());
				modelDataChild.setWheelstype(model.getWheels().getType());
				
			}
			
			lstChild.add(modelDataChild);
		}
		modelReturn.setSubModesls(lstChild);
		
	}
		return modelReturn;
	}

}
