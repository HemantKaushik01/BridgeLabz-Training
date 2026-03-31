package io_programming_practice;
import java.io.*;
import java.util.*;

public class SearchRecord {
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the name of employee: ");
        String empName=sc.next();
    	String path = "src/main/java/io_Sprogramming_practice/employee.csv";

        BufferedReader br = new BufferedReader(new FileReader(path));
        String line;
        br.readLine();
        while((line=br.readLine())!=null){
            String[] data=line.split(",");
            if(data[1].equals(empName)){
                System.out.println("ID            " + data[0]);
               System.out.println("Name         " + data[1]);
               System.out.println("department   " + data[2]);
               System.out.println("Salary       " + data[3]);
            }
        }
        br.close();
    }
}