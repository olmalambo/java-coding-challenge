package com.mooveit.cars.manager.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mooveit.cars.domain.Engines;
import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.manager.EnginesManager;
import com.mooveit.cars.repositories.EnginesRepository;
@Component
public class EnginesManagerImpl implements  EnginesManager  {
	@Autowired
	private EnginesRepository<Engines> enginesRepository;
	
	
	

	public EnginesRepository<Engines> getEnginesRepository() {
		return enginesRepository;
	}

	public void setEnginesRepository(EnginesRepository<Engines> enginesRepository) {
		this.enginesRepository = enginesRepository;
	}

	@Override
	@Transactional
	public void saveEngines(Engines engines) {
		// TODO Auto-generated method stub
		enginesRepository.save(engines);
	}

	@Override
	public Engines saveEngines(ModelsExtract model) {
		 Engines engine =new Engines();
		 engine.setPower(Integer.parseInt(model.getEnginePower()));
		 engine.setType(model.getEngineType());
		 saveEngines(engine);
		return  engine;
		
	}

}
