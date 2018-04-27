package utils;

public class StringUtils {
    public static boolean isEmptyOrNull(String value) {
        return value == null || value.equalsIgnoreCase("");
    }
}
