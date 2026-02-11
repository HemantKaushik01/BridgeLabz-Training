package com.cooltrack;


import java.util.LinkedHashSet;
import java.util.List;
import java.util.OptionalDouble;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class DataCenterUtil {
	private Set<DataCenter> dataCenterSet = new LinkedHashSet<>();
	public void addDataCenter(DataCenter dataCenter) {
		dataCenterSet.add(dataCenter);
	}
	public DataCenter getDataCenterById(String dataCenterId) {
		return dataCenterSet.stream()
		.filter(dataCenter ->dataCenter.getDataCenterId().equals(dataCenterId))
		.findFirst()
		.orElse(null);
	
	}
	public List<DataCenter> getDataCentersWithMaximumCoolingPowerUsage(){
		double maxCoolingPower = dataCenterSet.stream()
								 .mapToDouble(DataCenter:: getCoolingPowerUsage)
								 .max()
								 .orElse(0.0);
		
		return dataCenterSet.stream()
			   .filter(e -> e.getCoolingPowerUsage()==maxCoolingPower)
			   .collect(Collectors.toList());
			   
		
	}
	public void display(DataCenter dataCenter) {
		System.out.println(dataCenter.getDataCenterId()+"|"
				+ dataCenter.getLocation()+"|"
				+ dataCenter.getSupervisorName()+"|"
				+dataCenter.getCoolingPowerUsage());
		System.out.print("=================================");
	}
}
