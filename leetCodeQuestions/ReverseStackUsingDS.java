package leetCodeQuestions;

import java.util.List;
import java.util.Stack;
import java.util.TreeSet;

public class ReverseStackUsingDS {

    public static void main(String[] args) {
        Stack<Integer> data = new Stack<>();
        data.addAll(List.of(3, 2, 5, 1, 4, 5));

//        System.out.println("Initial Stack: " + data);
//        System.out.println("Final Sorted Stack: " + sortUsingStack(data));

        sortUsingTreeSet(data);
    }

    private static Stack<Integer> sortUsingStack(Stack<Integer> data) {

        Stack<Integer> sortedStack = new Stack<>();

        while (!data.isEmpty()) {
            int temp = data.pop();

            while (!sortedStack.isEmpty() && temp < sortedStack.peek()) {
                data.push(sortedStack.pop());
            }

            sortedStack.push(temp);
        }
        return sortedStack;
    }

    private static void sortUsingTreeSet(Stack<Integer> data) {

        TreeSet<Integer> tree = new TreeSet<>();

        while (!data.isEmpty()) {
            tree.add(data.pop());
        }

        System.out.println(tree);
    }
}
