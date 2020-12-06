import java.util.ArrayList;
import java.util.Collections;

public class DayFive {
    public static void main(String[] args) {
        String filename = "day5";


        partOne(filename);
        partTwo(filename);

        tester("day5samp");

    }

    public static void tester(String filename) {
        ArrayList<String> ourPasses = Helper.returnStrings(filename);
        StringBuilder aString = new StringBuilder();
        for(String aPass: ourPasses) {
            aString.append("["+aPass+"]: ");
            aString.append("row: " + findRow(aPass)+", ");
            aString.append("column: "+findColumn(aPass)+", ");
            aString.append("Seat ID: " + findSeatId(aPass));
            aString.append("\r\n");
        }
        System.out.println(aString.toString());
    }

    public static void partOne(String filename) {
        ArrayList<String> ourPasses = Helper.returnStrings(filename);
        int currentHighest = Integer.MIN_VALUE;
        for(String pass : ourPasses) {
            if(findSeatId(pass) > currentHighest)
                currentHighest = findSeatId(pass);
        }
        System.out.println("The highest seat value is: " + currentHighest);
    }

    public static void partTwo(String filename) {
        ArrayList<String> ourPasses = Helper.returnStrings(filename);
        ArrayList<Integer> ourSeatIds = new ArrayList<>();
        ourPasses.forEach(aPass -> {
            ourSeatIds.add(findSeatId(aPass));
        });
        Collections.sort(ourSeatIds);
        System.out.println(ourSeatIds);
        for(Integer ourId : ourSeatIds)
            if(!ourSeatIds.contains(ourId+1))
            {
                System.out.println("Our seat ID is: " + (ourId+1));
                return;
            }
    }

    public static int findRow(String aPass) {
        String rowFinder = aPass.substring(0, 7);
        int minRow = 0;
        int maxRow = 127;
        for(char h : rowFinder.toCharArray()) {
            if (h == 'F') maxRow -= (int)Math.ceil((maxRow-minRow) / 2f);
            if (h == 'B') minRow += (int)Math.ceil((maxRow - minRow) / 2f);

        }


        return aPass.charAt(7) == 'F' ? minRow : maxRow;
    }
    public static int findColumn(String aPass) {
        String columnFinder = aPass.substring(7, 10);
        int minCol = 0;
        int maxCol = 7;
        for(char h : columnFinder.toCharArray()) {
            if (h == 'L') maxCol -= (int)Math.ceil((maxCol-minCol) / 2f);
            if (h == 'R') minCol += (int)Math.ceil((maxCol - minCol) / 2f);
        }
        return aPass.charAt(9) == 'L' ? minCol : maxCol;
    }
    public static int findSeatId(String aPass) {
        return findRow(aPass) * 8 + findColumn(aPass);
    }
}
