import java.io.File;
import java.util.Scanner;

public class DayThree {

    public static void main(String[] args) {
        partOne("day3");
        partTwo("day3");
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
                position += slope;
            }
            System.out.println(treeCount);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static int countTrees(String filename, int rslope, int dslope) {

        try {
            Scanner file = new Scanner(new File(filename));
            int position = rslope;
            int treeCount = 0;
            int downSlope = dslope;
            String row = file.nextLine();
            while(file.hasNextLine()) {
                while(--downSlope > 0) row = file.nextLine();
                row = file.nextLine();
                if(position >= row.length()) position -= row.length();
                if(row.charAt(position) == '#') {
                    treeCount++;
                }
                position += rslope;
                downSlope = dslope;

            }
            return treeCount;
        } catch (Exception e) {
            System.out.println(e);
        }
        return 0;
    }

    public static void partTwo(String filename) {
        int totalTrees = 1;
        totalTrees *= countTrees(filename, 1, 1);
        System.out.println(countTrees(filename, 1, 1));
        totalTrees *= countTrees(filename, 3, 1);
        System.out.println(countTrees(filename, 3, 1));
        totalTrees *= countTrees(filename, 5, 1);
        System.out.println(countTrees(filename, 5, 1));
        totalTrees *= countTrees(filename, 7,1);
        System.out.println(countTrees(filename, 7, 1));
        totalTrees *= countTrees(filename, 1, 2);
        System.out.println(countTrees(filename, 1, 2));
        System.out.println("Total trees: " + totalTrees);

    }
}