package task2_4;

import java.math.BigDecimal;
import java.util.*;

public class Solution {

    static class Employee {
        private String name;
        private int experience;
        private BigDecimal basePayment;

        public Employee(String name, int experience, BigDecimal basePayment) {
            this.name = name;
            this.experience = experience;
            this.basePayment = basePayment.setScale(2);
        }

        public String getName() {
            return name;
        }

        public int getExperience() {
            return experience;
        }

        public BigDecimal getPayment() {
            return basePayment;
        }

        public void setPayment(BigDecimal basePayment) {
            this.basePayment = basePayment;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Employee employee = (Employee) o;
            return experience == employee.experience &&
                    Objects.equals(name, employee.name) &&
                    Objects.equals(basePayment, employee.basePayment);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, experience, basePayment);
        }

        @Override
        public String toString() {
            return "\nEmployee [name=" + name + ", experience=" + experience + ", basePayment=" + basePayment + "]";
        }

    }

    static class Manager extends Employee {
        private double coefficient;

        public Manager(String name, int experience, BigDecimal basePayment, double coefficient) {
            super(name, experience, basePayment);
            this.coefficient = coefficient;
        }

        public double getCoefficient() {
            return coefficient;
        }

        @Override
        public BigDecimal getPayment() {
            return super.getPayment().multiply(new BigDecimal(coefficient));
        }

        @Override
        public void setPayment(BigDecimal basePayment) {
            super.setPayment(basePayment);
        }


        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (o.equals(null)) return false;
            if (!super.equals(o)) return false;
            Manager manager = (Manager) o;
            return Double.compare(manager.coefficient, coefficient) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), coefficient);
        }

        @Override
        public String toString() {
            return super.toString() + "\nManager [coefficient=" + coefficient + "]";
        }

    }

    public static class MyUtils {
        public List<Employee> largestEmployees(List<Employee> workers) {
            if (workers == null) {
                throw new NullPointerException();
            }
            if (workers.isEmpty()) {
                return new LinkedList<>();
            }
            List<Employee> uniqueEmployees = new LinkedList<>(); // final list
            List<Employee> copyList = new LinkedList<>(); // copy of list

            int maxExpManager = 0;
            BigDecimal maxPaymentManager = BigDecimal.valueOf(Double.MIN_VALUE);
            int maxExpEmployee = 0;
            BigDecimal maxPaymentEmployee = BigDecimal.valueOf(Double.MIN_VALUE);

            for (Employee e : workers) {
                if (e != null && e.getName() != null) {
                    copyList.add(e);
                    if (e instanceof Manager) { //find max Manager
                        if (e.getExperience() >= maxExpManager) {
                            maxExpManager = e.getExperience();
                        }
                        if (e.getPayment().compareTo(maxPaymentManager) >= 0) {
                            maxPaymentManager = e.getPayment();
                        }
                    } else {                    // find max Employee
                        if (e.getExperience() >= maxExpEmployee) {
                            maxExpEmployee = e.getExperience();
                        }
                        if (e.getPayment().compareTo(maxPaymentEmployee) >= 0) {
                            maxPaymentEmployee = e.getPayment();
                        }
                    }
                }
            }
            for (Employee e : copyList) {
                if (e instanceof Manager) {
                    if (!uniqueEmployees.contains(e)
                            && (e.getExperience() == maxExpManager || e.getPayment().equals(maxPaymentManager))) {
                        uniqueEmployees.add(e);
                    }
                } else {
                    if (!uniqueEmployees.contains(e)
                            && (e.getExperience() == maxExpEmployee || e.getPayment().equals(maxPaymentEmployee))) {
                        uniqueEmployees.add(e);
                    }
                }
            }

            return uniqueEmployees;
        }
    }
    public static boolean checkUniqueAll() {
        List<Employee> originList = new ArrayList<>();
        originList.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
        originList.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
        originList.add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
        originList.add(new Employee("Andriy", 7, new BigDecimal(3500.00)));
        originList.add(new Employee("Ihor", 5, new BigDecimal(3500.00)));
        originList.add(new Manager("Vasyl", 8, new BigDecimal(2000.00), 2.0));
        //
        List<Employee> expected = new ArrayList<>();
        expected.add(new Employee("Stepan", 8, new BigDecimal(4000.00)));
        expected.add(new Employee("Ivan", 10, new BigDecimal(3000.00)));
        expected.add(new Manager("Petro", 9, new BigDecimal(3000.00), 1.5));
        //
        List<Employee> actual = null;
        try {
            actual = new MyUtils().largestEmployees(originList);
        } catch (Exception e) {
            return false;
        }
        System.out.println(actual);
        return expected.equals(actual);
//        return new HashSet<Employee>(expected).equals(new HashSet<Employee>(actual));
    }

    public static void main(String[] args) {
        System.out.println(checkUniqueAll());
    }
}
