package ReflectionAndAnnotation.GetterAndSetter;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;

public class Main {
    private static class MethodComparator implements Comparator<Method> {
        @Override
        public int compare(Method f, Method s) {

            boolean firstGetter = f.getName().startsWith("get");
            boolean secondGetter = s.getName().startsWith("get");
            if (firstGetter && secondGetter) {
                return f.getName().compareTo(s.getName());
            }

            boolean firstSetter = f.getName().startsWith("set");
            boolean secondSetter = s.getName().startsWith("set");

            if (firstSetter && secondSetter) {
                return f.getName().compareTo(s.getName());
            }
            return Boolean.compare(secondGetter, firstGetter);
        }
    }

    public static void main(String[] args) {
        Class<Reflection> clazz = Reflection.class;

        Method[] allMethods = clazz.getDeclaredMethods();

        Arrays.stream(allMethods)
                .filter(method -> !method.getName().equals("toString"))
                .sorted(new MethodComparator())
                .forEach(Main::printInfo);
    }

    private static void printInfo(Method m) {
        System.out.println(m.getName().startsWith("get") ?
                String.format("%s will return class %s", m.getName(), m.getReturnType().getSimpleName()) :
                String.format("%s and will set field of class %s", m.getName(), m.getParameterTypes()[0].getSimpleName()));
    }
}
