package parkingmanagement;

public abstract class ParkingFloor {
	protected String floorId;
	protected String floorName;
	protected int maxCapacity;
	public String getFloorId() {
		return floorId;
	}
	public void setFloorId(String floorId) {
		this.floorId = floorId;
	}
	public String getFloorName() {
		return floorName;
	}
	public void setFloorName(String floorName) {
		this.floorName = floorName;
	}
	public int getMaxCapacity() {
		return maxCapacity;
	}
	public void setMaxCapacity(int maxCapacity) {
		this.maxCapacity = maxCapacity;
	}
	public ParkingFloor(String floorId,String floorName,int maxCapacity) {
		this.floorId=floorId;
		this.floorName=floorName;
		this.maxCapacity=maxCapacity;
	}
	public abstract double calculateParkingFee(Vehicle vehicle) ;
	public abstract String getFloorType();
	
}
