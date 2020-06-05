import acm.program.*;
import acm.util.RandomGenerator;

public class MaxMin extends ConsoleProgram{
	
	public void run() {
		int[] array = new int[ARRAY_SIZE];
		
		fillArrayRandomly(array);
		
		int max = findMax(array);
		int min = findMin(array);
		
		printArray(array);
		println("The largest element is: " + max);
		println("The smallest element is: " + min);
	}
	
	// Find the largest element in an array of integers
	private int findMax(int[] array) {
		int max = MINIMUM_NUMBER_RANGE;
		// Your code starts here
        for (int i = 0; i < array.length; i++) {
			if (array[i] > max) {
				max = array[i];
			}
		}
		// Your code ends here
		return max;
	}
	
	// Find the smallest element in an array of integers
	private int findMin(int[] array) {
		int min = MAXIMUM_NUMBER_RANGE;
		// Your code starts here
        for (int i = 0; i < array.length; i++) {
			if (array[i] < min) {
				min = array[i];
			}
		}
		// Your code ends here
		return min;
	}
	
	// Initialize given array with random integers in range [MINIMUM_NUMBER_RANGE .. MAXIMUM_NUMBER_RANGE)
	private void fillArrayRandomly(int[] array) {
		for (int i = 0; i < array.length; i++) {
			array[i] = rgen.nextInt(MINIMUM_NUMBER_RANGE + 1, MAXIMUM_NUMBER_RANGE - 1);
		}
	}
	
	private void printArray(int[] array) {
		for(int i = 0; i < array.length; i++){
			print(array[i] + " ");
		}
		println("");
	}
	
	private final int MINIMUM_NUMBER_RANGE = 0;
	private final int MAXIMUM_NUMBER_RANGE = 100;
	private final int ARRAY_SIZE = 10;
	
	RandomGenerator rgen = RandomGenerator.getInstance();
}
