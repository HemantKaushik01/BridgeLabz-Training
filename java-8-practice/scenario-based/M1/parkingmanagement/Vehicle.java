package parkingmanagement;

public class Vehicle {
	private String vehicleId;
	private String vehicleType;
	private String ownerName;
	private int hoursParked;
	public Vehicle(String vehicleId, String vehicleType, String ownerName,int hoursParked) {
		this.vehicleId=vehicleId;
		this.vehicleType=vehicleType;
		this.ownerName=ownerName;
		this.hoursParked=hoursParked;
	}
	public String getVehicleId() {
		return vehicleId;
	}
	public String getVehicleType() {
		return vehicleType;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public int getHoursParked() {
		return hoursParked;
	}
	
	public void setVechicleId(String vehicleId) {
		this.vehicleId= vehicleId;
	}
	public void setVechicleType(String vehicleType) {
		this.vehicleType=vehicleType;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName=ownerName;
	}
	public void setHoursParked(int hoursParked) {
		this.hoursParked=hoursParked;
	}
	
	
	
}
