package company;

import java.util.*;

public class Company {
    private List<Employee> employeeList = new ArrayList<>();

    public void addEmployee(Employee e) {
        employeeList.add(e);
    }

    public double averageSalary() {
        double total = 0;
        for (Employee e : employeeList) {
            total += e.calculateSalary();
        }
        return employeeList.size() > 0 ? total / employeeList.size() : 0;
    }

    public void listFulltimeBelowAverage() {
        double avg = averageSalary();
        System.out.println("\n Full-time employees with salary below average:");
        for (Employee e : employeeList) {
            if (e instanceof FulltimeEmployee && e.calculateSalary() < avg) {
                System.out.println(e.getName() + " - Salary: " + e.calculateSalary());
            }
        }
    }

    public double totalParttimeSalary() {
        double total = 0;
        for (Employee e : employeeList) {
            if (e instanceof ParttimeEmployee) {
                total += e.calculateSalary();
            }
        }
        return total;
    }

    public void sortFulltimeBySalary() {
        List<FulltimeEmployee> fulltimes = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e instanceof FulltimeEmployee) {
                fulltimes.add((FulltimeEmployee) e);
            }
        }
        fulltimes.sort(Comparator.comparingDouble(FulltimeEmployee::getSalary));
        System.out.println("\n📋 Full-time employees sorted by salary:");
        for (FulltimeEmployee e : fulltimes) {
            System.out.println(e);
        }
    }

    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        int choice;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Show average salary of all employees");
            System.out.println("2. List full-time employees with salary below average");
            System.out.println("3. Calculate total salary for part-time employees");
            System.out.println("4. Sort full-time employees by salary (ascending)");
            System.out.println("5. Exit");
            System.out.print("Choose an option (1-5): ");

            while (!scanner.hasNextInt()) {
                System.out.print("Invalid input! Please enter a number (1-5): ");
                scanner.next();
            }
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("\n Average salary: " + averageSalary());
                    break;
                case 2:
                    listFulltimeBelowAverage();
                    break;
                case 3:
                    System.out.println("\nTotal salary for part-time employees: " + totalParttimeSalary());
                    break;
                case 4:
                    sortFulltimeBySalary();
                    break;
                case 5:
                    System.out.println("\nExiting program...");
                    break;
                default:
                    System.out.println(" Invalid option. Try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        Company company = new Company();

        company.addEmployee(new FulltimeEmployee("FT01", "Barrack Obama", 30, "0123456789", "Oimeoi@example.com", 1000000, 500000, 5000000));
        company.addEmployee(new FulltimeEmployee("FT02", "Joe Biden", 32, "0987654321", "trungtam@example.com", 500000, 200000, 4500000));
        company.addEmployee(new ParttimeEmployee("PT01", "Donal TRump", 34, "0111222333", "cogaixinh@example.com", 40));
        company.addEmployee(new ParttimeEmployee("PT02", "George Bush", 36, "0444555666", "xinhlamluon@example.com", 35));

        company.showMenu();
    }
}
