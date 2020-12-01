import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Helper {

    public Helper(){}

    public static ArrayList<Integer> returnInts(String fileName) {
        ArrayList list = new ArrayList<Integer>();

        try {
            Scanner file = new Scanner(new File(fileName));
            while(file.hasNextInt()) {
                list.add(file.nextInt());
            }
        } catch (Exception e) {
            System.out.println(e);
        }

        return list;
    }
}
