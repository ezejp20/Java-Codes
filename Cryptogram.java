/*
 * File: Cryptogram.java
 * ----------------------
 * This program reads text file contents and replace each char with given replacement to oobtain secret message
 */


import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

import acm.program.*;
import acm.util.ErrorException;


public class Cryptogram extends ConsoleProgram{
	
	
	public void run() {
		
		println("This program decrypts a given message");
		
		BufferedReader rd = openInputFile("Enter Message file name: ");		//Open Message File for reading
		messageArray = readLineArray(rd);									//Read Message File contents
		
		rd = openInputFile("Enter Replacement file name: ");				//Open Replacement File for reading
		replacementArray = readReplacementArray(rd);						//Read Replacement File contents
		
		//Print Encrypted Message
		println("Encrypted Message:");
		for(int a=0; a<messageArray.length; a++){
			println(messageArray[a]);
		}
		
		decryptMessage(messageArray, replacementArray);						//Decrypt Message
		
		//Print Decrypted Message
		println("\nDecrypted Message:");
		for(int a=0; a<messageArray.length; a++){
			println(messageArray[a]);
		}
	}
	
	
	//Decrypt given message (overwrite it)
	private void decryptMessage(String[] messageArray, String[][] replacementArray){
		
		for(int a=0; a<messageArray.length; a++){
			for(int b=0; b<replacementArray.length; b++){
				messageArray[a] = messageArray[a].replace(replacementArray[b][0], replacementArray[b][1]);
			}
		}
	}
	
	
	//Read Replacement File and returns mapping content in 2 dimensional array
	private String[][] readReplacementArray(BufferedReader readHandler){
		
		String[] rawLines = readLineArray(readHandler);
		
		//Transfer ArrayList to a string array
		String[][] result = new String[rawLines.length][2];
		for (int i = 0; i < result.length; i++) {
			String[] words = rawLines[i].split(" ");	//Split line into 2 to get victim char and replacement char
			result[i][0] = words[0];
			result[i][1] = words[1];
		}
		
		
		return result;
	}
	
	
	//Reads Message File contents and returns each line in a string array
	private String[] readLineArray(BufferedReader rd) {
		
		ArrayList<String> lineList = new ArrayList<String>();
		String line;
		
		
		try {
			//Read File Contents
			while (true) {
				
				line = rd.readLine();
				if (line == null){
					break;
				}
				
				lineList.add(line);		//Add read line to array list
			}
			rd.close();	//Close file handler
			
		} 
		catch (IOException ex) {
			throw new ErrorException(ex);
		}
		
		//Transfer ArrayList to a string array
		String[] result = new String[lineList.size()];
		for (int i = 0; i < result.length; i++) {
			result[i] = lineList.get(i);
		}
		
		
		return result;
	}
	
	
	/**
	* Requests the name of an input file from the user and then opens
	* that file to obtain a BufferedReader.  If the file does not exist,
	* the user is given a chance to reenter the file name.
	*
	* @param prompt The string to print as a prompt to the user
	* @return A BufferedReader open to the file specified by the user
	*/
	private BufferedReader openInputFile(String prompt) {
		
		BufferedReader rd = null;
		
		while (rd == null) {
			try {
				
				String name = readLine(prompt);					//Take name of the file from user
				rd = new BufferedReader(new FileReader(name));	//Open File for reading
				
			} 
			catch (IOException ex) {
				println("Can't open that file.");				//Print an error message
			}
		}
		
		return rd;												//Return file handler
	}

	String[] messageArray;
	String[][] replacementArray;

}
