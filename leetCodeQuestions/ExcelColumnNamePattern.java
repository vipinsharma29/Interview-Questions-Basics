package leetCodeQuestions;

public class ExcelColumnNamePattern {

    public static String getColumnName(int n) {
        StringBuilder columnName = new StringBuilder();

        while (n > 0) {
            n--;
            int remainder = n % 26;
            columnName.insert(0, (char) (remainder + 'A'));
            n = n / 26;
        }

        return columnName.toString();
    }

    public static void main(String[] args) {
        int n1 = 26;
        int n2 = 51;

        System.out.println(n1 + " → " + getColumnName(n1)); // Output: Z
        System.out.println(n2 + " → " + getColumnName(n2)); // Output: AY
    }

}
