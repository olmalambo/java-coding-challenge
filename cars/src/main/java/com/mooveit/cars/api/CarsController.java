package com.mooveit.cars.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.mooveit.cars.domain.Model;
import com.mooveit.cars.domain.ModelsExtract;
import com.mooveit.cars.manager.ModelsManager;

@RestController
public class CarsController {
	
	@Autowired
	private ModelsManager modelsManager;
	
	
	
	
	
	
	
	public ModelsManager getModelsManager() {
		return modelsManager;
	}





	public void setModelsManager(ModelsManager modelsManager) {
		this.modelsManager = modelsManager;
	}



	//Get all the car specifications by brand
	@GetMapping("/getCarByBrand")
	public @ResponseBody List<ModelsExtract> getCarByBrand(@RequestParam String brand) {
		
		
		return modelsManager.findByName(brand);
		
	}
	
	//Get all the car specifications by brand
		@GetMapping("/getCarById")
		public @ResponseBody ModelsExtract getCarById(@RequestParam Long id) {
			
			
			return modelsManager.findById(id);
			
		}

}
