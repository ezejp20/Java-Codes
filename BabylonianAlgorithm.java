import acm.program.ConsoleProgram;

public class BabylonianAlgorithm extends ConsoleProgram{
	public void run(){
		//Your code starts here
		println("This program computes the square-root of a value");
		println("by using the generalized Babylonian algorithm");
		println("------------------------------------------------");
		double val=readInt("Specify the value:");
		double xprev=val+1;
		double x=val;
		while(Math.abs(x-xprev)>1.0E-6){
			xprev=x;
			x=(xprev+val/xprev)/2;
			println("x="+x);
		}
		println("Estimation finished");
		println("x = "+x+", x^2="+x*x);
		//Your code ends here
	}
}
