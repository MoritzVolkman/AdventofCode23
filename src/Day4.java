import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.Math;

public class Day4 {
    public int part1() throws Exception{
        return parse(false);
    }

    public int part2() throws Exception{
        return parse(true);
    }
    private int parse(boolean part2) throws Exception{
        String st;
        int i = 0;
        int j = 0;
        int[][] winningNumbers = new int[218][10];
        int[][] myNumbers = new int[218][25];
        File input = new File("Inputs\\day4.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        while((st = br.readLine()) != null){
            String[] divided = st.split("\\|");
            Pattern pattern1 = Pattern.compile("(?![0-9][0-9]*[:])([0-9][0-9]*)");
            Pattern pattern2 = Pattern.compile("[0-9][0-9]*");
            Matcher matcher1 = pattern1.matcher(divided[0]);
            Matcher matcher2 = pattern2.matcher(divided[1]);
            while(matcher1.find()){
                winningNumbers[i][j] = Integer.valueOf(matcher1.group());
                j++;
            }
            j = 0;
            while(matcher2.find()){
                myNumbers[i][j] = Integer.valueOf(matcher2.group());
                j++;
            }
            j = 0;
            i++;
        }
        return evaluate(winningNumbers, myNumbers, part2);
    }

    private int evaluate(int[][] win, int[][] my, boolean part2) throws Exception{
        int[] points = new int[218];
        int[] copies = new int[218];
        Arrays.fill(copies, 1);
        int correctNumbers = 0;
        int sum = 0;
        int copiesTotal = 0;
        for(int game = 0; game < win.length; game++){
            for(int number: my[game]) {
                Arrays.parallelSort(win[game]);
                if (Arrays.binarySearch(win[game],number) >= 0) {
                    correctNumbers++;
                }
            }
            if (part2){
                for (int i = 1; i <= correctNumbers; i++){
                    if (game+i < copies.length) copies[game+i] += copies[game];
                }
            }
            double exp = correctNumbers;
            if (correctNumbers > 0) points[game] = (int)Math.pow(2, exp-1);
            correctNumbers = 0;
        }
        for(int card = 0; card < points.length; card++){
            sum += points[card]*copies[card];
            copiesTotal += copies[card];
        }
        if (!part2){
            return sum;
        }
        else{
            return copiesTotal;
        }
    }
}
