package ReflectionAndAnnotation.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Main {
    private static final Method[] DECLARED_METHODS = BlackBoxInt.class.getDeclaredMethods();

    private static final Map<String, Method> NAME_METHOD = Arrays.stream(DECLARED_METHODS)
            .peek(method -> method.setAccessible(true))
            .collect(Collectors.toMap(Method::getName, method -> method));

    private static final String RESULT = "innerValue";

    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException,
            InstantiationException, IllegalAccessException, NoSuchFieldException {

        final Constructor<BlackBoxInt> ctors = BlackBoxInt.class.getDeclaredConstructor(int.class);
        ctors.setAccessible(true);

        final BlackBoxInt blackBoxInt = ctors.newInstance(0);

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();

        while (!command.equals("END")) {
            String[] tokens = command.split("_");
            String methodName = tokens[0];
            Integer value = Integer.parseInt(tokens[1]);

            final Method currentMethod = NAME_METHOD.get(methodName);
            currentMethod.invoke(blackBoxInt, value);

            final Field result = blackBoxInt.getClass().getDeclaredField(RESULT);
            result.setAccessible(true);

            System.out.println(result.get(blackBoxInt));

            command = scanner.nextLine();
        }

    }
}
