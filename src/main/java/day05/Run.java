package day05;

import utils.ReadFile;

public class Run {
    private static int maxID = 0;

    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day05/input.txt");
        input.lines().forEach(line -> {
            int currentID = calculateID(decodeNumber(line));
            if (currentID > maxID) maxID = currentID;
        });

        System.out.println(maxID);
    }

    private static int calculateID(Pair<Integer> location) {
        return (location.x * 8 + location.y);
    }

    private static Pair<Integer> decodeNumber(String input) {
        Pair<Integer> location = new Pair<>();
        location.x = 0;
        location.y = 127;

        Pair<Integer> locationRowCols = new Pair<>();
        locationRowCols.x = 0;
        locationRowCols.y = 0;

        int i = 0;
        int mid;
        char c;
        while (input.charAt(i) == 'F' || input.charAt(i) == 'B') {
            c = input.charAt(i);
            mid = calculateMiddle(location.y, location.x);
            if (c == 'F'){
                location.y = mid;
            } else {
                location.x = mid;
            }
            i++;
        }

        locationRowCols.x = location.y;

        location.x = 0;
        location.y = 7;

        while (i<input.length()){
            c = input.charAt(i);
            mid = calculateMiddle(location.y, location.x);
            if (c == 'L'){
                location.y = mid;
            } else {
                location.x = mid;
            }
            i++;
        }

        locationRowCols.y = location.y;

        return locationRowCols;
    }

    private static int calculateMiddle(int first, int second) {
        if (first == 0 && second == 63) return 32;
        return Math.floorDiv((second - first), 2) + first;
    }
}
