package com.observation.exception.validator;

public final class Validator {

    public static boolean isNull(Object value) {
        if(value == null) {
            return true;
        } else {
            return false;
        }
    }
    public static boolean hasNumber(String value) {
        if (value == null) {
            return false;
        }
        try {
            double d = Double.parseDouble(value);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }
    public static boolean hasDigit(String value) {
        return isNull(value)? false : value.chars().anyMatch(letter -> Character.isDigit(letter));
    }
    public static boolean hasLetter(String value) {
        return isNull(value)? false : value.chars().anyMatch(letter -> Character.isLetter(letter));
    }
    public static boolean hasLowerCase(String value) {
        return isNull(value)? false : value.chars().anyMatch(letter -> Character.isLowerCase(letter));
    }
    public static boolean hasUpperCase(String value) {
        return isNull(value)? false : value.chars().anyMatch(letter -> Character.isUpperCase(letter));
    }
    public static boolean hasLength(int length, String value) {
        return isNull(value)? false : value.length() == length;
    }
    public static boolean hasMore(int length, String value) {
        return isNull(value)? false : value.length() >= length;
    }
}