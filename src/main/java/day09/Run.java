package day09;

import utils.ReadFile;

import java.util.*;

public class Run {
    static int pream = 25;
    static long foundedNumber;

    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day09/input.txt");
        int iter = 0;
        while (input.split("\n").length > 0) {
            List<Integer> preamble = new ArrayList<>();
            List<Long> elements = new ArrayList<>();

            int cnt = 1;
            for (String line : input.split("\n")) {
                if (cnt <= pream)
                    preamble.add(Integer.parseInt(line));
                else
                    elements.add(Long.parseLong(line));
                cnt++;
            }

            Collections.sort(preamble);
            long maxSum = preamble.get(preamble.size() - 1) + preamble.get(preamble.size() - 2);

            if (checkIfNumberIsSumOfGiven(elements.get(0), preamble, maxSum)) {
                System.out.println(elements.get(0));
                foundedNumber = elements.get(0);
                break;
            } else {
                input = input.substring(input.indexOf('\n') + 1);
            }
            iter++;
        }

        input = ReadFile.read("src/main/java/day09/input.txt");
        List<Long> allElements = new LinkedList<>();
        for (String line : input.split("\n")) {
            allElements.add(Long.parseLong(line));
        }

        for (int i = 0; i < allElements.size(); i++) {
            long sum = 0;
            int numOfAddedElements = 1;
            while (sum < foundedNumber) {
                sum += allElements.get(i + numOfAddedElements);
                numOfAddedElements++;
            }

            if (sum == foundedNumber) {
                List<Long> newElements = new ArrayList<>();
                for (int j = i + numOfAddedElements; j > i; j--) {
                    newElements.add(allElements.get(j));
                }
                Collections.sort(newElements);
                System.out.println(newElements);
                System.out.println(newElements.get(0) + newElements.get(newElements.size() - 1));
                break;
            }
        }
    }

    private static boolean checkIfNumberIsSumOfGiven(Long number, List<Integer> given, long maxVal) {
        if (number > maxVal) return false;
        //Collections.sort(given);
        boolean breaking = false;

        for (int i = 0; (i < pream) && !breaking; i++) {
            for (int j = 0; j < pream && !breaking; j++) {
                if (given.get(i) + given.get(j) == number) {
                    breaking = true;
                    break;
                }
            }
        }

        //System.out.println(number);
        return !breaking;
    }
}
