import java.io.File;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DayFour {

    public static void main(String[] args) {
        String filename = "day4";

        for(String a : buildString(filename))
            System.out.println(a);

        partOne(buildString(filename));
        partTwo(buildString(filename));

    }

    public static ArrayList<Passport> buildPassports(ArrayList<String> passports) {
        ArrayList<Passport> toReturn = new ArrayList<>();
        for(String s : passports) {
            int byr = -1, iyr = -1, eyr = -1;
            String hgt ="MISSING", hcl ="MISSING", ecl="MISSING", pid="MISSING", cid="MISSING";
            String[] split = s.split("\\s+");
            for(String t : split) {
                switch(t.substring(0, 3)){
                    case "byr":
                        byr = Integer.parseInt(t.substring(4));
                        break;
                    case "iyr":
                        iyr = Integer.parseInt(t.substring(4));
                        break;
                    case "eyr":
                        eyr = Integer.parseInt(t.substring(4));
                        break;
                    case "hgt":
                        hgt = t.substring(4);
                        break;
                    case "hcl":
                        hcl = t.substring(4);
                        break;
                    case "ecl":
                        ecl = t.substring(4);
                        break;
                    case "pid":
                        pid = t.substring(4);
                        break;
                    case "cid":
                        cid = t.substring(4);
                        break;
                    default:
                        break;
                }
            }
            toReturn.add(new Passport(byr, iyr, eyr, hgt, hcl, ecl, pid, cid));
        }


        return toReturn;
    }





    public static void partOne(ArrayList<String> passports) {
        int count = 0;
        for(String s : passports){
            if(s.contains("byr:") && s.contains("iyr:") && s.contains("eyr:") && s.contains("hgt:")
                && s.contains("hcl:") && s.contains("ecl") && s.contains("pid:")) count++;
        }
        System.out.println("Valid passports: " + count);
    }
    public static void partTwo(ArrayList<String> passports) {
        int count = 0;
        ArrayList<Passport> ourPassports = buildPassports(passports);
        for(Passport p : ourPassports) {
            if(p.validatePassport()) count++;
        }
        System.out.println("Valid Passports Part2: " + count);
    }


    public static ArrayList<String> buildString(String filename) {
        ArrayList<String> toReturn = new ArrayList<>();
        StringBuilder ourString = new StringBuilder();
        try {
            Scanner file = new Scanner(new File(filename));
            while(file.hasNext()) {
                String yay = file.nextLine();
                if(!yay.isBlank()) {
                    ourString.append(yay.trim());
                    ourString.append(" ");
                }
                else {
                    toReturn.add(ourString.toString().trim());
                    ourString = new StringBuilder();
                }
            }
            toReturn.add(ourString.toString().trim());
        } catch(Exception e) {
            System.out.println(e);
        }

        return toReturn;
    }


    static class Passport {
        int byr, iyr, eyr;
        String hgt, hcl, ecl, pid, cid;

        public Passport(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, String pid, String cid) {
            this.byr = byr;
            this.iyr = iyr;
            this.eyr = eyr;
            this.hgt = hgt;
            this.hcl = hcl;
            this.ecl = ecl;
            this.pid = pid;
            this.cid = cid;
        }
        public Passport(int byr, int iyr, int eyr, String hgt, String hcl, String ecl, String pid) {
            this.byr = byr;
            this.iyr = iyr;
            this.eyr = eyr;
            this.hgt = hgt;
            this.hcl = hcl;
            this.ecl = ecl;
            this.pid = pid;
            this.cid = "North Pole";
        }

        boolean validateByr() {
            return byr > 1000 && (byr >= 1920) && byr <= 2002;
        }
        boolean validateIyr() {
            return iyr >= 2010 && iyr <= 2020;
        }
        boolean validateEyr() {
            return eyr >=2020 && eyr <= 2030;
        }
        boolean validateHgt() {
            if(hgt.equals("MISSING")) return false;
            String unit = hgt.substring(hgt.length()-2);
            if(!(unit.equals("cm") || unit.equals("in"))) return false;
            int value = Integer.parseInt(hgt.substring(0, hgt.indexOf(unit)));
            if(unit.equals("cm")) {
                return value >= 150 && value <= 193;
            } else if(unit.equals("in")) {
                return value >= 59 && value <= 76;
            } else {
                return false;
            }
        }
        boolean validateHcl() {
            String hash = hcl.substring(0,1);
            String value = hcl.substring(1);
            if(hash.equals("#")) {
                for(char a : value.toCharArray())
                {
                    if(!((a >= '0' && a <= '9') || (a >='a' && a <= 'f')))
                    {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        boolean validateEcl() {
            return ecl.equals("amb") || ecl.equals("blu") || ecl.equals("gry") ||
                    ecl.equals("grn") || ecl.equals("hzl") || ecl.equals("oth") || ecl.equals("brn");
        }
        boolean validatePid() {
            if(pid.length() == 9) {
                for (char a : pid.toCharArray()) {
                    if (!Character.isDigit(a)) {
                        return false;
                    }
                }
                return true;
            }
            return false;
        }
        boolean validateCid() { return true; }
        boolean validatePassport() {
            return validateByr() && validateIyr() && validateEyr() && validateHgt() &&
                    validateHcl() && validateEcl() && validatePid() && validateCid();
        }
    }

}
