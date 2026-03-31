package aerovigil;

import java.util.*;

class InvalidFlightException extends Exception {
    public InvalidFlightException(String message) {
        super(message);
    }
}

class FlightOp {

    public boolean validateFlightNumber(String flightNumber)
            throws InvalidFlightException {

        // Must be FL-XXXX where XXXX is between 1000 and 9999
        if (!flightNumber.matches("FL-[1-9][0-9]{3}")) {
            throw new InvalidFlightException(
                    "The flight number " + flightNumber + " is invalid");
        }
        return true;
    }

    public boolean validateFlightName(String flightName)
            throws InvalidFlightException {

        List<String> flights = Arrays.asList(
                "SpiceJet", "Vistara", "IndiGo", "Air Arabia");

        if (!flights.contains(flightName)) {
            throw new InvalidFlightException(
                    "The flight name " + flightName + " is invalid");
        }
        return true;
    }

    public boolean validatePassengerCount(int passengerCount,
                                          String flightName)
            throws InvalidFlightException {

        int capacity = 0;

        switch (flightName) {
            case "SpiceJet": capacity = 396; break;
            case "Vistara": capacity = 615; break;
            case "IndiGo": capacity = 230; break;
            case "Air Arabia": capacity = 130; break;
        }

        if (passengerCount <= 0 || passengerCount > capacity) {
            throw new InvalidFlightException(
                    "The passenger count " + passengerCount +
                            " is invalid for " + flightName);
        }

        return true;
    }

    public double calculateFuelToFillTank(String flightName,
                                          double currentFuelLevel)
            throws InvalidFlightException {

        double capacity = 0;

        switch (flightName) {
            case "SpiceJet": capacity = 200000; break;
            case "Vistara": capacity = 300000; break;
            case "IndiGo": capacity = 250000; break;
            case "Air Arabia": capacity = 150000; break;
        }

        if (currentFuelLevel < 0 || currentFuelLevel > capacity) {
            throw new InvalidFlightException(
                    "Invalid fuel level for " + flightName);
        }

        return capacity - currentFuelLevel;
    }
}

public class FlightUtil {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        FlightOp flightOp = new FlightOp();

        System.out.println("Enter flight details");

        String input = sc.nextLine();
        String[] parts = input.split(":");

        try {
            String flightNumber = parts[0];
            String flightName = parts[1];
            int passengerCount = Integer.parseInt(parts[2]);
            double currentFuelLevel = Double.parseDouble(parts[3]);

            flightOp.validateFlightNumber(flightNumber);
            flightOp.validateFlightName(flightName);
            flightOp.validatePassengerCount(passengerCount, flightName);

            double fuelRequired =
                    flightOp.calculateFuelToFillTank(
                            flightName, currentFuelLevel);

            System.out.println(
                    "Fuel required to fill the tank: "
                            + fuelRequired + " liters");

        } catch (InvalidFlightException e) {
            System.out.println(e.getMessage());
        }
    }
}