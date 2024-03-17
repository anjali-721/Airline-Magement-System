package AirlineManagementSystem;

import java.sql.SQLException;
import java.util.Scanner;


public class Main {


    public static void main(String[] args) throws SQLException {

        Database db = new Database();
        Scanner sc = new Scanner(System.in);
        int i = 0;
        do {
            System.out.println("Welcome" +
                    "\n 1.Add new passenger" +
                    "\n 2.Edit Passenger"+
                    "\n 3.Get passenger's details by id" +
                    "\n 4. Print all Passengers"+
                    "\n 5.Add a new employee"+
                    "\n 6.Add new Employee"+
                    "\n 7.Remove an Employee "+
                    "\n 8.Find an Employee"+
                    "\n 9.Edit Employee's details"+
                    "\n 10.Print all Employees"+
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
                    PassengerController.findPassenger (db,sc);
                    break;
                case 4 :
                    PassengerController.printAllPassengers(db);
                    break;
                case 5:
                    PassengerController.deletePassenger(db,sc);
                    break;
                case 6:
                    EmployeeController.AddNewEmployee(db,sc);
                    break;
                case 7:
                    EmployeeController.deleteEmployee(db,sc);
                    break;
                case 8:
                    EmployeeController.findEmployee(db,sc);
                    break;
                case 9:
                    EmployeeController.editEmployee(db,sc);
                case 10:
                    EmployeeController.printAllPassenges(db,sc);
                    break;
            }


        } while (i != 2);
    }
}
