import components.simplereader.SimpleReader;
import components.simplereader.SimpleReader1L;
import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * Put a short phrase describing the program here.
 * 
 * @author Put your name here
 * 
 */
public final class Newton4 {
	private static boolean toQuit = true;

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton4() {
    }

    /**
     * Method that computes a sqrt with Newtons iteration method
     */
    private static void sqrt(SimpleReader in, SimpleWriter out) {
    	double sqrtRoot;
    	//get user input
    	out.print("Enter a double to sqrt: ");
    	double input = in.nextDouble();
    	//if the input is less than zero set var to false and exit program
    	if (input < 0){
    		out.print("Thanks for playing!");
    		toQuit = false;
    		System.exit(0);
    	}
    	//set the epsilon or error value 
    	out.print("Enter an epsilon value (i.e. .0001 = .01%): ");
        double epsilon = in.nextDouble();
        //set a temp value
        double temp = input;
        //while the value satisfies the condition of newtons iteration
        while (Math.abs(temp - input/temp) > epsilon*temp){
        	//recursively set the value of the temp variable 
            temp = (input/temp + temp) / 2.0;
        }
        //return the result
        sqrtRoot = temp;
        
    	//print root
    	out.println(sqrtRoot);
    }

    /**
     * Main method.
     * 
     * @param args
     *            the command line arguments
     */
    public static void main(String[] args) {
        SimpleReader in = new SimpleReader1L();
        SimpleWriter out = new SimpleWriter1L();
        //keep computing roots when the user has not entered a negative number
        while(toQuit){
        	//computer root from function
        	sqrt(in,out);
        }
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
