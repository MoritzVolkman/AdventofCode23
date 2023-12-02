import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class Day2 {
    public int part1() throws Exception{
        String st;
        int sum = 0;
        List<Integer> ids = new ArrayList<Integer>();
        File input = new File("Inputs\\day2.txt");
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        Pattern pattern1 = Pattern.compile("Game [0-9][0-9]*");
        Pattern pattern2 = Pattern.compile("[0-9][0-9]* [(red)|(green)|(blue)]");
        while((st = br.readLine()) != null){
            //System.out.println(st);
            String st1 = st;
            int id = 0;
            Matcher matcher = pattern1.matcher(st);
            Matcher matcher2 = pattern2.matcher(st1);
            List<Integer> red = new ArrayList<Integer>();
            List<Integer> green = new ArrayList<Integer>();
            List<Integer> blue = new ArrayList<Integer>();
            if (matcher.find()) {
                id = Integer.valueOf(matcher.group().replace("Game ", ""));

                while (matcher2.find()) {
                    String temp = matcher2.group();
                    if (temp.contains("r")) {
                        temp = temp.replace(" r", "");
                        red.add(Integer.valueOf(temp));
                    } else if (temp.contains("g")) {
                        temp = temp.replace(" g", "");
                        green.add(Integer.valueOf(temp));
                    } else if (temp.contains("b")) {
                        temp = temp.replace(" b", "");
                        blue.add(Integer.valueOf(temp));
                    }

                }
                int maxRed = Collections.max(red);
                int maxGreen = Collections.max(green);
                int maxBlue = Collections.max(blue);
                //System.out.println("ID: " + id + " Max R:" + maxRed + " Max G: " + maxGreen + " Max B: " + maxBlue);
                if (maxRed <= 12 && maxGreen <= 13 && maxBlue <= 14) {
                    sum += id;
                }
            }
        }
        return sum;
    }

    public int part2() throws Exception{
        String st;
        int sum = 0;
        List<Integer> ids = new ArrayList<Integer>();
        File input = new File("Inputs\\day2.txt");
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        Pattern pattern1 = Pattern.compile("Game [0-9][0-9]*");
        Pattern pattern2 = Pattern.compile("[0-9][0-9]* [(red)|(green)|(blue)]");
        while((st = br.readLine()) != null){
            //System.out.println(st);
            String st1 = st;
            int id = 0;
            Matcher matcher = pattern1.matcher(st);
            Matcher matcher2 = pattern2.matcher(st1);
            List<Integer> red = new ArrayList<Integer>();
            List<Integer> green = new ArrayList<Integer>();
            List<Integer> blue = new ArrayList<Integer>();
            if (matcher.find()) {
                id = Integer.valueOf(matcher.group().replace("Game ", ""));

                while (matcher2.find()) {
                    String temp = matcher2.group();
                    if (temp.contains("r")) {
                        temp = temp.replace(" r", "");
                        red.add(Integer.valueOf(temp));
                    } else if (temp.contains("g")) {
                        temp = temp.replace(" g", "");
                        green.add(Integer.valueOf(temp));
                    } else if (temp.contains("b")) {
                        temp = temp.replace(" b", "");
                        blue.add(Integer.valueOf(temp));
                    }

                }
                int maxRed = Collections.max(red);
                int maxGreen = Collections.max(green);
                int maxBlue = Collections.max(blue);
                //System.out.println("ID: " + id + " Max R:" + maxRed + " Max G: " + maxGreen + " Max B: " + maxBlue);
                int power = maxBlue * maxRed * maxGreen;
                sum += power;
            }
        }
        return sum;
    }
}
