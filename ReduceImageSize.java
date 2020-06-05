/*
 * File: ReduceImageSize.java
 * --------------------------
 * This program down-samples an image by two, hence reduces its size, by discarding one of every two pixels,
 * in both horizontal and vertical directions.
 */

import java.awt.Color;

import acm.graphics.*;
import acm.program.*;

public class ReduceImageSize extends GraphicsProgram {
	public void run() {
		resize(APPLICATION_WIDTH, APPLICATION_HEIGHT);
		setBackground(Color.GRAY);
		GImage originalImage = new GImage("coder.jpg");		
		//Your code starts here
		GImage sampledImage = downSampleImage(originalImage);
		double xLeft = (getWidth() - originalImage.getWidth() - sampledImage.getWidth()) / 3;
		double xRight = originalImage.getWidth() + 2*xLeft;
		double y = (getHeight() - originalImage.getHeight()) / 2;
		add(originalImage, xLeft, y);
		add(sampledImage, xRight, y);
		//Your code ends here
	}

	/* down-samples the input image by two */
	private GImage downSampleImage(GImage image) {		
		GImage sampledImage = null;		

		//Your code starts here
		int[][] array = image.getPixelArray();
		int height = array.length;
		int width = array[0].length;
		int[][] smallArray = new int[height/2][width/2];

		for (int i = 0; i < height/2; i++) {
			for (int j = 0; j < width/2; j++) {
				smallArray[i][j] = array[2*i][2*j];
			}
		}

		sampledImage = new GImage(smallArray);
		//Your code ends here

		return sampledImage;

	}

	/* Set the dimensions of the window */
	public static final int APPLICATION_WIDTH = 800;
	public static final int APPLICATION_HEIGHT = 400;

}
