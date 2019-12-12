import java.io.*;
import java.util.Scanner;

public class DataFrameMenu{  // driver/client program	
	public static DataFrame current;	
	public static Scanner in=new Scanner(System.in);
	public static void main(String[] args) throws IOException {
		int MAX_CONSTANT=-999999999;
		int MIN_CONSTANT=999999999;
		
		System.out.println("Please import a file:");
		String firstFile = in.next();
		DataFrame b = new DataFrame(firstFile);
		char key='e';
		while(key!='q') {
			if(b!=null) {
				System.out.println(b.toString());
			
				System.out.println("Select the method: I(mport), F(requency), A(verage), Min(imum), Max(imum), S(ubset), Q(uit) ");
				String inputmethod = in.next();
				System.out.println("columnName");	//takes as file name on I method
				String inputcol = in.next();
			
				if(inputmethod.equalsIgnoreCase("F")){
					if(b.frequency(inputcol)!="")	System.out.println("Freq "+inputcol+": " +b.frequency(inputcol));
				}
				else if (inputmethod.equalsIgnoreCase("Max")) {
					if(b.maximum(inputcol)>MAX_CONSTANT)	System.out.println("Max "+inputcol+": " +b.maximum(inputcol));
				}
				else if (inputmethod.equalsIgnoreCase("Min")) {
					if(b.minimum(inputcol)<MIN_CONSTANT)	System.out.println("Min "+inputcol+": " +b.minimum(inputcol));
				}
				else if (inputmethod.equalsIgnoreCase("A")) {
					if(b.average(inputcol)>MAX_CONSTANT)	System.out.println("Avg "+inputcol+": " +b.average(inputcol));
				}
				else if (inputmethod.equalsIgnoreCase("S")) {
					System.out.println("operator?");
					String inputop = in.next();
					System.out.println("value");
					String inputval = in.next();
					b=b.subset(inputcol, inputop, inputval);
				
				}
				else if(inputmethod.equalsIgnoreCase("I")) {
					b = new DataFrame(inputcol);
				
				}
			
		
				else if (inputmethod.equalsIgnoreCase("Q")) {
					key='q';
				}
			}
			else {
				System.out.println("You subset the array to null, please re-import the file. Enter file name:");	//takes as file name on I method
				String inputcol = in.next();
				b = new DataFrame(inputcol);
			}
		}
	
	}
		
}