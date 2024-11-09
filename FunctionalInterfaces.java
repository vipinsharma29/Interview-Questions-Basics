import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Predicate;

interface LengthInterface {
    int getLength(String s);
}

interface CustomCalculate {
    int run(int a, int b);
}

interface CalculateSample {
    int run(int sampleSize, int samplePrice, int units);
}

public class FunctionalInterfaces {

    public static void main(String[] args) {
        List<Employee> emps = new ArrayList<>();
        emps.add(new Employee("vipin", "A", 70000));
        emps.add(new Employee("rio", "B", 30000));
        emps.add(new Employee("vipul", "B", 40000));

        List<Integer> listValues = new ArrayList<Integer>();
        listValues.add(2);
        listValues.add(1);
        listValues.add(3);

        List<Integer> listValues2 = new ArrayList<Integer>();
        listValues2.add(4);
        listValues2.add(5);
        listValues2.add(6);

        consumers(listValues, listValues2);
        predicate(emps);
        customCalculate();
        calculateSample();

    }

    private static void calculateSample() {

        System.out.println("7. CalculateSample Functional Interface lambda with 3 parameters");
        CalculateSample add = (int a, int samplePrice, int units) -> {
            return (a * samplePrice) + units * 10;
        };
        System.out.println(add.run(12, 12, 10));
        System.out.println("--------");

        List<Employee> customCheckEmp = new ArrayList<>();
        customCheckEmp.add(new Employee("vipin", "A", 70000));
        customCheckEmp.add(new Employee("vipin", "B", 30000));
        customCheckEmp.add(new Employee("2", "C", 30000));
        customCheckEmp.add(new Employee("2", "C", 20000));
        customCheckEmp.add(new Employee("3", "A", 60000));
        customCheckEmp.add(new Employee("4", "A", 20000));

        System.out.println("8. CalculateSample Functional Interface lambda with 3 parameters on custom object");
        CalculateSample employeeAdd = (int a, int samplePrice, int units) -> {
            int result = 0;
            int total = (int) customCheckEmp.stream().map(Employee::getSalary).mapToDouble(Double::doubleValue).sum();
            result = total + samplePrice + (units * a);
            return result;
        };
        System.out.println(employeeAdd.run(12, 12, 10));
        System.out.println("--------");
    }

    private static void customCalculate() {
        System.out.println("5. Custom Functional Interface lambda with 2 parameters multiply");
        CustomCalculate sampleSize = (a, c) -> {
            return a * c * 2;
        };
        System.out.println(sampleSize.run(2, 4));
        System.out.println("--------");


        System.out.println("6. Custom Functional Interface lambda with 2 parameters addition");
        CustomCalculate d = (a, c) -> a + c + 2;
        System.out.println(d.run(2, 4));
        System.out.println("--------");
    }

    private static void predicate(List<Employee> emps) {

        System.out.println("3. Predicate Functional Interface");
        Predicate<String> isMale = p -> p.equals("A");
        System.out.println("predicate " + isMale.test(emps.get(0).getGrade()));
        System.out.println("--------");

        System.out.println("4. BiPredicate Functional Interface");
        BiPredicate<String, String> isRio = (name, grade) -> name.equals("rio") && grade.equals("B");
        System.out.println("bi-predicate " + isRio.test(emps.get(1).getName(), emps.get(1).getGrade()));

        BiPredicate<String, String> isVipul = (name, grade) -> name.equals("vipul") && grade.equals("A");
        System.out.println("bi-predicate " + isVipul.test(emps.get(2).getName(), emps.get(2).getGrade()));
        System.out.println("--------");
    }

    private static void consumers(List<Integer> listValues, List<Integer> listValues2) {

        System.out.println("1. Consumer Functional Interface");
        Consumer<List<Integer>> modify = list -> {
            for (int i = 0; i < list.size(); i++) {
                list.set(i, list.get(i) * 3);
            }
        };
        Consumer<List<Integer>> dispList = list -> list.stream().forEach(System.out::print);
        modify.andThen(dispList).accept(Arrays.asList(1, 2));
        System.out.println("--------");

        System.out.println("2. BiConsumer Functional Interface");
        BiConsumer<List<Integer>, List<Integer>> biModify = (list1, list2) -> {
            System.out.println("bi --------------");
            list1.stream().forEach(s -> {
                System.out.print(s + " ");
            });
            System.out.println();
            list2.stream().forEach(s -> {
                System.out.print(s + " ");
            });
        };
        biModify.accept(listValues, listValues2);
        System.out.println("--------");
    }
}

