package task9_2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface Review {
    String reviewer();

    String date() default "today";
}

class Util {
    static void review(String className) {
        try {
            Class<?> myClass = Class.forName(className);
            if (myClass.isAnnotationPresent(Review.class)) {
                String dateTime = myClass.getAnnotation(Review.class).date();
                String reviewer = myClass.getAnnotation(Review.class).reviewer();
                if (dateTime.equals("today")) {
                    LocalDateTime ldt = LocalDateTime.now();
                    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
                    dateTime = formatter.format(ldt);
                }
                System.out.printf("Class %s was reviewed %s by %s.%n", className, dateTime, reviewer);
            } else {
                System.out.printf("Class %s isn't marked as Reviewed", className);
            }
        } catch (ClassNotFoundException e) {
            System.out.printf("Class %s was not found", className);
        }
    }

    public static void main(String[] args) {
        review("task9_2.Test");
    }
}

@Review(reviewer = "Tester", date = "2020-14-23")
class Test {
}

