package task7_4;

import java.io.FileReader;
import java.io.IOException;

public class Solution {
    public static String readFile(String filename) {
        StringBuilder result = new StringBuilder();
        try (FileReader reader = new FileReader(filename)) {
            StringBuilder oneBite = new StringBuilder(); // 1 symbol

            int c;
            while ((c = reader.read()) != -1) {
                if (oneBite.length() < 6) {
                    oneBite.append(c == 49 ? 1 : 0);
                } else {
                    oneBite.append(c == 49 ? 1 : 0);
                    int charCode = Integer.parseInt(String.valueOf(oneBite), 2);
                    result.append((char) charCode);
                    oneBite = new StringBuilder();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result.toString();
    }

    public static void main(String[] args) {
        System.out.println(readFile("D:\\java\\1.txt"));
    }
}
