package day04;

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

    boolean validate(){
        return (byr!=null && iyr!=null && eyr!=null && hgt!=null && hcl!=null && ecl!=null && pid!=null);
    }
}
