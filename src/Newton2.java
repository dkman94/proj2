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
public final class Newton2 {

    /**
     * Private constructor so this utility class cannot be instantiated.
     */
    private Newton2() {
    }

    /**
     * Method that computes a sqrt with Newtons iteration method
     */
    private static double sqrt(SimpleReader in, SimpleWriter out) {
    	double sqrtRoot;
    	//get user input
    	out.print("Enter a double to sqrt: ");
    	double input = in.nextDouble();
    	//if the input is not valid then return an error
    	if (input < 0){
    		return Double.NaN;
    	}
    	//set the epsilon or error value 
        double epsilon = 1E-3;
        //set a temp value
        double temp = input;
        //while the value satisfies the condition of newtons iteration
        while (Math.abs(temp - input/temp) > epsilon*temp){
        	//recursively set the value of the temp variable 
            temp = (input/temp + temp) / 2.0;
        }
        //return the result
        sqrtRoot = temp;
        return sqrtRoot;
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
        //verify that user wants to continue
        out.print("Would you like to compute a sqrt(y/n)? ");
        //when the answer is yes compute root else quite
        while(in.nextLine().equals("y")){
        	//computer root from function
        	double root = sqrt(in,out);
        	//print root
        	out.println(root);
        	//verify that user wants to continue
        	out.print("Would you like to continue(y/n): ");
        }
        //concluding message when user quits
        out.print("Thanks for playing!");
        /*
         * Close input and output streams
         */
        in.close();
        out.close();
    }

}
