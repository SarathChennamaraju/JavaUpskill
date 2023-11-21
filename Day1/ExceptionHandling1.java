package practice3;

import java.util.Scanner;

public class ExceptionHandling1 {

	public static void main(String[] args) throws UnsupportedOperationException {
		// TODO Auto-generated method stub
		 int a,b;
	        
	        Scanner sc=new Scanner(System.in);
	        
	        System.out.println("Eneter 2 numbers");
	        a=sc.nextInt();
	        b=sc.nextInt();
	        try {
	        	if(b!=0) {
	        		int c= a/b;
	        		System.out.println("Result is: " +c);
	        	}
	        	else {
	        		throw new UnsupportedOperationException("value of b cannot be zero");
	        	}
	        }
	        catch(UnsupportedOperationException e) {
	        	System.out.println(e);
	        }

}
}
