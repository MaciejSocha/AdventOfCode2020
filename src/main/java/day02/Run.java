package day02;

import utils.ReadFile;

public class Run {
    public static int counter = 0;

    public static void main(String[] args) {
        String input = ReadFile.read("src/main/java/day02/input.txt");
        String tmp = "";

        for (int i = 0; i < input.lines().count(); i++) {
            tmp = (String) input.lines().toArray()[i];
            PasswordRecord passwdRc = new PasswordRecord(tmp);
            if (passwdRc.checkIsPasswordValid()) counter++;
        }

        System.out.println("Number of valid passwords: " + counter);

        //second part

        counter = 0;

        for (int i = 0; i < input.lines().count(); i++) {
            tmp = (String) input.lines().toArray()[i];
            PasswordRecord passwdRc = new PasswordRecord(tmp);
            if (passwdRc.checkNewPasswordValid()) counter++;
        }

        System.out.println("Number of valid passwords 2: " + counter);
    }
}
