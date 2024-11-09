package designPatterns;

// Step 1: Define interfaces for products
interface Vehicle {
    void drive();
}

interface Engine {
    void start();
}

// Step 4: Define Abstract Factory for creating families of objects
interface VehicleFactory {
    Vehicle createVehicle();

    Engine createEngine();
}

// Step 2: Create concrete classes for Car family
class Car implements Vehicle {
    public void drive() {
        System.out.println("Driving a car");
    }
}

class CarEngine implements Engine {
    public void start() {
        System.out.println("Starting a car engine");
    }
}

// Step 3: Create concrete classes for Bike family
class Bike implements Vehicle {
    public void drive() {
        System.out.println("Riding a bike");
    }
}

class BikeEngine implements Engine {
    public void start() {
        System.out.println("Starting a bike engine");
    }
}

// Step 5: Create concrete factories for each family of products
class CarFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Car();
    }

    public Engine createEngine() {
        return new CarEngine();
    }
}

class BikeFactory implements VehicleFactory {
    public Vehicle createVehicle() {
        return new Bike();
    }

    public Engine createEngine() {
        return new BikeEngine();
    }
}

// Usage
public class AbstractFactoryDesignPattern {
    public static void main(String[] args) {
        VehicleFactory carFactory = new CarFactory();
        Vehicle car = carFactory.createVehicle();
        Engine carEngine = carFactory.createEngine();

        car.drive();
        carEngine.start();

        VehicleFactory bikeFactory = new BikeFactory();
        Vehicle bike = bikeFactory.createVehicle();
        Engine bikeEngine = bikeFactory.createEngine();

        bike.drive();
        bikeEngine.start();
    }
}