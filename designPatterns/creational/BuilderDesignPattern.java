package designPatterns.creational;

import models.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderDesignPattern {

    public static void main(String[] args) {

        Student s = new Student.Builder()
                .setId(1)
                .setName("John")
                .setAge(20).build();

        System.out.println(s);
    }

}
