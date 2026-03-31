package dao;

import db.DBConnection;
import java.sql.*;

public class AppointmentDAO {
	private static boolean doctorExists(int doctorId) throws Exception {
	    Connection con = DBConnection.getConnection();
	    PreparedStatement ps =
	        con.prepareStatement("SELECT doctor_id FROM doctors WHERE doctor_id=?");
	    ps.setInt(1, doctorId);
	    return ps.executeQuery().next();
	}


    public static void book(int patientId, int doctorId,
                            String date, String time) throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO appointments(patient_id,doctor_id,appointment_date,appointment_time,status) " +
            "VALUES(?,?,?,?, 'SCHEDULED')");
        ps.setInt(1, patientId);
        ps.setInt(2, doctorId);
        ps.setDate(3, Date.valueOf(date));
        ps.setTime(4, Time.valueOf(time));
        ps.executeUpdate();
    }

    public static void cancel(int appointmentId) throws Exception {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE appointments SET status='CANCELLED' WHERE appointment_id=?");
            ps.setInt(1, appointmentId);
            ps.executeUpdate();

            PreparedStatement audit = con.prepareStatement(
                "INSERT INTO appointment_audit(appointment_id,action) VALUES(?,?)");
            audit.setInt(1, appointmentId);
            audit.setString(2, "CANCELLED");
            audit.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
        }
    }
}
