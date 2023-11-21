package practice1;

import java.util.Scanner;

public class MarksCondition {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter marks of 3 subjects: ");
		int a = sc.nextInt();
		int b = sc.nextInt();
		int c = sc.nextInt();
		if(a>60 && b>60 && c>60) {
			System.out.println("Pass");
		}
		else{
			if(a>60&&b>60 || b>60&&c>60 || c>60&&a>60){
			System.out.println("Promoted");
		}
			else {
				System.out.println("Failed");
			}
	}

}
}
