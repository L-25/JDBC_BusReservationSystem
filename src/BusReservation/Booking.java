package BusReservation;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Booking {
    int busNo;
    String Name;
    Date  date;

    Booking()  {
        Scanner sc=new Scanner(System.in);
        System.out.print("Enter the Bus No :");
        busNo=sc.nextInt();
        System.out.print("Enter the passanger Name : ");
        Name=sc.next();
        System.out.print("Enter date of journey (dd-mm-yyy): ");
        String dateInput=sc.next();
        SimpleDateFormat dateFormat= new SimpleDateFormat("dd-mm-yyy");
        try {
            date=dateFormat.parse(dateInput);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
    }
    public boolean isAvailable() throws SQLException{
       BusDAO busDAO=new BusDAO();
       int capacity=busDAO.getCapacity(busNo);

       BookingDAO bookingDAO=new BookingDAO();
       int booked=bookingDAO.getBookedCount(busNo,date);
        return capacity>booked;
    }

}
