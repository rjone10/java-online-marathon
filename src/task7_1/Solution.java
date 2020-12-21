package task7_1;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Solution {
    public static boolean tisLeapYear(int year) {
        LocalDate localDate = LocalDate.of(year, 1, 1);
        return localDate.isLeapYear();
    }

}
