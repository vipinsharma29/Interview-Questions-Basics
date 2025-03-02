package leetCodeQuestions;

public class LargeNumberAddition {

    public static String addLargeNumbers(String num1, String num2) {
        boolean hasCommas = num1.contains(",") || num2.contains(",");

        // Remove commas for calculation
        num1 = num1.replace(",", "");
        num2 = num2.replace(",", "");

        StringBuilder result = new StringBuilder();
        int carry = 0, i = num1.length() - 1, j = num2.length() - 1;
        int digitCount = 0; // To track when to insert commas

        while (i >= 0 || j >= 0 || carry > 0) {
            int digit1 = (i >= 0) ? num1.charAt(i) - '0' : 0;
            int digit2 = (j >= 0) ? num2.charAt(j) - '0' : 0;

            int sum = digit1 + digit2 + carry;
            carry = sum / 10;
            result.insert(0, sum % 10); // Insert at start to avoid reversing later

            i--;
            j--;
            digitCount++;

            // Insert comma every 3 digits (if required)
            if (hasCommas && digitCount % 3 == 0 && (i >= 0 || j >= 0 || carry > 0)) {
                result.insert(0, ",");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(addLargeNumbers("123456789123456789123456789", "987654321987654321987654321")); // Expected: 1111111111111111111111111110
        System.out.println(addLargeNumbers("1,200", "1,500")); // Expected: 2,700
        System.out.println(addLargeNumbers("999,999", "1")); // Expected: 1,000,000
    }
}