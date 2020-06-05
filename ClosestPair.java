/*
 * File: ClosestPair.java
 * ----------------------
 * The data file “Heights.txt” contains the heights of students in a                                                     
 * class in centimeters (one height per line, each height expressed as                                                   
 * a double).  Write a program that reads the numbers in this file                                                       
 * into an ArrayList and finds the pair of numbers that are closest to                                                   
 * each other.  The program should print out which two numbers are                                                       
 * closest and what their difference is.  It should work for any file                                                    
 * containing a number on each line.                                  
 */

import acm.program.*;
import acm.util.*;
import java.io.*;
import java.util.*;

public class ClosestPair extends ConsoleProgram {	

	/* Name of the data file */
	private static final String DATA_FILE = "Heights.txt";

	public void run() {
		ArrayList<Double> list = readArrayList(DATA_FILE);
		// Your code starts here
		double num1 = 0; 
		double num2 = 0;
		double mindiff = -1;
		for (int i = 0; i < list.size(); i++) {
			double xi = list.get(i);
			for (int j = i + 1; j < list.size(); j++) {
				double xj = list.get(j);
				double diff = Math.abs(xi - xj);
				if (mindiff == -1 || diff < mindiff) {
					mindiff = diff;
					num1 = xi;
					num2 = xj;
				}
			}
		}
		println("The closest pair is " + num1 + " and " + num2 + " with diff " + mindiff);
		// Your code ends here
	}

	/* Reads a data file containing doubles into an array */
	private ArrayList<Double> readArrayList(String filename) {
		ArrayList<Double> list = new ArrayList<Double>();
		println("Reading " + filename + " into an ArrayList...");
		// Your code starts here
		try {
			BufferedReader rd = new BufferedReader(new FileReader(filename));
			while (true) {
				String line = rd.readLine();
				if (line == null) break;
				list.add(Double.parseDouble(line));
			}
		} catch (IOException ex) {
			throw new ErrorException(ex);
		}
		// Your code ends here
		return list;
	}

}

