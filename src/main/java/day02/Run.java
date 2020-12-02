package day02;

import utils.ReadFile;

public class Run {
    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day02/input.txt");
        String tmp = "";
        for (int i = 0; i < input.lines().count(); i++) {
            tmp = (String)input.lines().toArray()[i];
        }
    }
}
