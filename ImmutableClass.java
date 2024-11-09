final class Person {
    private final String name;
    private final int age;
    private final Address address;

    // Constructor to initialize all fields
    public Person(String name, int age, Address address) {
        this.name = name;
        this.age = age;
        // Create a deep copy of the address to maintain immutability
        this.address = new Address(address.getStreet(), address.getCity());
    }

    // Getter methods for each field, but no setters
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Address getAddress() {
        // Return a copy of address to prevent outside modifications
        return new Address(address.getStreet(), address.getCity());
    }
}

class Address {
    private String street;
    private String city;

    public Address(String street, String city) {
        this.street = street;
        this.city = city;
    }

    // Getters and setters
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}

public class ImmutableClass {
    public static void main(String[] args) {
        Address address = new Address("123 Main St", "Springfield");
        Person person = new Person("John", 30, address);

        System.out.println(person.getAddress().getCity()); // Springfield

        // Try modifying the address after creating the Person object
        address.setCity("New City");

        // The person's address remains unaffected
        System.out.println(person.getAddress().getCity()); // Still Springfield
    }
}

