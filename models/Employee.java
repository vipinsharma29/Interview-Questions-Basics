package models;

import java.util.ArrayList;
import java.util.List;

public class Employee {
    private String name;
    private String grade;
    private double salary;

    public Employee(String name, double salary) {
        super();
        this.name = name;
        this.salary = salary;
    }

    public Employee(String name, String grade, double salary) {
        super();
        this.name = name;
        this.grade = grade;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public static List<Employee> getEmployeeList() {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("John", "B", 80000));
        employees.add(new Employee("Alice", "A", 35000));
        employees.add(new Employee("Bob", "C", 60000));
        employees.add(new Employee("Eve", "B", 45000));
        employees.add(new Employee("Charlie", "C", 68000));
        employees.add(new Employee("David", "A", 72000));
        employees.add(new Employee("Grace", "B", 47000));
        employees.add(new Employee("Helen", "C", 65000));
        employees.add(new Employee("Ivy", "A", 78000));
        return employees;
    }

    @Override
    public String toString() {
        return "Employee [name=" + name + ", grade=" + grade + ", salary=" + salary + "]";
    }
}
