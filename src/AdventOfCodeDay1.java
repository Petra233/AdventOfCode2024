import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AdventOfCodeDay1 {
    public static void main(String[] args) throws IOException {

        String fileName = "C:/Javamapp/AdventOfCodeDay1.txt";
        List<Integer> numbersOnLeftSide = new ArrayList<>();
        List<Integer> numbersOnRightSide = new ArrayList<>();
        List<Integer> difference = new ArrayList<>();

        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line;
        while ((line = reader.readLine()) !=null) {
            String[] numbersInFile = line.trim().split(" {3}");

            if (numbersInFile.length == 2) {
                int number1 = Integer.parseInt(numbersInFile[0]);
                int number2 = Integer.parseInt(numbersInFile[1]);

                numbersOnLeftSide.add(number1);
                numbersOnRightSide.add(number2);
            }
        }
        reader.close();


        Collections.sort(numbersOnLeftSide);
        Collections.sort(numbersOnRightSide);


        for (int i = 0; i < numbersOnLeftSide.size(); i++) {
              int differenceSum = Math.abs(numbersOnLeftSide.get(i) - numbersOnRightSide.get(i));
              difference.add(differenceSum);
        }

         int totalDiff = 0;
          for(Integer i : difference) {
          totalDiff += i;
    }
        System.out.println(totalDiff);

        int result = 0;
        for (int i = 0; i < numbersOnLeftSide.size(); i++) {
        int currentNumberCheck = numbersOnLeftSide.get(i);
        //System.out.println(currentNumberCheck);
        int rightNum = 0;
        for (Integer integer : numbersOnRightSide) {
            if (integer == currentNumberCheck) {
                rightNum++;
            }
        }
        result += currentNumberCheck * rightNum;

    }
        System.out.println(result);
}
}
