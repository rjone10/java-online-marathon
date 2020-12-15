package task6_3;

import java.util.Arrays;
import java.util.function.BinaryOperator;
import java.util.ArrayList;
import java.util.List;

public class App {

    static BinaryOperator<String> greetingOperator = (s, s2) -> "Hello " + s + " " + s2 + "!!!";

    public static List<String> createGreetings(List<Person> people, BinaryOperator<String> binaryOperator) {
        List<String> resultList = new ArrayList<>();
        for (Person person : people) {
            resultList.add(binaryOperator.apply(person.name, person.surname));
        }
        return resultList;
    }
}
