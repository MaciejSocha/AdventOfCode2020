package day07;

import utils.ReadFile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Run {
    public static void main(String[] args) {
        String bagToFind = "shiny gold";
        String input = ReadFile.read("src/main/java/day07/input.txt");
        List<ColorBag> colorsBags = new ArrayList<>();

        for (String line : input.split("\n")) {
            String color = line.split(" bags contain ")[0];
            String rest = line.split(" bags contain ")[1];
            ColorBag cb = new ColorBag(color);

            if (!rest.trim().equals("no other bags.")) {
                for (String element : rest.split(",")) {
                    element = element.trim();
                    int count = Integer.parseInt(String.valueOf(element.charAt(0)));
                    element = element.substring(2);
                    String name = element.trim().split(" bags| bag")[0];
                    cb.addNewColorBag(name, count);
                }
            } else {
                cb.emptyBag();
            }
            colorsBags.add(cb);
        }

        List<String> foundedCol = new ArrayList<>();
        for (ColorBag cb : colorsBags) {
            if (cb.containsGivenColor(bagToFind) != null)
                foundedCol.add(cb.containsGivenColor(bagToFind));
        }


        List<String> foundedCol2 = new ArrayList<>();
        int sizeBefore = foundedCol.size();

        do {
            sizeBefore = foundedCol.size();
            for (String firstColor : foundedCol) {
                for (ColorBag cb : colorsBags) {
                    if (cb.containsGivenColor(firstColor) != null)
                        foundedCol2.add(cb.containsGivenColor(firstColor));
                }
            }
            foundedCol.addAll(foundedCol2);
            foundedCol = foundedCol.stream().distinct().collect(Collectors.toList());
        } while (sizeBefore != foundedCol.size());

        System.out.println(foundedCol.size());
    }
}
