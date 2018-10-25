package HackerRankTests;

import java.io.IOException;
import java.util.*;
import java.util.stream.IntStream;

public class FrequencyQuery {
    // Complete the freqQuery function below.
    static List<Integer> freqQuery(List<List<Integer>> queries) {
        Map<Integer, Integer> freqMap = new HashMap<>();
        List<Integer> outputList = new ArrayList<>();
        for (List<Integer> query : queries) {
            int operation = query.get(0);
            int value = query.get(1);
            if (operation == 1) {
                if (freqMap.get(value) != null) {
                    int existingValue = freqMap.get(value);
                    freqMap.put(value, ++existingValue);
                } else {
                    freqMap.put(value, 1);
                }
            } else if (operation == 2) {
                freqMap.remove(value);
            } else if (operation == 3) {
                Optional<Map.Entry<Integer, Integer>> filteredMap = freqMap.entrySet().stream()
                        .filter(x -> x.getValue() == value)
                        .findAny();
                if (filteredMap.isPresent())
                    outputList.add(1);
                else
                    outputList.add(0);
            }
        }

        return outputList;

    }

    public static void main(String[] args) {
        List<List<Integer>> queries = new ArrayList<>();
        List<Integer> queryOne = new ArrayList<>();
        queryOne.add(1);
        queryOne.add(3);

        List<Integer> queryTwo = new ArrayList<>();
        queryTwo.add(2);
        queryTwo.add(3);

        List<Integer> queryThree = new ArrayList<>();
        queryThree.add(3);
        queryThree.add(2);

        List<Integer> queryFour = new ArrayList<>();
        queryFour.add(1);
        queryFour.add(4);

        List<Integer> queryFive = new ArrayList<>();
        queryFive.add(1);
        queryFive.add(5);

        List<Integer> querySix = new ArrayList<>();
        querySix.add(1);
        querySix.add(5);

        List<Integer> querySeven = new ArrayList<>();
        querySeven.add(1);
        querySeven.add(4);

        List<Integer> queryEight = new ArrayList<>();
        queryEight.add(3);
        queryEight.add(2);

        queries.add(queryOne);
        queries.add(queryTwo);
        queries.add(queryThree);
        queries.add(queryFour);
        queries.add(queryFive);
        queries.add(querySix);
        queries.add(querySeven);
        queries.add(queryEight);
        List<Integer> ans = freqQuery(queries);
        ans.stream().forEach(System.out::println);
    }
}
