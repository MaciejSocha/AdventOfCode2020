package day01;

import utils.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Run {
    private static final int sumValue = 2020;

    public static void main(String[] args) {
        Random rand = new Random();
        String input = ReadFile.read("src/main/java/day01/input.txt");

        List<Integer> inputs = new ArrayList<>();
        input.lines().forEach((String e) -> inputs.add(Integer.parseInt(e)));

        int result = -1;
        int secondResult = -1;

        for (int i = 0; i < inputs.size(); i++) {
            result = inputs.get(rand.nextInt(inputs.size()));
            inputs.remove((Integer) result);

            boolean isFound = false;
            for (int j = 0; j < inputs.size(); j++) {
                if (inputs.contains(sumValue - result))
                    secondResult = inputs.get(inputs.indexOf(sumValue - result));

                if (secondResult + result == sumValue) {
                    isFound = true;
                    break;
                }
            }
            if (isFound) break;
        }

        System.out.println("First number: " + result);
        System.out.println("Second number: " + secondResult);
        System.out.println("Multiply: " + (result * secondResult));
    }


}
