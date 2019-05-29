package DynamicProgramming;

public class LongestCommonSubSequence {

    private static String[][] memo;

    /**
     * String stringOne = "ABCD";
     * String stringTwo = "AFKD";
     * Expected: AD
     * Explanation: https://www.youtube.com/watch?v=4SP_AY7GGxw
     * @param args
     */
    public static void main(String[] args) {
        String stringOne = "I am waiting for snow.";
        String stringTwo = "I've been waiting for snow.";
        memo = new String[stringOne.length()][stringTwo.length()];
        //System.out.println("Longest Common Sub sequence is: " + longestCommonSubSequence(stringOne, stringTwo, 0, 0));
        System.out.println("Longest Common Sub sequence using DP is: " + longestCommonSubSequenceDP(stringOne, stringTwo, 0, 0, memo));
    }

    private static String longestCommonSubSequence(String stringOne, String stringTwo, int indexOne, int indexTwo) {
        if (indexOne == stringOne.length() || indexTwo == stringTwo.length())
            return "";
        if (stringOne.charAt(indexOne) == stringTwo.charAt(indexTwo))
            return stringOne.charAt(indexOne) + longestCommonSubSequence(stringOne, stringTwo, indexOne + 1, indexTwo + 1);
        String resultOne = longestCommonSubSequence(stringOne, stringTwo, indexOne + 1, indexTwo);
        String resultTwo = longestCommonSubSequence(stringOne, stringTwo, indexOne, indexTwo + 1);
        return resultOne.length() > resultTwo.length() ? resultOne : resultTwo;
    }

    private static String longestCommonSubSequenceDP(String stringOne, String stringTwo, int indexOne, int indexTwo, String[][] memo) {
        if (indexOne == stringOne.length() || indexTwo == stringTwo.length())
            return "";
        if (memo[indexOne][indexTwo] != null)
            return memo[indexOne][indexTwo];
        if (stringOne.charAt(indexOne) == stringTwo.charAt(indexTwo)) {
            memo[indexOne][indexTwo] = stringOne.charAt(indexOne) +
                    longestCommonSubSequenceDP(stringOne, stringTwo, indexOne + 1, indexTwo + 1, memo);
            return memo[indexOne][indexTwo];
        }

        String resultOne = longestCommonSubSequenceDP(stringOne, stringTwo, indexOne + 1, indexTwo, memo);
        String resultTwo = longestCommonSubSequenceDP(stringOne, stringTwo, indexOne, indexTwo + 1, memo);
        String result = resultOne.length() > resultTwo.length() ? resultOne : resultTwo;
        memo[indexOne][indexTwo] = result;
        return memo[indexOne][indexTwo];
    }
}
