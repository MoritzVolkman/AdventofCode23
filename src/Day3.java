import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.lang.Character;


public class Day3 {
    public int part1() throws Exception{
        File input = new File("Inputs\\day3.txt");
        String st;
        int i = 0;
        int j = 0;
        int sum = 0;
        boolean[][] symbols = new boolean[150][150];
        char[][] data = new char[150][150];
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        while((st = br.readLine()) != null){
                for (char ch : st.toCharArray()) {
                    data[i][j] = ch;
                    if(ch != '.' && !Character.isDigit(ch)) {
                        symbols[i][j] = true;
                    }
                    if (j <= st.length()) {
                        j += 1;
                    }
                }
            j = 0;
            i += 1;
            }
        return findValues(data, symbols);
    }

    public int part2() throws Exception{
        File input = new File("Inputs\\day3.txt");
        String st;
        int i = 0;
        int j = 0;
        int sum = 0;
        boolean[][] symbols = new boolean[150][150];
        char[][] data = new char[150][150];
        //creates a buffered Reader that reads one line at a time
        BufferedReader br = new BufferedReader(new FileReader(input));
        while((st = br.readLine()) != null){
            for (char ch : st.toCharArray()) {
                data[i][j] = ch;
                if(ch == '*') {
                    symbols[i][j] = true;
                }
                if (j <= st.length()) {
                    j += 1;
                }
            }
            j = 0;
            i += 1;
        }
        return findValues2(data, symbols);
    }
    public int findValues(char[][] data, boolean[][] symbols) throws Exception{
        int sum = 0;
        for (int i = 0; i < data[0].length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(symbols[i][j]) {
                    for (int i1 = i - 1; i1 <= i + 1; i1++) {
                        for (int j1 = j - 1; j1 <= j + 1; j1++) {
                            String tempnum = "";
                            if (Character.isDigit(data[i1][j1])) {
                                int j2 = j1;
                                while (Character.isDigit(data[i1][j2])) {
                                    tempnum = data[i1][j2] + tempnum;
                                    data[i1][j2] = '.';
                                    if (j2 > 0) {
                                        j2--;
                                    } else break;
                                }
                                j2 = j1 + 1;
                                while (Character.isDigit(data[i1][j2])) {
                                    tempnum = tempnum + data[i1][j2];
                                    data[i1][j2] = '.';
                                    j2++;
                                }
                                //System.out.println(tempnum);
                                sum += Integer.valueOf(tempnum);

                            }
                        }
                    }
                }
            }
        }
        return sum;
    }

    public int findValues2(char[][] data, boolean[][] symbols) throws Exception{
        int sum = 0;
        for (int i = 0; i < data[0].length; i++) {
            for (int j = 0; j < data.length; j++) {
                if(symbols[i][j]) {
                    ArrayList<String> tempnums = new ArrayList<String>();
                    for (int i1 = i - 1; i1 <= i + 1; i1++) {
                        for (int j1 = j - 1; j1 <= j + 1; j1++) {
                            String tempnum = "";
                            if (Character.isDigit(data[i1][j1])) {
                                int j2 = j1;
                                while (Character.isDigit(data[i1][j2])) {
                                    tempnum = data[i1][j2] + tempnum;
                                    data[i1][j2] = '.';
                                    if (j2 > 0) {
                                        j2--;
                                    } else break;
                                }
                                j2 = j1 + 1;
                                while (Character.isDigit(data[i1][j2])) {
                                    tempnum = tempnum + data[i1][j2];
                                    data[i1][j2] = '.';
                                    j2++;
                                }
                                //System.out.println(tempnum);
                                tempnums.add(tempnum);
                            }
                        }
                    }
                    if(tempnums.size() == 2) {
                        int multi = Integer.valueOf(tempnums.get(0)) * Integer.valueOf(tempnums.get(1));
                        //System.out.println(multi);
                        sum += multi;
                    }
                }
            }
        }
        return sum;
    }
}
