package day07;

import java.util.Map;
import java.util.TreeMap;

public class ColorBag {
    private String color;
    private boolean empty;
    private Map<String, Integer> containColor;

    public ColorBag(String color) {
        this.empty = false;
        this.containColor = new TreeMap<>();
        this.color = color;
    }

    public void emptyBag() {
        this.empty = true;
    }

    public void addNewColorBag(String color, int count) {
        containColor.put(color, count);
    }

    public String containsGivenColor(String color) {
        for (String s : containColor.keySet())
            if (s.equals(color)) return this.color;
        return null;
    }
}
