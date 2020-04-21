package com.mooveit.cars.manager;

import com.mooveit.cars.domain.Engines;
import com.mooveit.cars.domain.ModelsExtract;

public interface EnginesManager {
	
	public void saveEngines(Engines engines);
	public Engines saveEngines(ModelsExtract model);

}
