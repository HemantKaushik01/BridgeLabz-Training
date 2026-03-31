package io_programming_practice;
import java.io.*;
import java.util.*;

class Employee {
    String id;
    String name;
    String dept;
    double salary;

    Employee(String id, String name, String dept, double salary) {
        this.id = id;
        this.name = name;
        this.dept = dept;
        this.salary = salary;
    }
}

public class SortCSVBySalary {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("employees.csv"));
        List<Employee> list = new ArrayList<>();

        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");
            list.add(new Employee(
                    data[0],
                    data[1],
                    data[2],
                    Double.parseDouble(data[3])
            ));
        }
        br.close();

        list.sort((a, b) -> Double.compare(b.salary, a.salary));

        int limit = Math.min(5, list.size());
        for (int i = 0; i < limit; i++) {
            Employee e = list.get(i);
            System.out.println(e.id + "," + e.name + "," + e.dept + "," + e.salary);
        }
    }
}
