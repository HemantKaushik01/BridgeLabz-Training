package io_Sprogramming_practice;
import java.io.*;
import java.util.*;

class Student {
    String id;
    String name;
    String age;
    String marks;
    String grade;

    Student(String id, String name, String age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }
}

public class MergeCSV {
    public static void main(String[] args) throws Exception {

        BufferedReader br1 = new BufferedReader(new FileReader("students1.csv"));
        BufferedReader br2 = new BufferedReader(new FileReader("students2.csv"));
        FileWriter writer = new FileWriter("merged_students.csv");

        Map<String, Student> map = new HashMap<>();

        br1.readLine();
        String line;
        while ((line = br1.readLine()) != null) {
            String[] data = line.split(",");
            map.put(data[0], new Student(data[0], data[1], data[2]));
        }
        br1.close();

        br2.readLine();
        while ((line = br2.readLine()) != null) {
            String[] data = line.split(",");
            Student s = map.get(data[0]);
            if (s != null) {
                s.marks = data[1];
                s.grade = data[2];
            }
        }
        br2.close();

        writer.write("ID,Name,Age,Marks,Grade\n");
        for (Student s : map.values()) {
            writer.write(
                s.id + "," + s.name + "," + s.age + "," + s.marks + "," + s.grade + "\n"
            );
        }

        writer.close();
    }
}
