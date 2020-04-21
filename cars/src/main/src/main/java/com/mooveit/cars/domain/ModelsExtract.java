package com.mooveit.cars.domain;

import java.util.List;

public class ModelsExtract {

	private String name;
	private String from;
	private String to;
	private String type;
	private String enginePower;
	private String engineType;
	private String WheelsSize;
	private String Wheelstype;
	private List<ModelsExtract> subModesls;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getFrom() {
		return from;
	}
	public void setFrom(String from) {
		this.from = from;
	}
	public String getTo() {
		return to;
	}
	public void setTo(String to) {
		this.to = to;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getEnginePower() {
		return enginePower;
	}
	public void setEnginePower(String enginePower) {
		this.enginePower = enginePower;
	}
	public String getEngineType() {
		return engineType;
	}
	public void setEngineType(String engineType) {
		this.engineType = engineType;
	}
	public String getWheelsSize() {
		return WheelsSize;
	}
	public void setWheelsSize(String wheelsSize) {
		WheelsSize = wheelsSize;
	}
	public String getWheelstype() {
		return Wheelstype;
	}
	public void setWheelstype(String wheelstype) {
		Wheelstype = wheelstype;
	}
	public List<ModelsExtract> getSubModesls() {
		return subModesls;
	}
	public void setSubModesls(List<ModelsExtract> subModesls) {
		this.subModesls = subModesls;
	}
	
	
	
	
}
