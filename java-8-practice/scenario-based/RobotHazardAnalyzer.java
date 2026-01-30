import java.util.Scanner;

class RobotSafetyException extends Exception{
	public RobotSafetyException(String massage) {
		super(massage);
	}
}

public class RobotHazardAnalyzer {
	public double calculateHazardRisk(double armPrecision, int workerDensity,String machineryState) throws RobotSafetyException  {
		if(armPrecision<0 || armPrecision>1) {
			throw new RobotSafetyException("Error: Arm precision must be 0.0-1.0");
		}
		if(workerDensity<1 || workerDensity>20) {
			throw new RobotSafetyException("Error: Worker density must be 1-20");
			
		}
		if(!machineryState.equals("Worn") && !machineryState.equals("Faulty") && machineryState.equals("Critical")) {
			throw new RobotSafetyException("Error: Unsupported machinery state");
		}
		double machineRiskFactor = 0;
		if(machineryState.equals("Worm")) {
			machineRiskFactor=1.3;
		}
		else if(machineryState.equals("Faulty")) {
			machineRiskFactor=2.0;
			
		}
		else {
			machineRiskFactor=3.0;
		}
		double hazardRisk=((1.0 - armPrecision) * 15.0) + (workerDensity * machineRiskFactor);
		return hazardRisk;
		
	}
	

	public static void main(String[] args) throws RobotSafetyException {
		Scanner sc = new Scanner(System.in);
		 RobotHazardAnalyzer rha = new  RobotHazardAnalyzer();
		System.out.print("Enter Arm Precision (0.0-1.0): ");
		double armPrecision = sc.nextDouble();
		System.out.print("Enter Worker Density(1-20): ");
		int workerDenstiy = sc.nextInt();
		System.out.print("Enter Machinery State (Worn/Faulty/Critical): ");
		String machineryState = sc.next();
		try {
			double score=rha.calculateHazardRisk(armPrecision, workerDenstiy, machineryState);
			System.out.print("Robot Hazard Risk Score: "+score);
		}
		catch(RobotSafetyException e) {
			System.out.print(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Invalid input");
		}

		
				
		
	}

}
