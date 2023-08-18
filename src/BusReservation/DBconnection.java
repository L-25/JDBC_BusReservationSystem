package BusReservation;
import java.sql.*;

public class DBconnection {
    private static final String url="jdbc:mysql://localhost:3306/BusReservationSystem";
    private static final String user="root";
    private static final  String password="2003";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url,user,password);
    }
}
