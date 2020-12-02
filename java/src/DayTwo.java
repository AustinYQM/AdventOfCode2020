import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class DayTwo {

    public static void main(String[] args) {
        partOne("day2");
        partTwo("day2");
    }

    public static void partOne(String fileName)  {
        System.out.println("::::: Part One :::::");
        int passCount = 0;
        try {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNextLine()) {
                String line = file.nextLine();
                int min = buildMin(line);
                int max = buildMax(line);
                char letter = buildChar(line);
                String pass = buildString(line);
                int count = letterCount(pass, letter);
                boolean correct = countInRange(min, max, count);
                System.out.println(letter + " appears " + count + " times which is "+
                        (correct ? "inside" : "outside") + " the range of " + min + "..." + max);
                if(correct) passCount++;
            }
            System.out.println("Total number of correct passwords: " + passCount);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void partTwo(String fileName) {
        System.out.println("::::: Part Two :::::");
        int passCount = 0;
        try {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNextLine()) {
                String line = file.nextLine();
                int pos1 = buildMin(line);
                int pos2 = buildMax(line);
                char letter = buildChar(line);
                String pass = buildString(line);
                boolean correct = checkPass(pass, pos1, pos2, letter);
                System.out.println("Target letter (" + letter + ") " + (correct ? "was" : "wasn't") + " found at exactly one of the given (" +
                        pos1 + ", " + pos2 + ") positions in the password " + pass + ". Password is " + (correct ? "valid" : "invalid") + ".");
                if(correct) passCount++;
            }
            System.out.println("Total number of correct passwords: " + passCount);
            System.out.println();
        } catch (Exception e) {
            System.out.println(e);
        }
    }


    public static int letterCount(String pass, char letter) {
        int ourReturn = 0;
        for(char a : pass.toCharArray()) {
            if( a == letter ) ourReturn++;
        }
        return ourReturn;
    }

    public static boolean countInRange(int min, int max, int count) {
        return (count >= min) && (count <= max);
    }

    public static int buildMin(String line) {
        return Integer.parseInt(line.substring(0, line.indexOf('-')));
    }
    public static int buildMax(String line) {
        return Integer.parseInt(line.substring(line.indexOf('-')+1, line.indexOf(' ')));
    }
    public static char buildChar(String line) {
        int index = 0;
        char returnChar = ' ';
        while(line.toCharArray()[index++] != ':') returnChar = line.toCharArray()[index-1];
        return returnChar;
    }
    public static String buildString(String line) {
        return line.substring(line.indexOf(' ', line.indexOf(' ')+1)+1);
    }
    public static boolean checkPass(String pass, int pos1, int pos2, char letter) {
        return (pass.charAt(pos1-1) == letter) ^ (pass.charAt(pos2-1) == letter);
    }
}
