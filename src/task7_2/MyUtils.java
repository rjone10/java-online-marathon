package task7_2;

import java.time.Duration;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;

class MyUtils {
    public static String getDateAfterToday(int years, int months, int days) {
//        LocalDate today = LocalDate.now().plusYears(years).plusMonths(months).plusDays(days);
        return LocalDate.now().plusYears(years).plusMonths(months).plusDays(days).toString();
    }

    public static void main(String[] args) {
        getDateAfterToday(3, 18, 27);
    }
}
