package AirlineManagementSystem;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private String Tel;
    private String email;
    private double salary;

    public Employee(int id, String firstName, String lastName, String tel, String email, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        Tel = tel;
        this.email = email;
        this.salary = salary;
    }
    public Employee() {}

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public void print() {
        System.out.println("id"+getId());
        System.out.println("Name" +getFirstName()+" "+getLastName());
        System.out.println("Contact" +getTel());
        System.out.println("Email"+getEmail());
        System.out.println("Salary"+getSalary());
    }
}
