package task9_3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@interface TestSuite {
    String[] value() default "";
}

class TestSuitHandler {
    static void run(Class<?> clazz) {
        if (!clazz.isAnnotationPresent(TestSuite.class)) {
            System.out.printf("Class %s isn't annotated", clazz.getSimpleName());
            return;
        }

        for (String methodName : clazz.getAnnotation(TestSuite.class).value()) {
            try {
                Method method = clazz.getMethod(methodName);
                if (Modifier.isPublic(method.getModifiers()) || !Modifier.isStatic(method.getModifiers())) {
                    System.out.printf("\t -- Method %s.%s started --%n", clazz.getSimpleName(), method.getName());
                    method.invoke(clazz.getDeclaredConstructor().newInstance());
                    System.out.printf("\t -- Method %s.%s finished --%n", clazz.getSimpleName(), method.getName());
                }
            } catch (NoSuchMethodException | IllegalAccessException | InvocationTargetException | InstantiationException e) {
                System.out.printf("Method with name %s doesn't exists or not public in class %s%n", methodName, clazz.getSimpleName());
            }
        }
    }

    public static void main(String[] args) {
        run(Class1.class);
    }
}

@TestSuite
class Suite1 {

}

@TestSuite({"m1", "m2"})
class Class1 {
    public void m2() {
        System.out.println("Hello");
    }

    public void m3() {
        System.out.println("ds");
    }
}