package practice2;

class Employee {
    protected String name;
    protected double baseSalary;

    public Employee(String name, double baseSalary) {
        this.name = name;
        this.baseSalary = baseSalary;
    }

    public double calculateTotalSalary() {
        return baseSalary;
    }
}

class Manager extends Employee {
    private double incentive;

    public Manager(String name, double baseSalary, double incentive) {
        super(name, baseSalary);
        this.incentive = incentive;
    }

    @Override
    public double calculateTotalSalary() {
        // Manager's total salary includes base salary and incentive
        return baseSalary + incentive;
    }
}

class Labour extends Employee {
    private double overtime;

    public Labour(String name, double baseSalary, double overtime) {
        super(name, baseSalary);
        this.overtime = overtime;
    }

    @Override
    public double calculateTotalSalary() {
        // Labour's total salary includes base salary and overtime
        return baseSalary + overtime;
    }
}

public class OrganizationHierarchy {
    public static void main(String[] args) {
        // Create instances of Employee, Manager, and Labour
        Employee employee = new Employee("John", 50000);
        Manager manager = new Manager("Alice", 70000, 20000);
        Labour labour = new Labour("Bob", 40000, 5000);

        // Calculate and display total salary for each employee using polymorphism
        System.out.println("Total Salary for Employee " + employee.name + ": " + employee.calculateTotalSalary());
        System.out.println("Total Salary for Manager " + manager.name + ": " + manager.calculateTotalSalary());
        System.out.println("Total Salary for Labour " + labour.name + ": " + labour.calculateTotalSalary());

        // Calculate and display total salary for all employees
        double totalOrganizationSalary = calculateTotalOrganizationSalary(employee, manager, labour);
        System.out.println("\nTotal Salary for the entire organization: " + totalOrganizationSalary);
    }

    // Calculate total salary for all employees in the organization
    private static double calculateTotalOrganizationSalary(Employee... employees) {
        double totalSalary = 0;
        for (Employee employee : employees) {
            totalSalary += employee.calculateTotalSalary();
        }
        return totalSalary;
    }
}

	


