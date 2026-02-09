package db;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    private static final String URL =
            "jdbc:mysql://localhost:3306/health_clinic";
    private static final String USER = "root";
    private static final String PASSWORD = "1473695";

    public static Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        return DriverManager.getConnection(URL, USER, PASSWORD);
    }
}

//String url = "jdbc:mysql://localhost:3306/jdbc_demo";
//String user = "root";
//String pass = "1473695";