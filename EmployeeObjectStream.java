import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;

public class EmployeeObjectStream {

    public static void main(String[] args) {

        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("vipin", "A", 70000));
        emps.add(new Employee("vipin", "B", 30000));
        emps.add(new Employee("2", "C", 30000));
        emps.add(new Employee("2", "C", 20000));
        emps.add(new Employee("3", "A", 60000));
        emps.add(new Employee("4", "A", 20000));

        // get employee salary more than 50000
        emps.stream().filter(salary -> salary.getSalary() > 50000).toList();

        // return employee map key = name and value = list of employees
        emps.stream().collect(Collectors.groupingBy(Employee::getName, LinkedHashMap::new, Collectors.toList())).entrySet().forEach(System.out::println);

        // find max salary employee
        emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(1).forEach(System.out::println);

        // sort employee based on salary
        emps.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);

//         or
//        Collections.sort(emps, new Comparator<Employee>() {
//            @Override
//            public int compare(Employee o1, Employee o2) {
//                return Double.compare(o2.getSalary(), o1.getSalary());
//            }
//        });

    }
}

class Employee {
    private String name;
    private String grade;
    private double salary;

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

    @Override
    public String toString() {
        return "Employee [name=" + name + ", grade=" + grade + ", salary=" + salary + "]";
    }
}