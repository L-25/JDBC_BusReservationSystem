package BusReservation;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class BusDemo {
    public static void main(String[] args) throws SQLException {
     BusDAO busDAO=new BusDAO();
     busDAO.displayBusInfo();

        Scanner sc=new Scanner(System.in);
        int userInput=1;
        while(userInput==1){
            System.out.println("Enter 1 for Booking 2 for Exits ");
            userInput=sc.nextInt();
            if(userInput==1){
                Booking booking=new Booking();
                if(booking.isAvailable()){
                    BookingDAO bookingDAO=new BookingDAO();
                    bookingDAO.addBooking(booking);
                    System.out.println("succesfully booked");
                }
                else{
                    System.out.println("please choose the other date or Bus number");
                }
            }
        }
    }

}
