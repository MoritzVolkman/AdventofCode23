import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;

public class Day1 {
    public int part1() throws Exception{
        //st is the line that is read from the buffer, sum is the overall sum of calib. values
        String st;
        int sum = 0;

        //reads the input text file for day 1
        File input = new File("Inputs\\day1.txt");
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        //for each line in the text file
        while ((st = br.readLine()) != null)
        {
            //creates the temp values for the calibration value
            int val = 0;
            String tempNum = "";
            // Print the string
            // System.out.println(st);
            for (char ch: st.toCharArray()){
                if(Character.isDigit(ch)){
                    // System.out.println(ch);
                    tempNum += ch;
                    break;
                }
            }
            StringBuilder input1 = new StringBuilder();
            input1.append(st);
            input1.reverse();
            String st1 = input1.toString();
            for (char ch: st1.toCharArray()){
                if(Character.isDigit(ch)){
                    // System.out.println(ch);
                    tempNum += ch;
                    break;
                }
            }
            val = Integer.parseInt(tempNum);
            sum += val;
        }
        //System.out.println("The sum of all calibration values is: " + sum);
        return(sum);
    }
    public int part2() throws Exception{
        String[] digits = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};
        String[] digitsRev = new String[9];
        //reverses the digits string
        for (int i = 0; i < digits.length; i++) {
            digitsRev[i] = new StringBuilder(digits[i]).reverse().toString();
        }
        //st is the line that is read from the buffer, sum is the overall sum of calib. values
        String st;
        int sum = 0;
        //reads the input text file for day 1
        File input = new File("Inputs\\day1.txt");
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        //for each line in the text file
        while ((st = br.readLine()) != null)
        {
            //creates the temp values for the calibration value
            int val = 0;
            String tempNum = "";
            String tempStr = "";
            // Print the string
            //System.out.println(st);
            loop1:
            for (char ch: st.toCharArray()){
                if(!Character.isDigit(ch)){
                    tempStr += ch;
                    for (int i = 0; i < digits.length; i++) {
                        if (tempStr.contains(digits[i])) {
                            //System.out.println(tempStr);
                            tempNum += (i + 1);
                            break loop1;
                        }
                    }
                } else {
                    //System.out.println(ch);
                    tempNum += ch;
                    break;
                }
            }
            //reverses the input String
            StringBuilder input1 = new StringBuilder();
            input1.append(st);
            input1.reverse();
            String st1 = input1.toString();
            tempStr = "";
            first:
            for (char ch: st1.toCharArray()){
                if(!Character.isDigit(ch)){
                    tempStr += ch;
                    for (int i = 0; i < digitsRev.length; i++) {
                        if (tempStr.contains(digitsRev[i])) {
                            //System.out.println(tempStr);
                            tempNum += (i + 1);
                            break first;
                        }
                    }
                } else {
                    //System.out.println(ch);
                    tempNum += ch;
                    break;
                }
            }
            //System.out.println("Value: " + tempNum);
            val = Integer.parseInt(tempNum);
            sum += val;
        }
        //System.out.println("The sum of all calibration values is: " + sum);
        return(sum);
    }
}
