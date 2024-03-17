package AirlineManagementSystem;

import java.sql.*;
import java.sql.DriverManager;


public class Database {

    private static String url = "jdbc:mysql://localhost/ams";
    private static String user = "root";
    private static String password = "anjali";
    private  Statement statement;


    public Database() throws SQLException {
        Connection connection = DriverManager.getConnection(url, user, password);
        statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
    }
    public Statement getStatement(){
        return statement;
    }








}