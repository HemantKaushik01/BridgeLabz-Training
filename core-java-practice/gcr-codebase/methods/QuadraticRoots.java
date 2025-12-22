package methods;

import java.util.Scanner;
public class QuadraticRoots{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.print("Enter  number a : ");
		int a= input.nextInt();
		System.out.print("Enter  number b : ");
		int b= input.nextInt();
		System.out.print("Enter  number c : ");
		int c= input.nextInt();
		
		QuadraticRoots obj = new QuadraticRoots();
		double roots[] = obj.rootFun(a,b,c);
		System.out.print(roots[0] + " , " + roots[1]);
	}
	public double[] rootFun(int a, int b, int c){
		double roots[] =new double[2];
		double  delta  = Math.pow(b,2) + 4*a*c;
		if(delta>0){
			roots[0]= (-b-Math.sqrt(delta))/(2*a);
			roots[1]= (-b+Math.sqrt(delta))/(2*a);
		}
		else if(delta ==0){
			roots[0] = -b/(2*a);
		}
		return roots;
			
			
		
	}
}
