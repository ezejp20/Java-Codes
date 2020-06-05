/*
 * File: MatrixAddition.java
 * --------------------------
 * Write a program that creates two matrices of size NxN with random integer entries between -100 and 100.
 * The program first displays the two matrices and then their sum.
 * The size N is to be provided by the user.
 */

import acm.program.*;
import acm.util.*;

public class MatrixAddition extends ConsoleProgram {

    public void run() {
	// Your code starts here
	print("Enter the size of the matrix (i.e., N): ");
	int N = readInt();

	int[][] matrix1 = new int[N][N];
	int[][] matrix2 = new int[N][N];
	int[][] matrixSum = new int[N][N];

	fillRandom(matrix1);
	fillRandom(matrix2);

	println("\n The first matrix is:");
	printMatrix(matrix1);
	println("\n The second matrix is:");
	printMatrix(matrix2);

	matrixSum = addMatrices(matrix1,matrix2);
	println("\n The sum of the matrices is: ");
	printMatrix(matrixSum);
	// Your code ends here
    }

    /*Fills integer matrix with random numbers*/
    public void fillRandom(int[][] matrix){
	// Your code starts here
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix.length; j++) {
		matrix[i][j] = rgen.nextInt(-100,100);
	    }
	}
	// Your code ends here
    }

    /*Prints the integer matrix in matrix format*/
    public void printMatrix(int[][] matrix){
	for (int i = 0; i < matrix.length; i++) {
	    for (int j = 0; j < matrix.length; j++) {
		print(matrix[i][j] + "\t");
	    }
	    println();
	}
    }

    /*Returns the sum of two matrices*/
    public int[][] addMatrices(int[][] matrix1, int[][] matrix2){
	int[][] sum = null;
	// Your code starts here
	sum = new int[matrix1.length][matrix1.length];
	for (int i = 0; i < matrix1.length; i++) {
	    for (int j = 0; j < matrix1.length; j++) {
		sum[i][j] = matrix1[i][j] + matrix2[i][j];
	    }
	}

	return sum;
	// Your code ends here
    }

    /* Private constants */
    private RandomGenerator rgen = RandomGenerator.getInstance();
}
