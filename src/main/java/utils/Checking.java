package utils;

public class Checking {
    public static boolean checkIfStringNumbers(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException ex) {
            return false;
        }
        return true;

    }
}
