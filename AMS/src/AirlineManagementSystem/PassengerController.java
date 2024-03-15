package AirlineManagementSystem;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerController {


    public static void AddPassenger(PassengerDatabase db , Scanner sc ) throws SQLException {
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter Last Name");
        String lastName = sc.next();
        System.out.println("Enter contact number");
        String tel = sc.next();
        System.out.println("Enter email");
        String email = sc.next();

        Passenger passenger = new Passenger();
        passenger.setFirstName(firstName);
        passenger.setLastName(lastName);
        passenger.setTel(tel);
        passenger.setEmail(email);
        int id = 0;
        ArrayList<Passenger> passengers = db.getAllPassengers(id);

        if (passengers.size() != 0) {
            id = passengers.get(passengers.size() - 1).getId() + 1;

        } else
            id = 0;

        passenger.setId(id);
        db.AddPassenger(passenger);
        System.out.println("Passenger added succesfully!");
    }
    public static void EditPassenger(PassengerDatabase db, Scanner sc) throws SQLException {



        System.out.println("Enter Passenger id ");
        int id = sc.nextInt();
        Passenger passenger= db.getPassenger(id);
        if (id == -1) id = passenger.getId();
        passenger.setId(id);


        System.out.println("ENTER first name:" + "Press -1 to keep unchanged");
        String firstname =  sc.next();
        if(firstname.equals("-1")) firstname = passenger.getFirstName();
        passenger.setFirstName(firstname);

        System.out.println("ENTER last name:" +
                "Press -1 to keep unchanged");
        String lastname =  sc.next();
        if(lastname.equals("-1")) lastname = passenger.getLastName();
        passenger.setLastName(lastname);

        System.out.println("ENTER contact number:" +
                "Press -1 to keep unchanged");
        String tel =  sc.next();
        if(tel.equals("-1")) tel = passenger.getTel();
        passenger.setTel(tel);

        System.out.println("ENTER email:" +
                "Press -1 to keep unchanged");
        String email  =  sc.next();
        if(email.equals("-1")) email = passenger.getEmail();
        passenger.setEmail(email);

        db.editPassenger(passenger);
        System.out.println("Passenger edited successfully");

    }
    public static void findPassengerByName(PassengerDatabase db, Scanner sc) throws SQLException {
        System.out.println("Enter Passenger id");
        int id = sc.nextInt();
        Passenger  p = db.getPassenger(id);
      p.print();
    }
    public static void printAllPassengers(PassengerDatabase db) throws SQLException{
        int id =0;
        ArrayList<Passenger> passengers = db.getAllPassengers(id);
        System.out.println("------------------------------------------");
        for (Passenger p : passengers){
            System.out.println("id"+p.getId());
            System.out.println("Name" +p.getFirstName()+" "+p.getLastName());
            System.out.println("Contact" +p.getTel());
            System.out.println("Email"+p.getEmail());

        }
    }

    public static void deletePassenger(PassengerDatabase db, Scanner sc) throws SQLException {
        System.out.println("Enter id");
        int id =sc.nextInt();
        Passenger passenger = db.getPassenger(id);
        db.deletePassenger(passenger);
        System.out.println("passenger deleted");
    }




}