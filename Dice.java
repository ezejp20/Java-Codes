
import acm.program.*;
import acm.util.*;

public class Dice extends ConsoleProgram {
	
	public void run() {	
		int count = readInt("Enter number of throws: ");
		
		// create the frequency list
		int[][] frequency = createTable( count );
		
		// display the frequency table
		displayTable( frequency );
		
		// display the probabilities of total outcomes
		displayProbabilities( frequency, count );  
	}

	// display the frequency table
	private void displayTable(int[][] frequency) {
		println("\nOutcomes:\n");
		
		// header
		println("\t\t1\t2\t3\t4\t5\t6");
		println("\t\t---\t---\t---\t---\t---\t---");
		
		// frequencies
		for (int die1 = 1; die1 < frequency.length; die1++) {
			print(die1 + "\t|");
			for (int die2 = 1; die2 < frequency[die1].length; die2++) {
				print("\t" + frequency[die1][die2]);
			}
			println();
		}
	}

	// display the probabilities of total outcomes
	private void displayProbabilities(int[][] frequency, int count) {
		// Your code starts here
		// header
		println("\nRates:\n");
		
		int[] rate = new int[13];
		
		// trace the frequency table
		for (int die1 = 1; die1 < frequency.length; die1++) {
			for (int die2 = 1; die2 < frequency[die1].length; die2++) {
				rate[ die1 + die2 ] += frequency[die1][die2];
			}
		}
			
		for (int i = 2; i < rate.length; i++) {
			// print the alternative, its total occurrence and the probability
			println(i + ":\t" + rate[i] + "\t" + (double) rate[i] / count * 100 + "%");
		}
		// Your code ends here
	}

	// create the 2D table and fill it with random dice outcomes
	private int[][] createTable( int count ) {
		// create the table
		int[][] table = new int[7][7];
		
		// Fill the table with the counts of dice throws
		// Your code starts here
		for ( int i = 0; i < count; i++ ) {
			// toss a pair of dice
			int die1 = randomDie();
			int die2 = randomDie();

			// increase the corresponding outcome's frequency by one
			table[die1][die2]++; 
		}
		// Your code ends here
		
		return table;
	}

	// return a random die outcome between 1 and 6, inclusive
	private int randomDie() {
		return rgen.nextInt(1, 6);
	}
	
	// random number generator
	private static RandomGenerator rgen = RandomGenerator.getInstance();
}
