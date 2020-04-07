package HackerRankTests;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static java.util.stream.Collectors.toList;

class Result {
    public static int pickingNumbers(List<Integer> a) {
        int result = 0;
        Map<Integer, Integer> inputMap = new HashMap<>();
        for (int elem : a) {
            inputMap.merge(elem, 1, Integer::sum);
        }
        for (int i = 2; i < a.size(); i++) {
            int currentIndexVal = inputMap.get(i) != null ? inputMap.get(i) : 0;
            int prevIndexVal = inputMap.get(i - 1) != null ? inputMap.get(i - 1) : 0;
            result = Math.max(result, (currentIndexVal + prevIndexVal));
        }
        return result;
    }
}

public class PickingNumbers {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> a = Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                .map(Integer::parseInt)
                .collect(toList());

        int result = Result.pickingNumbers(a);
        System.out.println(result);

        bufferedReader.close();
    }
}

