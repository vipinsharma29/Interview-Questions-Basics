package models;

public class Student {

    private final int id;
    private final String name;
    private final int age;
    private final String className;

    private Student(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.age = builder.age;
        this.className = builder.className;
    }

    @Override
    public String toString() {
        return "Student{id=" + id + ", name='" + name + "', age=" + age + ", className='" + className + "'}";
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getClassName() {
        return className;
    }

    public static class Builder {
        private int id;
        private String name;
        private int age;
        private String className;

        public Builder setId(int id) {
            this.id = id;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setAge(int age) {
            this.age = age;
            return this;
        }

        public Builder setClassName(String className) {
            this.className = className;
            return this;
        }

        public Student build() {
            return new Student(this);
        }
    }
}