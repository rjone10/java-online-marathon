package task6_4;

import java.util.ArrayList;
import java.util.List;

class Person {
    String name;

    Person(String name) {
        this.name = name;
    }

    DecisionMethod goShopping = (name, discount) -> name.equals("product1") && discount > 10;
}

@FunctionalInterface
interface DecisionMethod {
    boolean decide(String name, int discount);
}

class Shop {
    public List<DecisionMethod> clients = new ArrayList<>();

    public int sale(String product, int percent) {
        int counter = 0;
        for (DecisionMethod d : clients) {
            if (d.decide(product, percent)) {
                counter++;
            }
        }
        return counter;
    }
}
