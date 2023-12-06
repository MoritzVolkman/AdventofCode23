import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.lang.String;

public class Day6 {
    public int part1() throws Exception{
        int[][] values = parse();
        int[] results = new int[4];
        int result = 0;
        int i = 0;
        for(int race: values[0]){
            ArrayList<Integer> solutions = new ArrayList<Integer>();
            for(int speed = 0; speed <= race; speed++){
                if(speed*(race-speed) >= values[1][i]){
                    solutions.add(speed);
                }
            }
            results[i] += solutions.size();
            i++;
        }
        result = results[0];
        for(int j = 1; j < 4; j++){
            result *= results[j];
        }
        return result;
    }

    public int part2() throws Exception{
        File input = new File("Inputs\\day6.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String timeStr = br.readLine();
        String distanceStr = br.readLine();
        long time = 0;
        long distance = 0;
        int possibilities = 0;
        time = Long.valueOf(timeStr.replaceAll("[A-Za-z:\\s]+",""));
        distance = Long.valueOf(distanceStr.replaceAll("[A-Za-z:\\s]+",""));
        for(long speed = 0; speed <= time; speed++){
            if(speed*(time-speed) >= distance){
                possibilities++;
            }
        }
        return possibilities;
    }

    private int[][] parse() throws Exception{
        File input = new File("Inputs\\day6.txt");
        BufferedReader br = new BufferedReader(new FileReader(input));
        String timeStr = br.readLine();
        String distanceStr = br.readLine();
        int[][] timeDistance = new int[2][4];
        Pattern pattern = Pattern.compile("[\\d]+");
        Matcher matcher1 = pattern.matcher(timeStr);
        Matcher matcher2 = pattern.matcher(distanceStr);
        int i = 0;
        while(matcher1.find()){
            timeDistance[0][i] = Integer.valueOf(matcher1.group());
            i++;
        }
        i = 0;
        while(matcher2.find()){
            timeDistance[1][i] = Integer.valueOf(matcher2.group());
            i++;
        }
        return timeDistance;
    }
}
