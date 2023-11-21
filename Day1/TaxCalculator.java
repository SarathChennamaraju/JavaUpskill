package practice1;

import java.util.Scanner;

public class TaxCalculator {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Scanner scanner = new Scanner(System.in);

	        System.out.print("Enter your CTC (Cost to Company): ");
	        double ctc = scanner.nextDouble();

	        double incomeTax = calculateIncomeTax(ctc);

	        System.out.println("Income Tax Payable: Rs. " + incomeTax);
	    }

	    private static double calculateIncomeTax(double ctc) {
	        if (ctc <= 180000) {
	            return 0; 
	        } else if (ctc <= 300000) {
	            return 0.1 * (ctc - 180000); 
	        } else if (ctc <= 500000) {
	            return 0.2 * (ctc - 300000) + calculateIncomeTax(300000); 
	        } else if (ctc <= 1000000) {
	            return 0.3 * (ctc - 500000) + calculateIncomeTax(500000); 
	        } else {
	            return 0.3 * (ctc - 1000000) + calculateIncomeTax(1000000);
	        }
	    }
	}
	


