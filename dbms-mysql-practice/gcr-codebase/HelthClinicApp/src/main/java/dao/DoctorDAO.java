package dao;

import db.DBConnection;
import java.sql.*;

public class DoctorDAO {

    public static void addDoctor(String name, String contact,
                                 double fee, int specialtyId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO doctors(name,contact,consultation_fee,specialty_id) VALUES(?,?,?,?)");
        ps.setString(1, name);
        ps.setString(2, contact);
        ps.setDouble(3, fee);
        ps.setInt(4, specialtyId);
        ps.executeUpdate();
    }

    public static void deactivateDoctor(int doctorId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE doctors SET is_active=false WHERE doctor_id=?");
        ps.setInt(1, doctorId);
        ps.executeUpdate();
    }
}
