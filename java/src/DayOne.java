import java.util.ArrayList;

public class DayOne {
    public static void main(String[] args) {
        ArrayList<Integer> expenses = Helper.returnInts("day1");

        partOne(expenses);
        partOneAdvanced(expenses);
        partTwo(expenses);
        partTwoAdvanced(expenses);
    }

    public static void partOne(ArrayList<Integer> expenses){
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

    private static void partTwo(ArrayList<Integer> expenses) {
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

    public static void partOneAdvanced(ArrayList<Integer> expenses) {
        System.out.println("::::: Part One Adv. :::::");
        for(Integer a : expenses ) {
            if(expenses.contains(2020 - a)) {
                int b = 2020 - a;
                System.out.println("Number 1: " + a);
                System.out.println("Number 2: " + b);
                System.out.println("Answer: " + (a*b));
                System.out.println();
                return;
            }
        }
    }

    private static void partTwoAdvanced(ArrayList<Integer> expenses) {
        System.out.println("::::: Part Two Adv. :::::");
        for(Integer a : expenses) {
            for(Integer b : expenses) {
                if(expenses.contains(2020 - a - b)) {
                    int c = 2020 - (a + b);
                    if (a + b + c == 2020) {
                        System.out.println("Number 1: " + a);
                        System.out.println("Number 2: " + b);
                        System.out.println("Number 3: " + c);
                        System.out.println("Answer: " + (a * b * c));
                        System.out.println("");
                        return;
                    }
                }
            }
        }
    }
}
