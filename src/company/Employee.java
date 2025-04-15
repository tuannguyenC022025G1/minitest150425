package company;

public abstract class Employee {
    protected String id, name, phone, email;
    protected int age;

    public Employee(String id, String name, int age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public abstract double calculateSalary();

    public String getName() {
        return name;
    }
}
