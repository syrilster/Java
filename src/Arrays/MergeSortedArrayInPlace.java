package Arrays;

/**
 * @author ssadasivan
 * @since 3/31/2017.
 * Iterate through every element of array two starting from last element. Do following for every element of array two.
	a) Store last element of ar1[i]: last = ar1[i]
	b) Loop from last element of ar1[] while element ar1[j] is 	smaller than ar2[i].
			ar1[j+1] = ar1[j] // Move element one position ahead
			j--
	c) If any element of ar1[] was moved or (j != m-1)
			ar1[j+1] = ar2[i]
			ar2[i] = last
 *
 */
public class MergeSortedArrayInPlace {
	public static void merge(int arrayOne[], int arrayTwo[]) {
		//Start from the smallest array to iterate over. Iteration starts from the last
		for (int i = arrayTwo.length - 1; i >= 0; i--) {
			//Store last element of array one in a temp variable
			int last = arrayOne[arrayOne.length - 1];
			int j;
			//Start the loop from last but one element of array one and compare it with array two
			for (j = arrayOne.length - 2; j >= 0 && arrayOne[j] > arrayTwo[i]; j--) {
				arrayOne[j + 1] = arrayOne[j];
			}
			//Replace array one (j+1)th element with array two i element and then swap last and array two of i
			if (j != arrayOne.length - 2 || last > arrayTwo[i]) {
				arrayOne[j + 1] = arrayTwo[i];
				arrayTwo[i] = last;
			}
		}
	}

	public static void main(String[] args) {
		int arrayOne[] = { 1, 5, 9, 10, 15, 20 };
		int arrayTwo[] = { 2, 3, 8, 13 };
		merge(arrayOne, arrayTwo);
		System.out.println("After Merging First Array");
		for (int i = 0; i < arrayOne.length; i++) {
			System.out.print(arrayOne[i] + " ");
		}
		System.out.println("\nSecond Array ");
		for (int i = 0; i < arrayTwo.length; i++) {
			System.out.print(arrayTwo[i] + " ");
		}
	}
}
