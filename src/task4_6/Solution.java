package task4_6;

import java.lang.reflect.Array;
import java.lang.reflect.Type;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Solution {
    enum Level {
        JUNIOR, MIDDLE, SENIOR;
    }

    static class Person {
        protected String name;
        protected int age;

        public Person(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public int getAge() {
            return age;
        }

        @Override
        public String toString() {
            return "Name: " + name + ", Age: " + age;
        }
    }

    static class Employee extends Person {
        private double salary;

        public Employee(String name, int age, double salary) {
            super(name, age);
            this.salary = salary;
        }

        public double getSalary() {
            return salary;
        }

        @Override
        public String toString() {
            return super.toString() + ", Salary: " + salary;
        }
    }

    static class Developer extends Employee {
        private Level level;

        public Developer(String name, int age, double salary, Level level) {
            super(name, age, salary);
            this.level = level;
        }

        public Level getLevel() {
            return level;
        }

        @Override
        public String toString() {
            return super.toString() + ", Level: " + level;
        }
    }


    static class PersonComparator implements Comparator<Person> {

        @Override
        public int compare(Person o1, Person o2) {
            return o1.getName().compareTo(o2.getName()) > 0 ? o1.name.compareTo(o2.getName()) :
                    o1.getName().compareTo(o2.getName()) < 0 ? o1.getName().compareTo(o2.getName()) :
                            o1.getAge() > o2.getAge() ? 1 : -1;
        }

    }

    static class EmployeeComparator implements Comparator<Employee> {
        @Override
        public int compare(Employee o1, Employee o2) {
            int compare = new PersonComparator().compare(o1, o2);
            return compare == 0 ? Double.compare(o1.getSalary(), o2.getSalary()) : compare;
        }
    }

    static class DeveloperComparator implements Comparator<Developer> {
        @Override
        public int compare(Developer o1, Developer o2) {
            int compare = new EmployeeComparator().compare(o1, o2);
            return compare == 0 ? o1.getLevel().compareTo(o2.getLevel()) : compare;
        }
    }

    static class Utility {
        public static <T extends Person> void sortPeople(T[] persons, Comparator<? super T> comparator) {
            Arrays.sort(persons, comparator);
        }
    }

    public static void main(String[] args) {
        Utility.sortPeople(new Person[]{new Person("Petro", 25)}, new PersonComparator());
        Utility.sortPeople(new Employee[]{new Employee("Vasya", 20, 2000)}, new EmployeeComparator());
        Utility.sortPeople(new Developer[]{new Developer("Vasyl", 20, 20000, Level.JUNIOR)}, new DeveloperComparator());
//        Utility.sortPeople(new String[]{ "ca", "ab", "dc", "bd" }, new StringComparator());.
    }
}
