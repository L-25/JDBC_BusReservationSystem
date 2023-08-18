package BusReservation;

import javax.sql.ConnectionEvent;
import java.sql.*;

public class BusDAO {
   public  void displayBusInfo() throws SQLException {
       String query="select * from bus";
       Connection con=DBconnection.getConnection();
       Statement st= con.createStatement();
       ResultSet rs=st.executeQuery(query);

       while(rs.next()){
           System.out.println("BusNo : "+rs.getInt(1)+"| Ac : "+rs.getString(2)+"| Capacity : "+rs.getInt(3)+"| From :"+rs.getString(4)+"| To : "+rs.getString(5));
       }
       System.out.println("\n--------------------------------------------------------------------------\n");
       con.close();
   }

   public int getCapacity(int busNo) throws SQLException{
       String query="select capacity from bus where busNo="+busNo;
       Connection con=DBconnection.getConnection();
       Statement st= con.createStatement();
       ResultSet rs=st.executeQuery(query);
       rs.next();
       return rs.getInt(1);
   }

}
