package com.mooveit.cars.manager.support;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.domain.Wheels;
import com.mooveit.cars.manager.WheelsManager;
import com.mooveit.cars.repositories.WheelsRepository;
@Component
public class WheelsManagerImpl implements WheelsManager {

	@Autowired
	private WheelsRepository<Wheels> wheelsRepository;
	
	
	
	
	public WheelsRepository<Wheels> getWheelsRepository() {
		return wheelsRepository;
	}


	public void setWheelsRepository(WheelsRepository<Wheels> wheelsRepository) {
		this.wheelsRepository = wheelsRepository;
	}


	@Override
	@Transactional
	public void saveWheels(Wheels wheels) {
		// TODO Auto-generated method stub
		wheelsRepository.save(wheels);
	}


	@Override
	public Wheels saveWheels(ModelsExtract model) {
		// TODO Auto-generated method stub
		
		Wheels wheels =new Wheels();
		wheels.setSize(model.getWheelsSize());
		wheels.setType(model.getWheelstype());
		saveWheels(wheels);
		
		return wheels;
	}

}
