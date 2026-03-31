package grc_codebase;

public class VolumeOfEarth {
	public static void main(String[] args) {
		int radius = 6378;
		double VolumeOfEarthKM = (4/3)*3.14*radius*radius*radius;
		double VolumeOfEarthMiles = VolumeOfEarthKM * 0.621371;
		
		System.out.print("The Volume of earth  in the cubic KM is "+VolumeOfEarthKM +" The Volume of earth is in the Cubic Miles "+VolumeOfEarthMiles );
	}
}
