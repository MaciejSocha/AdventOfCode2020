package day03;

import utils.ReadFile;

public class Run {
    private static final int columnToMove = 3;
    private static final int rowToMove = 1;

    private static int globalTreesCounter = 0;

    public static void main(String[] args) {
        String mapInput = ReadFile.read("src/main/java/day03/input.txt");
        Cursor c = new Cursor();
        boolean isTree = false;

        for (int i = 0; i < mapInput.lines().count()-1; i++) {
            String actualLine = (String) mapInput.lines().toArray()[i];
            String nextLine = (String) mapInput.lines().toArray()[i + 1];

            c.moveCursorInRow(columnToMove);
            while (c.getPositionInRow() > nextLine.length())
                nextLine = copyLine(nextLine);

            if (checkIfTree(c.getPositionInRow(), nextLine))
                globalTreesCounter++;
        }

        System.out.println(globalTreesCounter);
    }

    private static String copyLine(String line) {
        StringBuilder sb = new StringBuilder(line);
        sb.append(line);
        return sb.toString();
    }

    private static boolean checkIfTree(int position, String line) {
        return line.charAt(position) == '#';
    }
}
