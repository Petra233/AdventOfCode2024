import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Day1test {
    public static void main(String[] args) {

        List<Integer>left = new ArrayList<>(Arrays.asList(3,4,2,1,3,3));
        List<Integer>right = new ArrayList<>(Arrays.asList(4,3,5,3,9,3));
        List<Integer> diff = new ArrayList<>();

        Collections.sort(left);
        Collections.sort(right);

        for (int i = 0; i < left.size(); i++) {
            int difference = Math.abs(left.get(i) - right.get(i));
            diff.add(difference);
        }

        int totalDiff = 0;
        for(Integer i : diff) {
            totalDiff += i;
        }
        System.out.println(totalDiff);

    }
}