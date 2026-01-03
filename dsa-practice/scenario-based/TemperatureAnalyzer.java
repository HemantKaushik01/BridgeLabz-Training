package secnario_Based;
import java.util.*;

public class TemperatureAnalyzer {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		//float temp[][] = new float[7][24];
		 float[][] temperature = {
		            // Day 1 (Monday)
		            {18.5f, 18.0f, 17.8f, 17.5f, 17.2f, 17.0f,
		             18.0f, 19.5f, 21.0f, 23.0f, 25.5f, 27.0f,
		             28.5f, 29.0f, 29.5f, 28.0f, 26.5f, 25.0f,
		             23.5f, 22.5f, 21.5f, 20.5f, 19.5f, 18.8f},

		            // Day 2 (Tuesday)
		            {19.0f, 18.5f, 18.2f, 17.9f, 17.6f, 17.4f,
		             18.4f, 20.0f, 22.0f, 24.5f, 26.0f, 27.8f,
		             29.2f, 30.0f, 30.5f, 29.0f, 27.5f, 26.0f,
		             24.0f, 23.0f, 22.0f, 21.0f, 20.0f, 19.3f},

		            // Day 3 (Wednesday)
		            {18.8f, 18.3f, 18.0f, 17.7f, 17.4f, 17.2f,
		             18.2f, 19.8f, 21.8f, 24.0f, 26.0f, 27.5f,
		             28.8f, 29.5f, 30.0f, 28.7f, 27.0f, 25.5f,
		             23.8f, 22.8f, 21.8f, 20.8f, 19.8f, 19.0f},

		            // Day 4 (Thursday)
		            {19.2f, 18.7f, 18.4f, 18.0f, 17.8f, 17.6f,
		             18.6f, 20.5f, 22.5f, 25.0f, 27.0f, 28.5f,
		             30.0f, 30.8f, 31.0f, 29.5f, 28.0f, 26.5f,
		             24.8f, 23.5f, 22.5f, 21.5f, 20.5f, 19.8f},

		            // Day 5 (Friday)
		            {20.0f, 19.5f, 19.2f, 18.8f, 18.5f, 18.3f,
		             19.5f, 21.5f, 23.5f, 26.0f, 28.0f, 29.5f,
		             31.0f, 31.8f, 32.0f, 30.5f, 29.0f, 27.5f,
		             25.5f, 24.5f, 23.5f, 22.5f, 21.5f, 20.8f},

		            // Day 6 (Saturday)
		            {21.0f, 20.5f, 20.2f, 19.8f, 19.5f, 19.3f,
		             20.5f, 22.5f, 24.5f, 27.0f, 29.0f, 30.5f,
		             32.0f, 32.8f, 33.0f, 31.5f, 30.0f, 28.5f,
		             26.5f, 25.5f, 24.5f, 23.5f, 22.5f, 21.8f},

		            // Day 7 (Sunday)
		            {20.5f, 20.0f, 19.7f, 19.3f, 19.0f, 18.8f,
		             19.8f, 21.8f, 23.8f, 26.5f, 28.5f, 30.0f,
		             31.5f, 32.2f, 32.5f, 31.0f, 29.5f, 28.0f,
		             26.0f, 25.0f, 24.0f, 23.0f, 22.0f, 21.3f}
		        };
		 TemperatureAnalyzer obj  = new TemperatureAnalyzer();
		 float average[] = obj.averageTemp(temperature);
		 System.out.println("The Average of per day temptrature: ");
		 System.out.print(Arrays.toString(average));

	}
	public float[] averageTemp(float temperature[][]) {
		float average[] = new float[7];
		
		for(int i=0;i<temperature.length;i++) {
			float sum =0.0f;
			for(int j=0;j<temperature[0].length;j++) {
				sum+=temperature[i][j];
			}
			sum/=24.0;
			average[i]=sum;
		}
		float hottestDay=0.0f;
		int hot=-1;
		float coldestDay=100.0f;
		int cold =-1;
		for(int i=0;i<7;i++) {
			if(hottestDay<average[i]) {
				hottestDay= average[i];
				hot=i+1;
			}
			if(coldestDay>average[i]) {
				coldestDay= average[i];
				cold=i+1;
			}
		}
		System.out.println("Hottest Day "+ (hot+1) + " temprature is: "+hottestDay+"\n");
		System.out.println("Coldest Day "+ (cold+1) + " temprature is: "+coldestDay+"\n");

		return average;
	}
	

}
