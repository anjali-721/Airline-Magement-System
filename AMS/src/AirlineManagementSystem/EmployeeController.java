package AirlineManagementSystem;

import java.util.ArrayList;
import java.util.Scanner;

public class EmployeeController {
    public static void AddNewEmployee(EmployeeDatabase edb, Scanner sc){
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

        Employee emp  = new Employee();
        emp.setFirstName(firstName);
        emp.setLastName(lastName);
        emp.setTel(tel);
        emp.setEmail(email);
        emp.setSalary(salary);

        ArrayList<Employee> employee = new ArrayList<>();
        emp
    }
}
