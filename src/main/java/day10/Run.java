package day10;

import utils.ReadFile;

import java.util.*;

public class Run {
    static int jolts = 0;
    public static void main(String[] args) throws Exception{
        Map<Integer, Integer> map = new HashMap<>();
        map.put(1, 0);
        map.put(2, 0);
        map.put(3, 0);

        String input = ReadFile.read("src/main/java/day10/input.txt");
        List<String> elements = Arrays.asList(input.split("\n"));
        List<Integer> elems = new ArrayList<>();
        elements.forEach(s -> elems.add(Integer.parseInt(s)));

        Collections.sort(elems);

        int prev = 0;
        for (int i : elems){

            jolts += i;
            switch (i - prev) {
                case 1:
                    map.replace(1, map.get(1)+1);
                    break;
                case 2:
                    map.replace(2, map.get(2)+1);
                    break;
                case 3:
                    map.replace(3, map.get(3)+1);
                    break;

                default:
                    throw new Exception("nul");
            }
            prev = i;
        }
        map.replace(3, map.get(3)+1);
        System.out.println(map.get(1));
        System.out.println(map.get(3));
    }
}
