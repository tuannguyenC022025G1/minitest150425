package company;

public class FulltimeEmployee extends Employee {
    private double bonus, penalty, baseSalary;

    public FulltimeEmployee(String id, String name, int age, String phone, String email,
                            double bonus, double penalty, double baseSalary) {
        super(id, name, age, phone, email);
        this.bonus = bonus;
        this.penalty = penalty;
        this.baseSalary = baseSalary;
    }

    @Override
    public double calculateSalary() {
        return baseSalary + (bonus - penalty);
    }

    public double getSalary() {
        return calculateSalary();
    }

    @Override
    public String toString() {
        return name + " - Salary: " + calculateSalary();
    }
}
