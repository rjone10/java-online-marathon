package task7_1;

import java.time.LocalDate;

public class Solution {
    public static boolean tisLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }
}
