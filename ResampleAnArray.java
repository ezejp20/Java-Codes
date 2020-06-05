import acm.program.ConsoleProgram;

public class ResampleAnArray extends ConsoleProgram{
	public void run(){
		int N=readInt("Specify N:");
		int deltaInd=readInt("Specify resampling rate : ");
		int[] array=createArray(N);
		println("Array created : "+arrayToString(array));
		println("Resampled array : "+arrayToString(resample(array,deltaInd)));
	}
	private int[] createArray(int N){
		// Your code starts here
		int[] array=new int[2*N+1];
		for(int ind=0;ind<array.length;ind++){
			array[ind]=ind-N;
		}
		return array;
		// Your code ends here
	}
	private String arrayToString(int[] array){
		String result="";
		for(int ind=0;ind<array.length;ind++){
			result+=(array[ind]+" ");
		}
		return result;
	}
	private int[] resample(int[] array, int deltaInd){
		// Your code starts here
		int newLen=1+((array.length-1)/deltaInd);// int/int will function similar to the floor operation
		int[] newArray=new int[newLen];
		for(int ind=0;ind<newLen;ind++){
			newArray[ind]=array[ind*deltaInd];
		}
		return newArray;
		// Your code ends here
	}
}
