package functionalPrograming;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class ConsumerInterface {

    public static void main(String[] args) {

        List<Integer> numbers = new ArrayList<>();
        Consumer<Integer> addToList = numbers::add;

        addToList.accept(10);
        addToList.accept(20);

        System.out.println(numbers);

    }
}
