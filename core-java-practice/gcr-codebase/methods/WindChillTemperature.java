package methods;

import java.util.Scanner;

public class WindChillTemperature {
	public double calculateWindChill(double temperature, double windSpeed) {
		double windChill = 35.74 + 0.6215 * temperature + (0.4275 * temperature - 35.75) * (Math.pow(windSpeed, 0.16));
		return windChill;
	}

	public static void main(String[] args) {
		WindChillTemperature obj = new WindChillTemperature();
		Scanner input = new Scanner(System.in);
		System.out.print("Enter the temperature : ");
		double temperature = input.nextDouble();
		System.out.print("Enter the Wind speed : ");
		double windSpeed = input.nextDouble();
		double windChill = obj.calculateWindChill(temperature, windSpeed);
		System.out.println("Given temperature is " + temperature + " and wind speed is " + windSpeed
				+ " and wind chill temperature will be " + windChill);

	}
}