import java.io.File;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) {
        partOne("day3");
        partTwo("day3", 1, 1);
    }

    public static void partOne(String filename) {
        int slope = 3;
        try {
            Scanner file = new Scanner(new File(filename));
            int position = 3;
            int treeCount = 0;
            String row = file.nextLine();
            while(file.hasNextLine()) {
                row = file.nextLine();
                if(position >= row.length()) position -= row.length();
                if(row.charAt(position) == '#') {
                    treeCount++;
                }
                System.out.println(row + (row.charAt(position % row.length()) == '#' ? "" : " no") + " Tree encountered. Tree Count: " + treeCount + " " + position);
                position += slope;
            }
            System.out.println(treeCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void partTwo(String filename, int rslope, int dslope) {

        try {
            Scanner file = new Scanner(new File(filename));
            int position = rslope;
            int treeCount = 0;
            int downSlope = dslope;
            String row = file.nextLine();
            while(file.hasNextLine()) {
                row = file.nextLine();
                if(position >= row.length()) position -= row.length();
                if(row.charAt(position) == '#') {
                    treeCount++;
                }
                System.out.println(row + (row.charAt(position % row.length()) == '#' ? "" : " no") + " Tree encountered. Tree Count: " + treeCount + " " + position);
                position += rslope;
                while(--downSlope > 0) row = file.nextLine();
            }
            System.out.println(treeCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
