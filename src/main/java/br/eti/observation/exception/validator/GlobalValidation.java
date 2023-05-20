package br.eti.observation.exception.validator;

public class GlobalValidation {
    public static boolean isValidWithNumber(String number) {
        if (number == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(number);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean isValidWithName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}