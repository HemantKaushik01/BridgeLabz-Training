package parkingmanagement;

public class PremiumFloor extends ParkingFloor {
	public PremiumFloor(String floorId, String floorName, int maxCapacity) {
		super(floorId, floorName, maxCapacity);
	}
	public  double calculateParkingFee(Vehicle vehicle) {
		String vehicleType= vehicle.getVehicleType();
		double fee=0;
		switch(vehicleType) {
		case "Car":
			fee= (double) vehicle.getHoursParked()*60;
		case "Bike":
			fee= (double) vehicle.getHoursParked()*20;
		case "Truck":
			fee= (double) vehicle.getHoursParked()*100;
	
		}
		if(vehicle.getHoursParked()>=5) {
			return fee -fee*0.15;
		}
		return fee;
	}
	public  String getFloorType() {
		return "Premium";
	}
}
