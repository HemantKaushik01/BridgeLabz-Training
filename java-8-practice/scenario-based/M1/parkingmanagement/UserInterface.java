package parkingmanagement;

import java.util.*;

public class UserInterface {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ParkingManager manager = new ParkingManager();

        int n = Integer.parseInt(sc.nextLine().trim());

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] parts = line.split(" ");
            String command = parts[0];

            try {
                switch (command) {

                    case "ADD_FLOOR": {
                        // ADD_FLOOR floorId floorName type maxCapacity
                        String floorId = parts[1];
                        String floorName = parts[2];
                        String type = parts[3];
                        int maxCapacity = Integer.parseInt(parts[4]);

                        ParkingFloor floor;
                        if (type.equalsIgnoreCase("Standard")) {
                            floor = new StandardFloor(floorId, floorName, maxCapacity);
                        } else {
                            floor = new PremiumFloor(floorId, floorName, maxCapacity);
                        }
                        manager.addFloor(floor);
                        break;
                    }

                    case "PARK": {
                        // PARK floorId vehicleId vehicleType ownerName hoursParked
                        String floorId = parts[1];
                        String vehicleId = parts[2];
                        String vehicleType = parts[3];
                        String ownerName = parts[4];
                        int hoursParked = Integer.parseInt(parts[5]);

                        Vehicle vehicle = new Vehicle(vehicleId, vehicleType, ownerName, hoursParked);
                        manager.parkVehicle(floorId, vehicle);
                        break;
                    }

                    case "REMOVE": {
                        // REMOVE vehicleId
                        String vehicleId = parts[1];
                        manager.removeVehicle(vehicleId);
                        break;
                    }

                    case "FLOOR_STATUS": {
                        // FLOOR_STATUS floorId
                        String floorId = parts[1];
                        List<Vehicle> vehicles = manager.getVehiclesByFloor(floorId);

                        if (vehicles.isEmpty()) {
                            System.out.println("No vehicles on floor " + floorId);
                        } else {
                            for (Vehicle v : vehicles) {
                                System.out.println(v.getVehicleId() + " | " + v.getOwnerName() + " | " + v.getVehicleType());
                            }
                        }
                        break;
                    }

                    case "TOP_BILL": {
                        // TOP_BILL
                        Vehicle top = manager.getTopBillVehicle();

                        if (top == null) {
                            System.out.println("No vehicles parked");
                        } else {
                            double fee = manager.getFeeForVehicle(top.getVehicleId());
                            System.out.println(top.getVehicleId() + " | " + top.getOwnerName() + " | Rs." + fee);
                        }
                        break;
                    }

                    default:
                        System.out.println("Unknown command: " + command);
                }

            } catch (ParkingException e) {
                System.out.println(e.getMessage());
            }
        }

        sc.close();
    }
}