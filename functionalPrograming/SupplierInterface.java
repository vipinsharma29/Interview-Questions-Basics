package functionalPrograming;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.function.BooleanSupplier;
import java.util.function.DoubleSupplier;
import java.util.function.LongSupplier;
import java.util.function.Supplier;

public class SupplierInterface {

    public static void main(String[] args) {
        Supplier<String> localDate = () -> LocalDateTime.now().toString();
        System.out.println(localDate.get());

        Supplier<Double> printSum = () -> (double) 6 + 10;
        System.out.println(printSum.get());

        DoubleSupplier printDoubleSum = () -> 6 + 10;
        System.out.println(printDoubleSum.getAsDouble());

        LongSupplier printLongSum = () -> 9 + 10;
        System.out.println(printLongSum.getAsLong());

        List<String> name = new ArrayList<>();
        BooleanSupplier printBoolean = name::isEmpty;
        System.out.println(printBoolean.getAsBoolean());

        name.add("00");
        System.out.println(printBoolean.getAsBoolean());

    }
}
