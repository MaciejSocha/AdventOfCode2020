package day04;

import utils.ReadFile;

import java.util.Arrays;
import java.util.List;

public class Run {
    static int counter = 0;

    public static void main(String[] args) {
        String imp = ReadFile.read("src/main/java/day04/input.txt");

        List<String> abc = Arrays.asList(imp.split("\n\n"));

        abc.forEach(line -> abc.set(abc.indexOf(line), line.replaceAll("\n", " ")));

        abc.forEach(line -> {
            Passport passport = new Passport(line);
            if (passport.validate2())
                counter++;
        });

        System.out.println(counter);
    }
}
