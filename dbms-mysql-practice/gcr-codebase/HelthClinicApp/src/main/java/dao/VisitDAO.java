package dao;

import db.DBConnection;
import java.sql.*;

public class VisitDAO {

    public static void recordVisit(int appointmentId,
                                   String diagnosis, String notes)
            throws Exception {

        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);

        try {
            PreparedStatement ps = con.prepareStatement(
                "INSERT INTO visits(appointment_id,diagnosis,notes,visit_date) VALUES(?,?,?,CURDATE())");
            ps.setInt(1, appointmentId);
            ps.setString(2, diagnosis);
            ps.setString(3, notes);
            ps.executeUpdate();

            PreparedStatement up = con.prepareStatement(
                "UPDATE appointments SET status='COMPLETED' WHERE appointment_id=?");
            up.setInt(1, appointmentId);
            up.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
        }
    }
}
