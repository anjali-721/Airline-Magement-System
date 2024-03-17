package AirlineManagementSystem;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class PassengerController {


    public static void AddPassenger(Database db , Scanner sc ) throws SQLException {
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
        int id ;
        ArrayList<Passenger> passengers = getAllPassengers(db);

        if (passengers.size() != 0) {
            id = passengers.get(passengers.size() - 1).getId() + 1;

        } else
            id = 0;

        passenger.setId(id);
        String insert = "INSERT INTO   `passengers`(`id`,`firstName`,`lastName`,`Tel`" +
                "`email`) VALUES(`" + passenger.getId() + "`,`" + passenger.getFirstName() + "`,`" + passenger.getLastName() + "`," +
                "`" + passenger.getTel() + "`,`" + passenger.getEmail() + "`);";
        db.getStatement().execute(insert);
        System.out.println("Passenger added succesfully!");
    }
    public static void EditPassenger(Database db, Scanner sc) throws SQLException {


        System.out.println("Enter Passenger id ");
        int id = sc.nextInt();
        Passenger passenger;
        if (id == -1) {
            passenger = findPassenger(db, sc);
        } else {
            String get = "SELECT * From `passengers` WHERE `id` = " + id + ";";
            ResultSet rs = db.getStatement().executeQuery(get);
            passenger = new Passenger();
            while (rs.next()) {
                rs.next();
                Passenger p = new Passenger();
                p.setId(Integer.parseInt(rs.getNString("id")));
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setTel(rs.getString("Tel"));
                p.setEmail(rs.getString("email"));

            }


            System.out.println("ENTER first name:" + "Press -1 to keep unchanged");
            String firstname = sc.next();
            if (firstname.equals("-1")) firstname = passenger.getFirstName();


            System.out.println("ENTER last name:" +
                    "Press -1 to keep unchanged");
            String lastname = sc.next();
            if (lastname.equals("-1")) lastname = passenger.getLastName();


            System.out.println("ENTER contact number:" +
                    "Press -1 to keep unchanged");
            String tel = sc.next();
            if (tel.equals("-1")) tel = passenger.getTel();


            System.out.println("ENTER email:" +
                    "Press -1 to keep unchanged");
            String email = sc.next();
            if (email.equals("-1")) email = passenger.getEmail();

            passenger.setFirstName(firstname);
            passenger.setLastName(lastname);
            passenger.setTel(tel);
            passenger.setId(id);
            passenger.setEmail(email);

            String update = "UPDATE `passengers` SET `id`= " + passenger.getId() + ",`firstname = `" + passenger.getFirstName() + "`,`lastname`= `" + passenger.getLastName() + "`," +
                    "`tel`= `" + passenger.getTel() + "`,`email`=`" + passenger.getEmail() + "`);";

            db.getStatement().execute(update);
            System.out.println("Passenger edited successfully");

        }
    }
    public static Passenger findPassenger(Database db, Scanner sc) throws SQLException {
        System.out.println("Enter Passenger id");
        int id = sc.nextInt();
        String get = "SELECT * From `passengers` WHERE `id` = " + id + ";";
        ResultSet rs = db.getStatement().executeQuery(get);
        Passenger passenger = new Passenger();
        while(rs.next()) {
            rs.next();
            Passenger p = new Passenger();
            p.setId(Integer.parseInt(rs.getNString("id")));
            p.setFirstName(rs.getString("firstName"));
            p.setLastName(rs.getString("lastName"));
            p.setTel(rs.getString("Tel"));
            p.setEmail(rs.getString("email"));
            if(p.getId() == id);
            break;
        }
       passenger.print();
        return passenger;
    }
    public static void printAllPassengers(Database db) throws SQLException{

        ArrayList<Passenger> passengers = getAllPassengers(db);
        System.out.println("------------------------------------------");
        for (Passenger p : passengers){
            System.out.println("id"+p.getId());
            System.out.println("Name" +p.getFirstName()+" "+p.getLastName());
            System.out.println("Contact" +p.getTel());
            System.out.println("Email"+p.getEmail());

        }
    }

    public static void deletePassenger(Database db, Scanner sc) throws SQLException {
        System.out.println("Enter id");
        int id = sc.nextInt();
        Passenger passenger;
        if (id == -1) {
            passenger = findPassenger(db, sc);
        } else {
            String get = "SELECT * From `passengers` WHERE `id` = " + id + ";";
            ResultSet rs = db.getStatement().executeQuery(get);
            passenger = new Passenger();
            while (rs.next()) {
                rs.next();
                Passenger p = new Passenger();
                p.setId(Integer.parseInt(rs.getNString("id")));
                p.setFirstName(rs.getString("firstName"));
                p.setLastName(rs.getString("lastName"));
                p.setTel(rs.getString("Tel"));
                p.setEmail(rs.getString("email"));

            }
            String delete = "DELETE FROM `passengers` WHERE `id` = " + passenger.getId() + ";";
            db.getStatement().execute(delete);

            System.out.println("passenger deleted");
        }
    }

    public static ArrayList<Passenger> getAllPassengers(Database db ) throws SQLException {

        String get = "SELECT * FROM `passengers`";
        ResultSet rs = db.getStatement().executeQuery(get);
        ArrayList<Passenger> passengers = new ArrayList<>();

        while (rs.next()) {
            rs.next();
            Passenger p = new Passenger();
            p.setId(Integer.parseInt(rs.getNString("id")));
            p.setFirstName(rs.getString("firstName"));
            p.setLastName(rs.getString("lastName"));
            p.setTel(rs.getString("Tel"));
            p.setEmail(rs.getString("email"));
            passengers.add(p);
        }
        return passengers;
    }
    }



