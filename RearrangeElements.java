/**
 * Created by ssadasivan on 2/14/2017.
 */
public class RearrangeElements {
	public static void main(String[] args) {
		RearrangeElements solution = new RearrangeElements();
		int[] testArray = { -1, 3, 2, 4, 5, -6, 7, -9 };
		solution.reArrangePositivesNegatives(testArray);
		for (int i = 0; i < testArray.length; i++) {
			System.out.println(testArray[i]);
		}
	}

	private void reArrangePositivesNegatives(int[] array) {
		for (int i = 0; i < array.length; i++) {
			if (notAtRightPosition(array, i)) {
				int nextOpposite = getNextOppositeNumber(array, i);
				if (nextOpposite != -1) {
					rotateArrayByRight(array, i, nextOpposite);
				} else {
					//We dont have any signed numbers so its safe to break
					break;
				}
			}
		}
	}

	private void rotateArrayByRight(int[] array, int low, int high) {
		//Simple logic to take last element and store, then do proper element shifting and then replace back the last element
		int lastElement = array[high];
		for (int i = high; i > low; i--) {
			array[i] = array[i - 1];
		}
		array[low] = lastElement;
	}

	private int getNextOppositeNumber(int[] array, int index) {
		//Navigate till we find a product which leads to a negative number
		for (int i = index + 1; i < array.length; i++) {
			if ((array[i] * array[index]) < 0)
				return i;
		}
		return -1;
	}

	private boolean notAtRightPosition(int[] array, int index) {
		if (index % 2 == 0) {
			if (array[index] < 0)
				return true;
			else
				return false;
		} else {
			if (array[index] > 0)
				return true;
			else
				return false;
		}
	}
}
