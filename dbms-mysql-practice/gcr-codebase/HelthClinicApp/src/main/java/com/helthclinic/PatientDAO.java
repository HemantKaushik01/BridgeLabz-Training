package com.helthclinic;

import java.sql.*;

public class PatientDAO {
	public static ResultSet getPatientByIdOrPhone(Connection con, int id, String phone) throws Exception {

	    String sql = "SELECT * FROM patients WHERE patient_id=? OR phone=?";
	    PreparedStatement ps = con.prepareStatement(sql);
	    ps.setInt(1, id);
	    ps.setString(2, phone);

	    return ps.executeQuery();
	}
	
	public static void updatePatient(int patientId, String address, String bloodGroup) throws Exception {

	    Connection con = DBConnection.getConnection();

	    String sql = "UPDATE patients SET address=?, blood_group=? WHERE patient_id=?";
	    PreparedStatement ps = con.prepareStatement(sql);

	    ps.setString(1, address);
	    ps.setString(2, bloodGroup);
	    ps.setInt(3, patientId);

	    int rows = ps.executeUpdate();

	    if (rows > 0)
	        System.out.println("Patient updated successfully");
	    else
	        System.out.println("Patient not found");
	}

	public static boolean isPatientExists(String phone, String email) throws Exception {
		Connection con = DBConnection.getConnection();
		String sql = "SELECT patient_id FROM patients WHERE phone=? OR email=?";
		PreparedStatement ps = con.prepareStatement(sql);
		ps.setString(1, phone);
		ps.setString(2, email);

		ResultSet rs = ps.executeQuery();
		return rs.next();

	}
	public static void registerPatient(Patient p) throws Exception{
		if(isPatientExists(p.getPhone(),p.getEmail())) {
			System.out.println("Patient already exists with same phone/email");
			
		}
		Connection con = DBConnection.getConnection();
		String sql ="INSERT INTO patients (name,dob,phone,email,address,blood_group)"+
		"VALUES (?,?,?,?,?,?)"; 
		
		PreparedStatement ps =con.prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
		ps.setString(1,p.getName());
		ps.setDate(2, Date.valueOf(p.getDob()));
        ps.setString(3, p.getPhone());
        ps.setString(4, p.getEmail());
        ps.setString(5, p.getAddress());
        ps.setString(6, p.getBloodGroup());
        
        ps.executeUpdate();
        ResultSet rs = ps.getGeneratedKeys();
        if(rs.next()) {
        	System.out.print("Patient registered successfully. Patient Id: "+rs.getInt(1));
        }
        
		
		
	}
}
