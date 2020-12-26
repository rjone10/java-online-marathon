package task9_1;

import java.lang.annotation.*;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.lang.reflect.Field;
import java.util.function.Function;
import java.util.stream.Stream;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface CamelCase {
}


class CheckCamelCase {
    static final String CAMELCASE_PATTERN = "([a-z _]+\\w*)";

    static boolean checkAndPrint(Class clazz) {


//        Stream<Method> stream = Arrays.stream(clazz.getDeclaredMethods())

//        Stream<Annotation> annotationStream = stream.filter(a -> a.getAnnotations())
//        Arrays.stream(clazz.getMethods())
//                .filter(method -> method.getAnnotation(clazz) instanceof CamelCase)
//                .forEach(System.out::println);
////                .forEach(method -> System.out.println(method.getName()));
//
//        if (stream.anyMatch(method -> method.getName().matches(CAMELCASE_PATTERN))) {
//            return true;
//        } else {
//            stream.filter(method -> !method.getName()
//                    .matches(CAMELCASE_PATTERN))
//                    .forEach(method -> System.out.printf(
//                            "method %s.%s doesn't satisfy camelCase naming convention", method.getClass().getName(), method.getName()));
//            return false;
//        }
        return false;
    }

    public static void main(String[] args) {
        checkAndPrint(Class1.class);
    }
}

class ClassForAnnot {
    @CamelCase
    public static void example() {
    }

    @CamelCase
    public void Example() {
    }

    public static void _main(String args[]) {
    }
}

class Class1 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void InCorrect() {
    }

    @CamelCase
    public void JustMethod() {
    }
}

class Class2 {
    @CamelCase
    public void correct() {
    }

    @CamelCase
    public void oneMoreCorrect() {
    }
}
