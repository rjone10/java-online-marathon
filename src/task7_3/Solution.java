package task7_3;

import java.io.FileWriter;
import java.io.IOException;

public class Solution {
    public static void writeFile(String filename, String text){
        try (FileWriter fileWriter = new FileWriter(filename)) {
            StringBuilder result = new StringBuilder();
            char[] chars = text.toCharArray();
            for (char c : chars) {
                result.append(String.format("%7s", Integer.toBinaryString(c)).replaceAll(" ", "0"));
            }
            fileWriter.write(String.valueOf(result));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
