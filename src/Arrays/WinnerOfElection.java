package Arrays;

import java.util.*;

/**
 * Given an array of names (consisting of lowercase characters) of candidates in an election.
 * A candidate name in array represents a vote casted to the candidate. Print the name of candidate that received Max votes.
 * If there is tie, print lexicographically smaller name.
 */
public class WinnerOfElection {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(winner(new String[]{"john", "johnny", "jackie", "johnny", "john",
                "jackie", "jamie", "jamie", "jamie", "john", "johnny", "jamie",
                "johnny", "john"}, 13)));
        System.out.println(Arrays.toString(winner(new String[]{"andy", "blake", "clark"}, 3)));
    }

    //Function to return the name of candidate that received maximum votes.
    public static String[] winner(String[] arr, int n) {
        int maxVotes = 1;
        String[] result = new String[2];
        if (n == 1) {
            result[0] = arr[0];
            result[1] = String.valueOf(1);
            return result;
        }

        Map<String, Integer> resMap = new HashMap<>();
        for (String candidate : arr) {
            if (resMap.containsKey(candidate)) {
                int vote = resMap.get(candidate);
                vote++;
                resMap.put(candidate, vote);
                maxVotes = Math.max(vote, maxVotes);
            } else {
                resMap.put(candidate, 1);
            }
        }

        List<String> maxVoteCandidates = new ArrayList<>();
        for (Map.Entry m : resMap.entrySet()) {
            if ((Integer) m.getValue() == maxVotes) {
                maxVoteCandidates.add((String) m.getKey());
            }
        }

        Collections.sort(maxVoteCandidates);
        result[0] = maxVoteCandidates.get(0);
        result[1] = String.valueOf(maxVotes);

        return result;
    }

    //Function to return the name of candidate that received maximum votes.
    public static String[] winnerUsingSortedMap(String[] arr, int n) {
        String[] result = new String[2];
        Map<String, Integer> resMap = new TreeMap<>();
        int maxVotes = 1;
        for (String candidate : arr) {
            if (resMap.containsKey(candidate)) {
                int vote = resMap.get(candidate);
                vote++;
                resMap.put(candidate, vote);
                maxVotes = Math.max(vote, maxVotes);
            } else {
                resMap.put(candidate, 1);
            }
        }

        for (Map.Entry m : resMap.entrySet()) {
            if ((Integer) m.getValue() == maxVotes) {
                result[0] = String.valueOf(m.getKey());
                result[1] = String.valueOf(maxVotes);
                break;
            }
        }

        return result;
    }
}
