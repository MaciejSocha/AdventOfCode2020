package day02;

public class PasswordRecord {
    private int minOccurs;
    private int maxOccurs;
    private char character;
    private String password;

    public PasswordRecord(String oneDBLine) {
        oneDBLine = oneDBLine.trim();
        String occurs = oneDBLine.split(" ")[0];
        String letter = oneDBLine.split(" ")[1];
        String passwd = oneDBLine.split(" ")[2];

        this.minOccurs = Integer.parseInt(occurs.split("-")[0]);
        this.maxOccurs = Integer.parseInt(occurs.split("-")[1]);

        this.character = letter.split(":")[0].charAt(0);

        this.password = passwd;
    }

    public boolean checkIsPasswordValid() {
        int counter = 0;
        for (char c : password.toCharArray()) {
            if (c == character) counter++;
        }
        return (counter >= minOccurs && counter <= maxOccurs);
    }

    public boolean checkNewPasswordValid() {
        return ((password.charAt(minOccurs - 1) == character && password.charAt(maxOccurs - 1) != character) || (password.charAt(minOccurs - 1) != character && password.charAt(maxOccurs - 1) == character));
    }
}
