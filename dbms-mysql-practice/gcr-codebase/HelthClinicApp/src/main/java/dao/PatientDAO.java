package dao;

import db.DBConnection;
import model.Patient;
import java.sql.*;

public class PatientDAO {

    public static boolean exists(String phone, String email) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT patient_id FROM patients WHERE phone=? OR email=?");
        ps.setString(1, phone);
        ps.setString(2, email);
        return ps.executeQuery().next();
    }

    public static void register(Patient p) throws Exception {
        if (exists(p.phone, p.email)) {
            System.out.println("Patient already exists");
            return;
        }
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO patients(name,dob,phone,email,address,blood_group) VALUES(?,?,?,?,?,?)",
            Statement.RETURN_GENERATED_KEYS);
        ps.setString(1, p.name);
        ps.setDate(2, Date.valueOf(p.dob));
        ps.setString(3, p.phone);
        ps.setString(4, p.email);
        ps.setString(5, p.address);
        ps.setString(6, p.bloodGroup);
        ps.executeUpdate();

        ResultSet rs = ps.getGeneratedKeys();
        if (rs.next())
            System.out.println("Registered Patient ID: " + rs.getInt(1));
    }

    public static void update(int id, String address, String blood)
            throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "UPDATE patients SET address=?, blood_group=? WHERE patient_id=?");
        ps.setString(1, address);
        ps.setString(2, blood);
        ps.setInt(3, id);
        ps.executeUpdate();
    }

    public static void searchByName(String name) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT * FROM patients WHERE name LIKE ?");
        ps.setString(1, "%" + name + "%");
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            System.out.println(rs.getInt(1) + " " + rs.getString(2));
    }

    public static void visitHistory(int patientId) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "SELECT a.visit_date,a.doctor_name,v.diagnosis " +
            "FROM appointments a JOIN visits v ON a.appointment_id=v.appointment_id " +
            "WHERE a.patient_id=? ORDER BY a.visit_date");
        ps.setInt(1, patientId);
        ResultSet rs = ps.executeQuery();
        while (rs.next())
            System.out.println(rs.getDate(1)+" "+rs.getString(2)+" "+rs.getString(3));
    }
}
