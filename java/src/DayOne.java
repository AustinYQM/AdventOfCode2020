import java.util.ArrayList;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = Helper.returnInts("day1");

        PartOne(expenses);

        PartTwo(expenses);
    }

    private static void PartTwo(ArrayList<Integer> expenses) {
        System.out.println("::::: Part Two :::::");
        for(Integer a : expenses) {
            for(Integer b : expenses) {
                for(Integer c: expenses) {
                    if(a + b + c == 2020) {
                        System.out.println("Number 1: " + a);
                        System.out.println("Number 2: " + b);
                        System.out.println("Number 3: " + c);
                        System.out.println("Answer: " + (a*b*c));
                        System.out.println("");
                        return;
                    }
                }
            }
        }
    }

    public static void PartOne(ArrayList<Integer> expenses){
        System.out.println("::::: Part One :::::");
        for(Integer a : expenses) {
            for(Integer b : expenses) {
                if(a + b == 2020) {
                    System.out.println("Number 1: " + a);
                    System.out.println("Number 2: " + b);
                    System.out.println("Answer: " + (a*b));
                    System.out.println();
                    return;
                }
            }
        }
    }
}
