package com.jsonprectice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.io.File;
public class ReadJsonFile {

    public static void main(String[] args) {
        try {
            ObjectMapper objectMapper = new ObjectMapper();

           
            User user = objectMapper.readValue(new File("user.json"), User.class);

            System.out.println("User Id: " + user.getId());
            System.out.println("User Name: " + user.getName());
            System.out.println("User age: " + user.getAge());
            System.out.println("email: " + user.getEmail());
            System.out.println("Skills: " + user.getSkills());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
