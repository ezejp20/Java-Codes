/*
 * File: RotateLeft.java
 * -----------------------
 * This program loads an image file, rotates it 90 degrees counter-clockwise,
 * and displays both the original and the rotated image.
 */

import acm.graphics.*;
import acm.program.*;

public class RotateLeft extends GraphicsProgram {

	private static final String fileName = "cute-kitty-frog.jpg";
	private static final double IMAGE_SEP = 20;

	public void run() {
		setSize(900, 500);
		GImage original = new GImage(fileName);
		GImage rotated = rotateLeft(original);
		add(original, IMAGE_SEP, IMAGE_SEP);
		add(rotated, original.getWidth() + 2 * IMAGE_SEP, IMAGE_SEP);
	}

	/*
	 * Creates a new image which consists of the pixels in the original
	 * rotated 90 degrees counter-clockwise.
	 */
	private GImage rotateLeft(GImage image) {
		// Your code starts here
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		int[][] array2 = new int[width][height];
		for (int i = 0; i < height; i++) {
			for (int j = 0; j < width; j++) {
				array2[width - j - 1][i] = array[i][j];
			}
		}
		return new GImage(array2);
		// Your code ends here
	}
}
