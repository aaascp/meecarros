package utils;

import java.util.Optional;

public class StringUtils {

    public static Optional<Integer> parseInt(String value) {
        if(isEmptyOrNull(value)) {
            return Optional.empty();
        }

        try {
            return Optional.of(Integer.parseInt(value));
        } catch (NumberFormatException exception) {
            //Silently failing
            // TODO Log on logging tool
            exception.printStackTrace();
            return Optional.empty();
        }
    }

    public static Optional<Long> parseLong(String value) {
        if(isEmptyOrNull(value)) {
            return Optional.empty();
        }

        try {
            return Optional.of(Long.parseLong(value));
        } catch (NumberFormatException exception) {
            //Silently failing
            // TODO Log on logging tool
            exception.printStackTrace();
            return Optional.empty();
        }
    }

    private static boolean isEmptyOrNull(String value) {
        return value == null || value.equalsIgnoreCase("");
    }
}
