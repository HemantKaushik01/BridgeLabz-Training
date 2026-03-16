package parkingmanagement;

public class StandardFloor extends ParkingFloor {
	public StandardFloor(String floorId, String floorName, int maxCapacity) {
		super(floorId, floorName, maxCapacity);
	}
	public  double calculateParkingFee(Vehicle vehicle) {
		String vehicleType= vehicle.getVehicleType();
		switch(vehicleType) {
		case "Car":
			return (double) vehicle.getHoursParked()*30;
		case "Bike":
			return (double) vehicle.getHoursParked()*10;
		case "Truck":
			return (double) vehicle.getHoursParked()*60;
		default:
			return 0.0;
		}
	}
	public  String getFloorType() {
		return "Standard";
	}
}
