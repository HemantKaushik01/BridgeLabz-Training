package io_Sprogramming_practice;
import java.io.*;
import java.util.*;

class Student {
    int id;
    String name;
    int age;
    String course;

    Student(int id, String name, int age, String course) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.course = course;
    }

    @Override
    public String toString() {
        return id + "," + name + "," + age + "," + course;
    }
}

public class CSVToObject {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader("students.csv"));
        List<Student> list = new ArrayList<>();

        br.readLine();

        String line;
        while ((line = br.readLine()) != null) {
            String[] data = line.split(",");

            Student s = new Student(
                    Integer.parseInt(data[0]),
                    data[1],
                    Integer.parseInt(data[2]),
                    data[3]
            );

            list.add(s);
        }

        br.close();

        for (Student s : list) {
            System.out.println(s);
        }
    }
}
