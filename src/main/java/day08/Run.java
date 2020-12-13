package day08;

import utils.ReadFile;

public class Run {
    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day08/input.txt");
        BatchFile file = new BatchFile(input);

        System.out.println(file.process());
    }
}
