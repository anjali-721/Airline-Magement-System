package AirlineManagementSystem;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
    public static void AddNewEmployee(Database db, Scanner sc) throws SQLException {
        System.out.println("Enter First Name");
        String firstName = sc.next();
        System.out.println("Enter Last Name");
        String lastName = sc.next();
        System.out.println("Enter contact number");
        String tel = sc.next();
        System.out.println("Enter email");
        String email = sc.next();
        System.out.println("Enter salary");
        double salary = sc.nextDouble();

        Employee emp = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setTel(tel);
        emp.setEmail(email);
        emp.setSalary(salary);
        int id;
        ArrayList<Employee> employees = getAllEmployees(db);

        if (employees.size() != 0) {
            id = employees.get(employees.size() - 1).getId() + 1;

        } else {
            id = 0;
            emp.setId(id);
            String insert = "INSERT INTO   `passengers`(`id`,`firstName`,`lastName`,`Tel`" +
                    "`email`,`salary`) VALUES(`" + emp.getId() + "`,`" + emp.getFirstName() + "`,`" + emp.getLastName() + "`," +
                    "`" + emp.getTel() + "`,`" + emp.getEmail() + "`,`"+emp.getSalary()+"`);";
            db.getStatement().execute(insert);
            System.out.println("Passenger added succesfully!");
        }
    }

    public static void deleteEmployee(Database db, Scanner sc) throws SQLException {
        System.out.println("Enter Employee  id");
        int id = sc.nextInt();
        Employee employee;
        if (id == -1) {
            employee = findEmployee(db, sc);
        } else {
            String get = "SELECT * From `employees` WHERE `id` = " + id + ";";
            ResultSet rs = db.getStatement().executeQuery(get);
             employee = new Employee();
            while (rs.next()) {
                rs.next();
                Employee e  = new Employee();
                e.setId(Integer.parseInt(rs.getNString("id")));
                e.setFirstName(rs.getString("firstName"));
                e.setLastName(rs.getString("lastName"));
                e.setTel(rs.getString("Tel"));
                e.setEmail(rs.getString("email"));
                e.setSalary(Double.parseDouble(rs.getString("salary")));

            }
            String delete = "DELETE FROM `employees` WHERE `id` = " + employee.getId() + ";";
            db.getStatement().execute(delete);

            System.out.println("passenger deleted");
        }
    }

    public static Employee findEmployee(Database db, Scanner sc) throws SQLException {
        System.out.println("Enter Employee id");
        int id = sc.nextInt();
        String get = "SELECT * From `employeess` WHERE `id` = " + id + ";";
        ResultSet rs = db.getStatement().executeQuery(get);
        Employee employee = new Employee();
        while(rs.next()) {
            rs.next();
            Employee e = new Employee();
            e.setId(Integer.parseInt(rs.getNString("id")));
            e.setFirstName(rs.getString("firstName"));
            e.setLastName(rs.getString("lastName"));
            e.setTel(rs.getString("Tel"));
            e.setEmail(rs.getString("email"));
            e.setSalary(Double.parseDouble(rs.getString("salary")));
            if(e.getId() == id);
            break;
        }
       employee.print();
        return employee;
    }

    private static  ArrayList<Employee> getAllEmployees(Database db) throws SQLException {


        String get = "SELECT * FROM `emloyees`";
        ResultSet rs = db.getStatement().executeQuery(get);
        ArrayList<Employee> employees = new ArrayList<>();

        while (rs.next()) {
            rs.next();
            Employee e = new Employee();
            e.setId(Integer.parseInt(rs.getNString("id")));
            e.setFirstName(rs.getString("firstName"));
            e.setLastName(rs.getString("lastName"));
            e.setTel(rs.getString("tel"));
            e.setEmail(rs.getString("email"));
            e.setSalary(Double.parseDouble(rs.getString("salary")));
            employees.add(e);
        }
        return employees;
    }

    public static void printAllPassenges(Database db, Scanner sc) throws SQLException {
        ArrayList<Employee> employees = getAllEmployees(db);
        System.out.println("------------------------------------------");
        for (Employee p : employees){
            System.out.println("id"+p.getId());
            System.out.println("Name" +p.getFirstName()+" "+p.getLastName());
            System.out.println("Contact" +p.getTel());
            System.out.println("Email"+p.getEmail());
            System.out.println("Salary"+p.getSalary());

        }
    }

    public static void editEmployee(Database db, Scanner sc) throws SQLException{

        System.out.println("Enter Employee id \n -1 to show employee details");
        int id = sc.nextInt();
        Employee employee;
        if (id == -1) {
            employee = findEmployee(db, sc);
        } else {
            String get = "SELECT * From `passengers` WHERE `id` = " + id + ";";
            ResultSet rs = db.getStatement().executeQuery(get);
            employee = new Employee();
            while (rs.next()) {
                rs.next();
                Employee e = new Employee();
                e.setId(Integer.parseInt(rs.getNString("id")));
                e.setFirstName(rs.getString("firstName"));
                e.setLastName(rs.getString("lastName"));
                e.setTel(rs.getString("Tel"));
                e.setEmail(rs.getString("email"));
                e.setSalary(Double.parseDouble(rs.getString("salary")));

            }


            System.out.println("ENTER first name:" + "Press -1 to keep unchanged");
            String firstname = sc.next();
            if (firstname.equals("-1")) firstname = employee.getFirstName();


            System.out.println("ENTER last name:" +
                    "Press -1 to keep unchanged");
            String lastname = sc.next();
            if (lastname.equals("-1")) lastname = employee.getLastName();


            System.out.println("ENTER contact number:" +
                    "Press -1 to keep unchanged");
            String tel = sc.next();
            if (tel.equals("-1")) tel = employee.getTel();


            System.out.println("ENTER email:" +
                    "Press -1 to keep unchanged");
            String email = sc.next();
            if (email.equals("-1")) email = employee.getEmail();

            System.out.println("Enter salary Press -1 to keep unchanged");
            Double salary = sc.nextDouble();
            if(salary==-1) salary= employee.getSalary();

            employee.setFirstName(firstname);
            employee.setLastName(lastname);
            employee.setTel(tel);
            employee.setId(id);
            employee.setEmail(email);
            employee.setSalary(salary);

            String update = "UPDATE `passengers` SET `id`= " + employee.getId() + ",`firstname = `" + employee.getFirstName() + "`,`lastname`= `" + employee.getLastName() + "`," +
                    "`tel`= `" + employee.getTel() + "`,`email`=`" + employee.getEmail() + "`.`salary`=`"+employee.getSalary()+"`);";

            db.getStatement().execute(update);
            System.out.println("Passenger edited successfully");

        }
    }
}