import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class AdventOfCodeDay2 {
    List<int[]> rows;

    public AdventOfCodeDay2() throws IOException {

        String file = "C:/Javamapp/AdventOfCodeDay2.txt";
        rows = new ArrayList<>();

        BufferedReader br = new BufferedReader(new FileReader(file));
        String line;
        while ((line = br.readLine()) != null) {
            String[] numbersInLine = line.split(" ");
            int[] rowValues = new int[numbersInLine.length];
            for (int i = 0; i < numbersInLine.length; i++) {
                rowValues[i] = Integer.parseInt(numbersInLine[i]);
            }
            rows.add(rowValues);

        }
        br.close();
    }

    public void checkSafeReport() {
        int localSafeReport = checkNumberDifference();
        System.out.println(localSafeReport + " reports are safe!!!");
    }

    public int checkNumberDifference() {

        int SafeReport = 0;

        for (int[] row : rows) {
            boolean threeOrLess = true;
            boolean hasIncrease = false;
            boolean hasDecrease = false;

            for (int num : row)
                for (int i = 0; i < row.length - 1; i++) {
                    int diff = Math.abs(row[i] - row[i + 1]);

                    if (diff >= 4 || diff <= 0) {
                        threeOrLess = false;
                        break;
                    }

                    if (row[i] < row[i + 1]) {
                        hasIncrease = true;
                    }
                    if (row[i] > row[i + 1]) {
                        hasDecrease = true;
                    }

                    if (hasIncrease && hasDecrease) {
                        threeOrLess = false;
                        break;
                    }
                }

            if (threeOrLess) {
                SafeReport++;

                }
            }

        return SafeReport;
    }

    public static void main(String[] args) throws IOException {
        AdventOfCodeDay2 test = new AdventOfCodeDay2();
        test.checkSafeReport();
    }
}