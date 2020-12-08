package day04;

import utils.Checking;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Passport {
    private String byr;
    private String iyr;
    private String eyr;
    private String hgt;
    private String hcl;
    private String ecl;
    private String pid;
    private String cid;

    public Passport(String line) {
        String[] elements = line.split(" ");
        for (String element : elements) {
            switch (element.split(":")[0]) {
                case "byr":
                    this.byr = element.split(":")[1];
                    break;
                case "iyr":
                    this.iyr = element.split(":")[1];
                    break;
                case "eyr":
                    this.eyr = element.split(":")[1];
                    break;
                case "hgt":
                    this.hgt = element.split(":")[1];
                    break;
                case "hcl":
                    this.hcl = element.split(":")[1];
                    break;
                case "ecl":
                    this.ecl = element.split(":")[1];
                    break;
                case "pid":
                    this.pid = element.split(":")[1];
                    break;
                case "cid":
                    this.cid = element.split(":")[1];
                    break;

                default:
                    throw new RuntimeException("Sth went wrong");
            }
        }
    }

    boolean validate() {
        return (byr != null && iyr != null && eyr != null && hgt != null && hcl != null && ecl != null && pid != null);
    }

    boolean validate2() {
        boolean b1 = validate();
        if (b1) {
            boolean b2 = validBYR();
            boolean b3 = validIYR();
            boolean b4 = validEYR();
            boolean b5 = validHGT();
            boolean b6 = validHCL();
            boolean b7 = validECL();
            boolean b8 = validPID();

            return b2 && b3 && b4 && b5 && b6 && b7 && b8;
        }

        return false;
    }

    private boolean validBYR() {
        if (Checking.checkIfStringNumbers(byr) && !byr.isEmpty())
            return (byr.length() == 4 && Integer.parseInt(byr) >= 1920 && Integer.parseInt(byr) <= 2002);
        else return false;
    }

    private boolean validIYR() {
        if (Checking.checkIfStringNumbers(iyr) && !iyr.isEmpty())
            return (iyr.length() == 4 && Integer.parseInt(iyr) >= 2010 && Integer.parseInt(iyr) <= 2020);
        else return false;
    }

    private boolean validEYR() {
        if (Checking.checkIfStringNumbers(eyr) && !eyr.isEmpty())
            return (eyr.length() == 4 && Integer.parseInt(eyr) >= 2020 && Integer.parseInt(eyr) <= 2030);
        else return false;
    }

    private boolean validHGT() {
        if (!hgt.isEmpty())
            return (hgt.contains("cm") ? (Integer.parseInt(hgt.split("cm")[0]) >= 150 && Integer.parseInt(hgt.split("cm")[0]) <= 193) : (Integer.parseInt(hgt.split("in")[0]) >= 59 && Integer.parseInt(hgt.split("in")[0]) <= 76));
        return false;
    }

    private boolean validHCL() {
        if (!hcl.isEmpty()) {
            Pattern pattern = Pattern.compile("(#[0-9]*[a-f]*)");
            Matcher matcher = pattern.matcher(hcl);
            return (hcl.charAt(0) == '#' && matcher.find() && hcl.length() == 7);
        } else return false;
    }

    private boolean validECL() {
        if (!ecl.isEmpty())
            return (ecl.equals("amb") || ecl.equals("blu") || ecl.equals("brn") || ecl.equals("gry") || ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth"));
        else return false;
    }

    private boolean validPID() {
        if (Checking.checkIfStringNumbers(pid))
            return (pid.length() == 9);
        else return false;
    }
}
