package controlFlows;

import java.util.Scanner;
class GradesAsPerMarks{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter marks in Physics(out of 100) : ");
		int physics = input.nextInt();
		System.out.print("Enter marks in Chemistry(out of 100) : ");
		int chemistry = input.nextInt();
		System.out.print("Enter marks in Maths(out of 100) : ");
		int math = input.nextInt();
		double percentage = ((physics + chemistry + math)/300.0)*100;
		if(percentage >= 80){
			System.out.println( percentage + "% Percentage have A grade and (level 4, above agency-normalized standards)");
		}
		else if(percentage >= 70 && percentage <=79){
			System.out.println( percentage + "% Percentage have B grade and (level 3, at agency-normalized standards)");
		}
		else if(percentage >= 60 && percentage <= 69){
			System.out.println( percentage + "% Percentage have C grade and (level 2, but approaching agency-normalized standards)");
		}
		else if(percentage >= 50 && percentage <=59){
			System.out.println( percentage + "% Percentage have D grade and (level 1, well below agency-normalized standards)");
		}
		else if(percentage >= 40 && percentage <=49){
			System.out.println( percentage + "% Percentage have E grade and (level 1, too below agency-normalized standards)");
		}
		else{
			System.out.println(percentage + "% Percentage have R grade and (Remedial standards)");
		}
	}
}