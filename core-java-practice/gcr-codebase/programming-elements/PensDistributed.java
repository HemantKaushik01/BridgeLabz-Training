package grc_codebase;

public class PensDistributed {

	public static void main(String[] args) {
		int pens = 14;
		int students = 3;
		// Calculate remaining pens and equalDivided
		int remainder=  pens%students;
		int equalDivided =  pens/students;
		
		System.out.print("The Pen Per Students is "+ equalDivided +" and the remaining pens not distributed is " + remainder);
		

	}

}
