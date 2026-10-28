import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("employees.csv"));
            reader.readLine(); // skip the header line

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split("\\|");

                int id = Integer.parseInt(parts[0]);
                String name = parts[1];
                double hoursWorked = Double.parseDouble(parts[2]);
                double payRate = Double.parseDouble(parts[3]);

                Employee employee = new Employee(id, name, hoursWorked, payRate);
                System.out.printf(Locale.US, "%d %-20s $%8.2f%n",
                        employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
            }

            reader.close();
        }
        catch (IOException e) {
            System.out.println("Could not read employees.csv");
            e.printStackTrace();
        }
    }
}

class Employee {
    private int employeeId;
    private String name;
    private double hoursWorked;
    private double payRate;

    public Employee(int employeeId, String name, double hoursWorked, double payRate) {
        this.employeeId = employeeId;
        this.name = name;
        this.hoursWorked = hoursWorked;
        this.payRate = payRate;
    }

    public int getEmployeeId() { return employeeId; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public double getHoursWorked() { return hoursWorked; }
    public void setHoursWorked(double hoursWorked) { this.hoursWorked = hoursWorked; }
    public double getPayRate() { return payRate; }
    public void setPayRate(double payRate) { this.payRate = payRate; }

    public double getGrossPay() {
        return hoursWorked * payRate;
    }
}