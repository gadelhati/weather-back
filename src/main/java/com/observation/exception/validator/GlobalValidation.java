package com.observation.exception.validator;

public class GlobalValidation {
    public static boolean isValidWithNumber(Object number) {
        if (number == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(number.toString());
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }
    public static boolean isValidWithName(String name) {
        if (name == null || name.isEmpty()) {
            return false;
        } else {
            return true;
        }
    }
}