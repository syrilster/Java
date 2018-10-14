package Arrays;

/**
 * Created by Syril on 17-04-2016.
 */
public class FindDuplicateCount {

    public static void main(String[] args) {
        int[] array1 = {1, 1, 2, 3, 4, 5, 6, 7, 8, 9, 9, 9, 9, 10};  // x = 9, ans = 4
        int[] array2 = {1, 1, 2, 2, 2, 2, 3};  // x = 3, ans = 1

        System.out.println(count(array1, 9));
        System.out.println(count(array2, 2));
    }

    private static int findElementBasedOnOccurance(int[] inputArray, int elementToSearch, boolean firstOccurance) {
        int lowIndex = 0, highIndex = inputArray.length - 1, result = -1;

        while (lowIndex <= highIndex) {
            int mid = (lowIndex + highIndex) / 2;
            if (inputArray[mid] < elementToSearch) {
                lowIndex = mid + 1;
            } else if (inputArray[mid] > elementToSearch) {
                highIndex = mid - 1;
            } else if (inputArray[mid] == elementToSearch) {
                result = mid;
                //To find first occurance move high towards left and for last occurance move low towards right.
                if (firstOccurance)
                    highIndex = mid - 1;
                else
                    lowIndex = mid + 1;
            }
        }

        return result;
    }

    private static int count(int[] inputArray, int elementToBeSearched) {

        int first = findElementBasedOnOccurance(inputArray, elementToBeSearched, true);
        if (first == -1) {
            return 0;
        } else {
            int last = findElementBasedOnOccurance(inputArray, elementToBeSearched, false);
            return (last - first + 1);
        }
    }
}
