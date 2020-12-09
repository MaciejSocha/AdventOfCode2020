package day06;

import utils.ReadFile;

import java.util.Arrays;
import java.util.List;

public class Run {
    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day06/input.txt");
        int sum = 0;
        List<String> groups = Arrays.asList(input.split("\n\n"));

        for (String elements : groups) {
            List<String> answers = Arrays.asList(elements.split("\n").clone());
            Questionnaire q = new Questionnaire();
            for (String s : answers) {
                q.insertStringData(s);
            }
            sum += q.countTrue(answers.size());
        }
        System.out.println(sum);
    }
}
