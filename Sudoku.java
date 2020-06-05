/*
 * File: Sudoku.java
 * -----------------
 * This program checks a Sudoko grid to see if it is valid.
 */

import acm.program.*;

public class Sudoku extends ConsoleProgram {

	// This is the test sudoku table.  You can change its entries to test your code.
	private int[][] testGrid = new int[][] { 
			{8, 3, 5, 4, 1, 6, 9, 2, 7}, 
			{2, 9, 6, 8, 5, 7, 4, 3, 1}, 
			{4, 1, 7, 2, 9, 3, 6, 5, 8}, 
			{5, 6, 9, 1, 3, 4, 7, 8, 2}, 
			{1, 2, 3, 6, 7, 8, 5, 4, 9}, 
			{7, 4 ,8, 5, 2, 9, 1, 6, 3}, 
			{6, 5, 2, 7, 8, 1, 3, 9, 4}, 
			{9, 8, 1, 3, 4, 5, 2, 7, 6}, 
			{3, 7, 4, 9, 6, 2, 8, 1, 5}};

	public void run() {		
		println("This program checks validity of Sudoku tables");
		printTable(testGrid);
		println(goodSudokuSolution(testGrid));
	}

	/* Tests whether a Sudoku solution is valid */
	private boolean goodSudokuSolution(int[][] grid) {
		for (int i = 0; i < 9; i++) {
			if (badGroupOfNine(getRow(grid, i))) return false;
			if (badGroupOfNine(getColumn(grid, i))) return false;
			if (badGroupOfNine(get3x3Square(grid, i))) return false;
		}
		return true;
	}

	/*
	 * Tests whether an array of nine values contains any duplicates
	 * or values outside of the range 1 to 9. If not, it must be a
	 * be a legal assignment of Sudoku values.
	 */
	private boolean badGroupOfNine(int[] array) {
		// Your code starts here
		boolean[] alreadySeen = new boolean[10];		
		for (int i = 0; i < 9; i++) {
			int value = array[i];
			if (value < 1 || value > 9 || alreadySeen[value]) return true;
			alreadySeen[value] = true;
		}
		// Your code ends here
		return false;
	}

	/* Extracts row k from an 9x9 grid */
	private int[] getRow(int[][] grid, int k) {
		int[] answer = null;
		// Your code starts here
		answer = grid[k];
		// Your code ends here
		return answer;
	}

	/* Extracts column k from an 9x9 grid */
	private int[] getColumn(int[][] grid, int k) {
		int[] column = new int[9];
		// Your code starts here
		for (int i = 0; i < 9; i++) {
			column[i] = grid[i][k];
		}
		// Your code ends here
		return column;
	}


	/*
	 * Extracts the elements of the kth 3x3 subsquare as an array of 9
	 * elements. The subsquares are numbered from left to right then
	 * top to bottom starting with subsquare 0 in the upper left.
	 */
	private int[] get3x3Square(int[][] grid, int k) {
		int[] array = new int[9];
		// Your code starts here
		int baseRow = k / 3 * 3;
		int baseCol = k % 3 * 3;
		for (int i = 0; i < 9; i++) {
			array[i] = grid[baseRow + i / 3][baseCol + i % 3];
		}
		// Your code ends here
		return array;
	}


	// Prints contents of given Sudoku table
	private void printTable(int[][] table){

		println("Given Sudoku Table:");

		//Print header
		for(int d=0; d<table.length-1; d++){
			print(" - ");
		}
		println();


		//Print body
		for(int a=0; a<table.length; a++){
			print("| ");
			for(int b=0; b<table[a].length; b++){

				print(table[a][b] + " ");

				if((b+1) % 3 == 0){
					print("| ");
				}
			}
			println();

			//Print inter-header
			if((a+1) % 3 == 0){
				for(int d=0; d<table.length-1; d++){
					print(" - ");
				}
				println();
			}
		}
	}	
}
