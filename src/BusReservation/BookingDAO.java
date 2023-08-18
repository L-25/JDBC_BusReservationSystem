package BusReservation;
import java.util.Date;

import java.sql.*;


public class BookingDAO {
    public int getBookedCount(int busNo, Date date) throws SQLException {
        String query ="select count(p_name) from booking where bus_no=? and travel_date=?";
        Connection con=DBconnection.getConnection();
        PreparedStatement pst= con.prepareStatement(query);
        pst.setInt(1,busNo);
        java.sql.Date sqldate =new java.sql.Date(date.getTime());
        pst.setDate(2,sqldate);
        ResultSet rs= pst.executeQuery();
        rs.next();
        return rs.getInt(1);
    }

    public void addBooking(Booking booking) throws SQLException {
        String query ="insert into booking values(?,?,?)";
        Connection con=DBconnection.getConnection();
        PreparedStatement prs= con.prepareStatement(query);
        prs.setInt(1,booking.busNo);
        prs.setString(2,booking.Name);
        java.sql.Date sqldate=new java.sql.Date(booking.date.getTime());
        prs.setDate(3,sqldate);
        prs.executeUpdate();
    }
}
