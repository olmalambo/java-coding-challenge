package com.mooveit.cars.manager;

import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.domain.Wheels;

public interface WheelsManager {

	public void saveWheels(Wheels wheels);
	
	public Wheels saveWheels(ModelsExtract model);
}
