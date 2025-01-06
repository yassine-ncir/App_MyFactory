package apps.app_myfactory.utils;

public class Utility {
    public static <E extends Enum<E>> E getEnumValue(Class<E> enumType, String value, E defaultValue) {
        if (value == null) {
            return defaultValue; // Return the default value if the input is null
        }
        try {
            return Enum.valueOf(enumType, value); // Convert the value to an Enum
        } catch (IllegalArgumentException e) {
            // Log or handle the invalid value case
            System.out.println("Invalid enum value: " + value + " for enum type: " + enumType.getSimpleName());
            return defaultValue; // Return the default value for invalid values
        }
    }

}
