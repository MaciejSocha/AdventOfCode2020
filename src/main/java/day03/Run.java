package day03;

import utils.ReadFile;


public class Run {

    public static void main(String[] args) {
        String mapInput = ReadFile.read("src/main/java/day03/input.txt");
        long answer1 = (runner(mapInput, 1));
        long answer2 = (runner(mapInput, 3));
        long answer3 = (runner(mapInput, 5));
        long answer4 = (runner(mapInput, 7));
        long answer5 = (runner2Rows(mapInput, 1));

        long ans = answer1 * answer2 * answer3 * answer4 * answer5;

        System.out.println("ans1: " + answer1);
        System.out.println("ans2: " + answer2);
        System.out.println("ans3: " + answer3);
        System.out.println("ans4: " + answer4);
        System.out.println("ans5: " + answer5);
        System.out.println("answer: " + ans);
    }

    private static String copyLine(String line) {
        StringBuilder sb = new StringBuilder(line);
        sb.append(line);
        return sb.toString();
    }

    private static boolean checkIfTree(int position, String line) {
        return line.charAt(position) == '#';
    }

    private static int runner(String input, int columnToMove) {
        int treesCounter = 0;
        Cursor c = new Cursor();
        boolean isTree = false;

        for (int i = 0; i < input.lines().count()-1; i++) {
            String actualLine = (String) input.lines().toArray()[i];
            String nextLine = (String) input.lines().toArray()[i + 1];

            c.moveCursorInRow(columnToMove);

            while (c.getPositionInRow() >= nextLine.length())
                nextLine = copyLine(nextLine);

            if (checkIfTree(c.getPositionInRow(), nextLine))
                treesCounter++;
        }

        return treesCounter;
    }

    private static int runner2Rows(String input, int columnToMove) {
        int treesCounter = 0;
        Cursor c = new Cursor();

        for (int i = 0; i < input.lines().count()-2; i+=2) {
            String nextLine = (String) input.lines().toArray()[i + 2];

            c.moveCursorInRow(columnToMove);

            while (c.getPositionInRow() >= nextLine.length())
                nextLine = copyLine(nextLine);

            if (checkIfTree(c.getPositionInRow(), nextLine))
                treesCounter++;
        }

        return treesCounter;
    }
}
