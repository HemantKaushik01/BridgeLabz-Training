package dao;

import db.DBConnection;
import java.sql.*;

public class BillingDAO {

    public static void generateBill(int visitId, double amount)
            throws Exception {
        Connection con = DBConnection.getConnection();
        PreparedStatement ps = con.prepareStatement(
            "INSERT INTO bills(visit_id,total_amount,created_date) VALUES(?,?,CURDATE())");
        ps.setInt(1, visitId);
        ps.setDouble(2, amount);
        ps.executeUpdate();
    }

    public static void recordPayment(int billId, String mode)
            throws Exception {
        Connection con = DBConnection.getConnection();
        con.setAutoCommit(false);
        try {
            PreparedStatement ps = con.prepareStatement(
                "UPDATE bills SET payment_status='PAID' WHERE bill_id=?");
            ps.setInt(1, billId);
            ps.executeUpdate();

            PreparedStatement tx = con.prepareStatement(
                "INSERT INTO payment_transactions(bill_id,payment_mode,payment_date) VALUES(?,?,CURDATE())");
            tx.setInt(1, billId);
            tx.setString(2, mode);
            tx.executeUpdate();

            con.commit();
        } catch (Exception e) {
            con.rollback();
        }
    }
}
