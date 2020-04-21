package com.mooveit.cars.manager;

import java.util.List;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.domain.ModelsExtract;

public interface ModelsManager {

	public void SaveModels(Model model);
	public List<ModelsExtract> findByName(String name);
	public ModelsExtract findById(Long id);
}
