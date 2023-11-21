package practice1;

import java.util.Scanner;

public class UserLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 final String validUsername = "user123"; // Change this to the valid username
	        final String validPassword = "pass456"; // Change this to the valid password
	        final int maxAttempts = 3;
	        int attempts = 0;

	        Scanner scanner = new Scanner(System.in);

	        while (attempts < maxAttempts) {
	            System.out.print("Enter username: ");
	            String username = scanner.nextLine();
	            System.out.print("Enter password: ");
	            String password = scanner.nextLine();

	            if (username.equals(validUsername) && password.equals(validPassword)) {
	                System.out.println("Welcome, " + username);
	                break;
	            } else {
	                attempts++;
	                System.out.println("Invalid username or password. Attempts left: " + (maxAttempts - attempts));
	            }
	        }

	        if (attempts == maxAttempts) {
	            System.out.println("Contact Admin");
	        }

	        scanner.close();
	    }
	}
	


