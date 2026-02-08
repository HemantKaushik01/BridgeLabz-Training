import java.sql.Connection;
import java.sql.DriverManager;

public class TestConnection {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String pass = "1473695";
        	

        try {
            Connection con = DriverManager.getConnection(url, user, pass);
            System.out.println("✅ Connected to MySQL from Eclipse!");
            con.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
