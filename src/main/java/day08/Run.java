package day08;

import utils.ReadFile;

public class Run {
    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day08/input.txt");
        BatchFile file = new BatchFile(input);

        int index = 0;
        int ans;
        do {
            index = file.changeElementsReturnItIndex(index);
            System.out.println("Checking index: " + index);
            ans = file.process();
            if (ans != -1)
                break;
            else file = new BatchFile(input);
        } while (true);

        System.out.println(ans);
    }
}
