package company;

import java.util.*;

public class Company {
    private Employee[] employeeList;
    private int count;
    private int maxEmployee;

    public Company(int maxEmployee) {
        this.maxEmployee = maxEmployee;
        employeeList = new Employee[maxEmployee];
        count = 0;
    }

    public void addEmployee(Employee e) {
        if (count < maxEmployee) {
            employeeList[count] = e;
            count++;
        } else {
            System.out.println("Danh sách nhân viên đã đầy!");
        }
    }

    public double averageSalary() {
        if (count == 0) return 0;
        double total = 0;
        for (int i = 0; i < count; i++) {
            total += employeeList[i].calculateSalary();
        }
        return total / count;
    }

    public void listFulltimeBelowAverage() {
        double avg = averageSalary();
        System.out.println("\nFull-time employees with salary below average:");
        for (int i = 0; i < count; i++) {
            if (employeeList[i] instanceof FulltimeEmployee && employeeList[i].calculateSalary() < avg) {
                System.out.println(employeeList[i].getName() + " - Salary: " + employeeList[i].calculateSalary());
            }
        }
    }

    public double totalParttimeSalary() {
        double total = 0;
        for (int i = 0; i < count; i++) {
            if (employeeList[i] instanceof ParttimeEmployee) {
                total += employeeList[i].calculateSalary();
            }
        }
        return total;
    }

    public void sortFulltimeBySalary() {
        FulltimeEmployee[] fulltimes = new FulltimeEmployee[count];
        int ftCount = 0;
        for (int i = 0; i < count; i++) {
            if (employeeList[i] instanceof FulltimeEmployee) {
                fulltimes[ftCount++] = (FulltimeEmployee) employeeList[i];
            }
        }

        Arrays.sort(fulltimes, 0, ftCount, Comparator.comparingDouble(FulltimeEmployee::getSalary));

        System.out.println("\n📋 Full-time employees sorted by salary:");
        for (int i = 0; i < ftCount; i++) {
            System.out.println(fulltimes[i]);
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
                    System.out.println("\nAverage salary: " + averageSalary());
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
                    System.out.println("Invalid option. Try again.");
            }
        } while (choice != 5);
    }

    public static void main(String[] args) {
        Company company = new Company(10);

        company.addEmployee(new FulltimeEmployee("FT01", "Barrack Obama", 30, "0123456789", "Oimeoi@example.com", 1000000, 500000, 5000000));
        company.addEmployee(new FulltimeEmployee("FT02", "Joe Biden", 32, "0987654321", "trungtam@example.com", 500000, 200000, 4500000));
        company.addEmployee(new ParttimeEmployee("PT01", "Donal Trump", 34, "0111222333", "cogaixinh@example.com", 40));
        company.addEmployee(new ParttimeEmployee("PT02", "George Bush", 36, "0444555666", "xinhlamluon@example.com", 35));

        company.showMenu();
    }
}
