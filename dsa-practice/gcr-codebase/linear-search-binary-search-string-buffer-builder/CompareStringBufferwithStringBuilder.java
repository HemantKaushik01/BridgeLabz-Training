
public class CompareStringBufferwithStringBuilder {
		public static void main(String[] args) {
			String arr[] = {"Anuj", "is","not", "a","Student","of","GLA","University"};
			StringBuffer str1 =new StringBuffer();
			 long startTime1 = System.nanoTime();
			for(int i=0;i<arr.length;i++) {
				
				str1.append(arr[i]);
				 if (i < arr.length - 1) { 
		                str1.append(" ");
		            }
			}
		    long endTime1 = System.nanoTime();
		    long durationInNanosBuffer = endTime1 - startTime1;
		    
			//System.out.print(str);
		    
		    StringBuilder str2 =new StringBuilder();
			 long startTime2 = System.nanoTime();
			for(int i=0;i<arr.length;i++) {
				
				str2.append(arr[i]);
				 if (i < arr.length - 1) { 
		                str2.append(" ");
		            }
			}
		    long endTime2 = System.nanoTime();
		    long durationInNanosBuilder = endTime2 - startTime2;
		    
		  System.out.println(durationInNanosBuffer + " Buffer Time");
		  System.out.println(durationInNanosBuilder +" Builder Time");
			
			
			
		}
}
