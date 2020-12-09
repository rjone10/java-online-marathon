package task3_4;

public class Solution {
    public enum LineType {
        SOLID("solid"), DOTTED("dotted"), DASHED("dashed"), DOUBLE("double");

        String type;
        LineType(String type) {
            this.type = type;
        }
    }

    public static String drawLine(LineType lineType) {

        return String.format("The line is %s type", lineType.type);

    }

    public static void main(String[] args) {
        System.out.println(drawLine(LineType.DOTTED));
    }
}
