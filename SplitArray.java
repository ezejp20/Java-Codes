/*
 * File: SplitArray.java
 * ----------------------
 * This program generates an array with N random numbers in range(1-10) and splits the array 
 * at mid point
 */

import java.util.Arrays;
import java.util.Random;
import acm.program.*;
import acm.util.RandomGenerator;

public class SplitArray extends ConsoleProgram{
	
	
	
	
	public void run(){
		
		println("This program generates an array and split it.");
		
		//Initialize Main and sub arrays Array
		int arraySize = readInt("Enter how many random numbers to generate: ");
		bufferArray = new int[arraySize];
		firstArray = new int[arraySize/2];
		secondArray = new int[arraySize - firstArray.length];
		
		fillArrayRandomly(bufferArray, numberRange);	//Fill main array with random numbers
		splitArray(bufferArray, firstArray, secondArray, arraySize/2);	//Split array into 2
		
		//Print Results
		println("Main Array Contents: ");
		println(Arrays.toString(bufferArray));
		println("First Half Contents: ");
		println(Arrays.toString(firstArray));
		println("Second Half Contents: ");
		println(Arrays.toString(secondArray));
	}
	
	
	//Splits given array at split point and copies halves to sub arrays
	int splitArray(int[] bufferArray, int[] firstArray, int[] secondArray, int splitPoint){
		
		//Print an error message if split point exceeds array size
		if(splitPoint > bufferArray.length){
			println("Error! Split point is larger than array size");
			return 0;
		}
		
		//Split and copy first part
		for(int a=0; a<splitPoint; a++){
			firstArray[a] = bufferArray[a];	
		}
		
		//Split and copy second part
		for(int b=splitPoint; b<bufferArray.length; b++){
			secondArray[b-splitPoint] = bufferArray[b];	
		}
		
		return 1;
	}
	
	
	
	//Initialize given array with random numbers in given random range
	void fillArrayRandomly(int[] bufferArray, int randomRange){
		
		Random numberGenerator = new Random();
		
		//Fill Array with random numbers
		for(int a=0; a<bufferArray.length; a++){
			bufferArray[a] = numberGenerator.nextInt(randomRange);
		}
	}

	
	
	
	int numberRange = 10;
	int[] bufferArray;
	int[] firstArray, secondArray;
}
