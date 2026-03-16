package parkingmanagement;
import java.util.*;
public class ParkingManager {
	private Map<String, ParkingFloor> floors = new LinkedHashMap<>();
	private Map<String, List<Vehicle>> floorVehicles = new LinkedHashMap<>();
	public void addFloor(ParkingFloor floor) throws ParkingException {
		if(floors.containsKey(floor.getFloorId())) {
			throw new ParkingException("Floor "+floor.getFloorId()+" already exists");
			
		}
		floors.put(floor.getFloorId(), floor);
		floorVehicles.put(floor.getFloorId(), new ArrayList<>());
		System.out.println("Floor "+ floor.getFloorId()+" added successfully");
	}
	public void parkVehicle(String floorId, Vehicle vehicle) throws ParkingException {
		if (!floors.containsKey(floorId)) {
            throw new ParkingException("Floor " + floorId + " not found");
        }

        ParkingFloor floor = floors.get(floorId);
        List<Vehicle> vehiclesOnFloor = floorVehicles.get(floorId);
        if (vehiclesOnFloor.size() >= floor.getMaxCapacity()) {
            throw new ParkingException("Floor " + floorId + " is full");
        }
        // Check if vehicleId already parked anywhere
        for (List<Vehicle> list : floorVehicles.values()) {
            for (Vehicle v : list) {
                if (v.getVehicleId().equals(vehicle.getVehicleId())) {
                    throw new ParkingException("Vehicle " + vehicle.getVehicleId() + " already parked");
                }
            }
        }
        vehiclesOnFloor.add(vehicle);
        System.out.println("Vehicle " + vehicle.getVehicleId() + " parked on floor " + floorId);
	}
	  public double removeVehicle(String vehicleId) throws ParkingException {
	        for (Map.Entry<String, List<Vehicle>> entry : floorVehicles.entrySet()) {
	            String floorId = entry.getKey();
	            List<Vehicle> list = entry.getValue();

	            for (Vehicle v : list) {
	                if (v.getVehicleId().equals(vehicleId)) {
	                    double fee = floors.get(floorId).calculateParkingFee(v);
	                    list.remove(v);
	                    System.out.println("Vehicle " + vehicleId + " removed. Fee: Rs." + fee);
	                    return fee;
	                }
	            }
	        }
	        throw new ParkingException("Vehicle " + vehicleId + " not found");
	    }
	   public List<Vehicle> getVehiclesByFloor(String floorId) {
	        return floorVehicles.getOrDefault(floorId, new ArrayList<>());
	    }

	    public Vehicle getTopBillVehicle() {
	        Vehicle topVehicle = null;
	        double topFee = -1;

	        for (Map.Entry<String, List<Vehicle>> entry : floorVehicles.entrySet()) {
	            ParkingFloor floor = floors.get(entry.getKey());
	            for (Vehicle v : entry.getValue()) {
	                double fee = floor.calculateParkingFee(v);
	                if (fee > topFee) {
	                    topFee = fee;
	                    topVehicle = v;
	                }
	            }
	        }

	        return topVehicle;
	    }
	    public double getFeeForVehicle(String vehicleId) {
	        for (Map.Entry<String, List<Vehicle>> entry : floorVehicles.entrySet()) {
	            for (Vehicle v : entry.getValue()) {
	                if (v.getVehicleId().equals(vehicleId)) {
	                    return floors.get(entry.getKey()).calculateParkingFee(v);
	                }
	            }
	        }
	        return 0;
	    }
}
