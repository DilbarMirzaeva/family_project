package az.turingacademy.family.util;

import java.util.Scanner;

public class InputUtil {
    public static final Scanner sc = new Scanner(System.in);

    public static <T> T getInput(String text, Class<T> type) {
        System.out.println(text);

        while (true) {
            String input = sc.nextLine();
            try {
                if (type == Integer.class) {
                    return type.cast(Integer.parseInt(input));
                } else if (type == Double.class) {
                    return type.cast(Double.parseDouble(input));
                } else if (type == Boolean.class) {
                    return type.cast(Boolean.parseBoolean(input));
                } else {
                    return type.cast(input);
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid ,try again(input integer)..");
            }
        }

    }
}
