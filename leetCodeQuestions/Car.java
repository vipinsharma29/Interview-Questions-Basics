package leetCodeQuestions;

public class Car {
    private String make;
    private String model;
    private int year;
    private String color;


    public Car(String make, String model) {
        this.make = make;
        this.model = model;
    }


    public Car(String make, String model, int year) {
        this(make, model);
        this.year = year;
    }


    public Car(String make, String model, int year, String color) {
        this(make, model, year);
        this.color = color;
    }

    @Override
    public String toString() {
        return "Make: " + make + ", Model: " + model + ", Year: " + year + ", Color: " + color;
    }

    public static void main(String[] args) {
        Car car1 = new Car("Tesla", "Model S");
        Car car2 = new Car("Ford", "Mustang", 2020);
        Car car3 = new Car("BMW", "X5", 2023, "Black");

        System.out.println(car1);
        System.out.println(car2);
        System.out.println(car3);
    }
}