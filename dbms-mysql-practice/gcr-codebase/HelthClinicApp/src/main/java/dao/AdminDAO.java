package dao;

import db.DBConnection;
import java.sql.*;

public class AdminDAO {

    public static void addSpecialty(String name) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO specialties(specialty_name) VALUES(?)");
        ps.setString(1, name);
        ps.executeUpdate();
    }

    public static void viewAuditLogs() throws Exception {
        Connection con = DBConnection.getConnection();
        ResultSet rs = con.createStatement()
                .executeQuery("SELECT * FROM audit_log");
        while (rs.next())
            System.out.println(rs.getString(2)+" "+rs.getString(3));
    }
}
