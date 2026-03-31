package com.cooltrack;
import java.util.*;
public class UserInterface {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		DataCenterUtil dataUtil = new DataCenterUtil();
		boolean flag= true;
		while(true) {
			System.out.println("\n 1: For adding data center"
					+ "\n 2: For get Data Center by id"
					+ "\n 3:For get Data Centers wtih maximumCoolingPower"
					+ "\n 4: Exit");
		
			switch(sc.nextInt()) {
			case 1:
				System.out.print("Enter the number of data centers: ");
				int n= sc.nextInt();
				sc.nextLine();
				
				System.out.println("Format: dataCenterId:location:supervisorName:coolingPowerUsage");
				for(int i=0;i<n;i++) {
					String str[] = sc.nextLine().split(":");
					DataCenter dataCenter = new DataCenter(str[0],str[1],str[2],Double.parseDouble(str[3]));
					dataUtil.addDataCenter(dataCenter);
				}
				break;
				
			case 2:
				System.out.print("Enter the Data Center Id: ");
				String dataCenterId = sc.next();
				DataCenter dataCenter = dataUtil.getDataCenterById(dataCenterId);
				dataUtil.display(dataCenter);
				break;
			case 3:
				System.out.println("The maximum Cooling Power Usage are...");
				List<DataCenter> dataCenterlist = dataUtil.getDataCentersWithMaximumCoolingPowerUsage();
				for(DataCenter center: dataCenterlist ) {
					dataUtil.display(center);
				}
				break;
			case 4:
				flag= false;
				break;
			}
			if(flag==false) {
				break;
			}
			
		}
		
	}
}
