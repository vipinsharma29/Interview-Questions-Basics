package leetCodeQuestions;

import java.util.Stack;

public class RemoveKConsecutiveIdenticalCharacters {

    public static String reduced_String(int k, String s) {
        // Your code goes here
        Stack<Character> stk = new Stack<Character>();
        int i = 0;
        while (i < s.length()) {
            char ch = s.charAt(i++);
            stk.push(ch);
            int count = 0;
            while ((stk.size() > 0) && (stk.peek() == ch)) {
                count++;
                stk.pop();
            }
            if (count == k)
                continue;
            else {
                while (count > 0) {
                    stk.push(ch);
                    count--;
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        for (char ch : stk)
            sb = sb.append(ch);
        return sb.toString();
    }

    public static void main(String[] args) {
        int k = 2;
        String st = "geeksforgeeks";
        String ans = reduced_String(k, st);
        System.out.println(ans);
    }
}