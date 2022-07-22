package ReflectionAndAnnotation.harvestingFields;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

import java.util.Arrays;
import java.util.Scanner;
import java.util.function.Function;

public class Main {
    private static final Field[] declaredMethods = RichSoilLand.class.getDeclaredFields();

    private static final String PRINT_FORMAT = "%s %s %s";

    private static final Function<Field, String> FIELD_STRING_FUNCTION =
            field -> String.format(PRINT_FORMAT, Modifier.toString(field.getModifiers()),
                    field.getType().getSimpleName(),
                    field.getName());

    private static void printFields(String modifier) {
        Arrays.stream(declaredMethods)
                .filter(field -> Modifier.toString(field.getModifiers()).equals(modifier))
                .map(FIELD_STRING_FUNCTION)
                .forEach(System.out::println);
    }


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        String command = scanner.nextLine();


        while (!command.equals("HARVEST")) {
            switch (command) {
                case "private":
                    printFields("private");
                    break;
                case "protected":
                    printFields("protected");
                    break;
                case "public":
                    printFields("public");
                    break;
                default:
                    Arrays.stream(declaredMethods)
                            .map(FIELD_STRING_FUNCTION)
                            .forEach(System.out::println);
                    break;
            }
            command = scanner.nextLine();
        }

    }

}
