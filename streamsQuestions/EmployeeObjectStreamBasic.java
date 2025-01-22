package streamsQuestions;

import models.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeObjectStreamBasic {

    public static void main(String[] args) {

        List<Employee> employees = Employee.getEmployeeList();

        System.out.println("1. Find employee salary more than 60000");
        employees.stream().filter(salary -> salary.getSalary() > 60000).toList()
                .forEach(System.out::println);
        System.out.println("--------");

        // return employee map key = name and value = list of employees
        System.out.println("2. Find list of employees for each grade");
        employees.stream().collect(Collectors.groupingBy(Employee::getGrade, LinkedHashMap::new, Collectors.toList())).entrySet().forEach(System.out::println);
        System.out.println("--------");

        System.out.println("3. Find max salary employee");
        employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).limit(1).forEach(System.out::println);
        System.out.println("--------");

        System.out.println("4. Sort employee based on salary");
        {
            employees.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).forEach(System.out::println);
        }
//        System.out.println("or");
//        {
//            Collections.sort(employees, new Comparator<Employee>() {
//                @Override
//                public int compare(Employee o1, Employee o2) {
//                    return Double.compare(o2.getSalary(), o1.getSalary());
//                }
//            });
//        }
        System.out.println("--------");

        System.out.println("5. Sort on name first and then on salary");
        employees.stream().sorted(Comparator.comparing(Employee::getName).thenComparing(Employee::getSalary)).forEach(System.out::println);
        System.out.println("--------");

    }
}