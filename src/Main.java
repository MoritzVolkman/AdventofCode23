import java.io.*;
import java.util.*;
import java.lang.*;


public class Main {
    public static void main(String[] args) throws Exception {
        Day1 day1 = new Day1();
        Day2 day2 = new Day2();
        Day3 day3 = new Day3();
        Day4 day4 = new Day4();
        Day6 day6 = new Day6();
        System.out.println("Value for Day 1 part 1: " + day1.part1());
        System.out.println("Value for Day 1 part 2: " + day1.part2());
        System.out.println("Value for Day 2 part 1: " + day2.part1());
        System.out.println("Value for Day 2 part 2: " + day2.part2());
        System.out.println("Value for Day 3 part 1: " + day3.part1());
        System.out.println("Value for Day 3 part 2: " + day3.part2());
        System.out.println("Value for Day 4 part 1: " + day4.part1());
        System.out.println("Value for Day 4 part 2: " + day4.part2());
        System.out.println("Value for Day 6 part 1: " + day6.part1());
        System.out.println("Value for Day 6 part 2: " + day6.part2());
    }
}