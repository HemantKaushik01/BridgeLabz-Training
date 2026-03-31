package com.jsonprectice;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.*;

public class JsonArrayWriter {

    public static void main(String[] args) {

        try {
            ObjectMapper objectMapper = new ObjectMapper();

            User user1 = new User();
            user1.setId(101);
            user1.setName("abc");
            user1.setAge(23);
            user1.setEmail("abc@example.com");
            user1.setSkills(Arrays.asList("Java", "Spring"));

            User user2 = new User();
            user2.setId(102);
            user2.setName("efg");
            user2.setAge(30);
            user2.setEmail("efg@example.com");
            user2.setSkills(Arrays.asList("Python", "AWS"));
            List<User> users = new ArrayList<>();
            users.add(user1);
            users.add(user2);

            String jsonArray =
                    objectMapper.writerWithDefaultPrettyPrinter()
                                .writeValueAsString(users);

            System.out.println(jsonArray);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
