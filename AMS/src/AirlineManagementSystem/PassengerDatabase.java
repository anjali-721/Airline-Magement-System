package AirlineManagementSystem;

import java.sql.*;
import java.util.ArrayList;

public class PassengerDatabase {

    private static String url = "jdbc:mysql://localhost/ams";
    private static String user = "root";
    private static String password = "anjali";
    private Connection connection;
    private  Statement statement;

    public PassengerDatabase() throws SQLException {
        connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }

    public void AddPassenger(Passenger p) throws SQLException {
        String insert = "INSERT INTO   `passengers`(`id`,`firstName`,`lastName`,`Tel`" +
                "`email`) VALUES(`" + p.getId() + "`,`" + p.getFirstName() + "`,`" + p.getLastName() + "`," +
                "`" + p.getTel() + "`,`" + p.getEmail() + "`);";
        statement.execute(insert);

    }

    public Passenger getPassenger(int id) throws SQLException {
        String get = "SELECT * From `passengers` WHERE `id` = " + id + ";";
        ResultSet rs = statement.executeQuery(get);
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
        return passenger;
    }
    public void editPassenger(Passenger p) throws SQLException {
        String update = "UPDATE `passengers` SET `id`= "+ p.getId() +",`firstname = `"+ p.getFirstName() +"`,`lastname`= `"+p.getLastName()+"`," +
                "`tel`= `"+ p.getTel() +"`,`email`=`" + p.getEmail() +"`);" ;
        statement.execute(update);
    }

    public ArrayList<Passenger> getAllPassengers(int id) throws SQLException {

        String get = "SELECT * From `passengers`;";
        ResultSet rs = statement.executeQuery(get);
        ArrayList<Passenger> passengers = new ArrayList<>();

        while (rs.next()) {
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
    public void deletePassenger(Passenger p) throws SQLException {
        String delete = "DELETE FROM `passengers` WHERE `id` = "+p.getId()+";";
        statement.execute(delete);

    }


}