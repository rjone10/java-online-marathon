package task2_5;

import java.util.ArrayList;
import java.util.List;

public class Solution {

    class Rectang extends Square {
        private double height;

        public Rectang(double width, double height) {
            super(width);
            this.height = height;
        }

        public double getHeight() {
            return height;
        }

        @Override
        public double getPerimeter() {
            return (height + getWidth()) * 2;
        }
    }

    class Square {
        private double width;

        public Square(double width) {
            this.width = width;
        }

        public double getWidth() {
            return width;
        }

        public double getPerimeter() {
            return (width + width) * 2;
        }
    }

    public class MyUtils {
        public double sumPerimeter(List<Square> firures) {
            double sum = 0;
            for (Square square : firures) {
                if (square != null)
                sum += square.getPerimeter();
            }
            return sum;
        }
    }
}
