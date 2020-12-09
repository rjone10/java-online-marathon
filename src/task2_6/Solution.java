package task2_6;

import javax.crypto.Cipher;
import java.math.BigDecimal;
import java.util.*;

public class Solution {

    abstract static class Shape {
        private String name;

        public Shape(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public double getArea() {
            return 0;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Shape shape = (Shape) o;
            return Objects.equals(name, shape.name);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name);
        }
    }

    static class Circle extends Shape {
        private double radius;

        public Circle(String name, double radius) {
            super(name);
            this.radius = radius;
        }

        public double getRadius() {
            return radius;
        }

        @Override
        public double getArea() {
            final double Pi = 3.1415926536;
            return Pi * (getRadius() * getRadius());
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Circle circle = (Circle) o;
            return Double.compare(circle.radius, radius) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), radius);
        }
    }

    static class Rectangle extends Shape {
        private double height;
        private double width;

        public Rectangle(String name, double height, double width) {
            super(name);
            this.height = height;
            this.width = width;
        }

        public double getHeight() {
            return height;
        }

        public double getWidth() {
            return width;
        }

        @Override
        public double getArea() {
            return getHeight() * getWidth();
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            if (!super.equals(o)) return false;
            Rectangle rectangle = (Rectangle) o;
            return Double.compare(rectangle.height, height) == 0 &&
                    Double.compare(rectangle.width, width) == 0;
        }

        @Override
        public int hashCode() {
            return Objects.hash(super.hashCode(), height, width);
        }
    }

    public static class MyUtils {
        public List<Shape> maxAreas(List<Shape> shapes) {
            List<Shape> maxValues = new LinkedList<>();
            double maxCircle = 0;
            double maxRectangle = 0;

            for (Shape s : shapes) {
                if (s instanceof Circle) { // max circles area
                    if (s.getArea() >= maxCircle) {
                        maxCircle = s.getArea();
                    }
                } else {                   // max rectangle area
                    if (s.getArea() >= maxRectangle) {
                        maxRectangle = s.getArea();
                    }
                }
            }

            for (Shape s : shapes) {
                if (s instanceof Circle) {
                    if (s.getArea() == maxCircle) {
                        maxValues.add(s);
                    }
                } else {
                    if (s.getArea() == maxRectangle) {
                        maxValues.add(s);
                    }
                }
            }
            return maxValues;
        }
    }
    public static void main(String[] args) {
        List<Shape> shapes = new LinkedList<>();
        shapes.add(new Circle("1", 2.0));
        shapes.add(new Rectangle("2", 2.0, 3.0));
        shapes.add(new Circle("3", 1.0));
        shapes.add(new Rectangle("4", 3.0,2.0));

        MyUtils myUtils = new MyUtils();
        myUtils.maxAreas(shapes);
    }
}
