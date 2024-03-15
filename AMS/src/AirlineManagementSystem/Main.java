package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;

public class Main {


    public static void main(String[] args) throws SQLException {

        PassengerDatabase db = new PassengerDatabase();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        do {
            System.out.println("Welcome" +
                    "\n 1.Add new passenger" +
                    "\n 2.Edit Passenger"+
                    "\n 3.Get passenger's details by id" +
                    "\n 4. Print all Passengers"+
                    "\n 5.Add a new employee"+
                    "\n 4.quit");
            i = sc.nextInt();

            switch(i){
                case 1:
                    PassengerController.AddPassenger(db,sc);
                    break;
                case 2:
                    PassengerController.EditPassenger(db,sc);
                    break;
                case 3 :
                    PassengerController.findPassengerByName(db,sc);
                    break;
                case 4 :
                    PassengerController.printAllPassengers(db);
                    break;
                case 5:
                    PassengerController.deletePassenger(db,sc);

            }


        } while (i != 2);
    }
}
