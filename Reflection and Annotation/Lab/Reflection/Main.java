package ReflectionAndAnnotation.Reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        Class<Reflection> clazz = Reflection.class;

        System.out.println(clazz);

        System.out.println(clazz.getSuperclass());

        try {
            Arrays.stream(clazz.getInterfaces())
                    .forEach(System.out::println);

            Constructor<Reflection> ctor = clazz.getDeclaredConstructor();
            Reflection reflection = ctor.newInstance();
            System.out.println(reflection);

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException ex) {
            ex.printStackTrace();
        }

    }
}
