package practice1;

import java.util.Scanner;

public class StudentMarks {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		// TODO Auto-generated method stub
		int[][] marks = new int[3][3];

        for (int i = 0; i < 3; i++) {
            System.out.println("Enter marks for Student " + (i + 1) + ":");
            for (int j = 0; j < 3; j++) {
                System.out.print("Enter marks for Subject " + (char)('A' + j) + ": ");
                marks[i][j] = scanner.nextInt();
            }
        }

        // Calculate and display total and average scores for each subject
        System.out.println("\nSubject-wise Performance:");

        for (int j = 0; j < 3; j++) {
            int subjectTotal = 0;

            for (int i = 0; i < 3; i++) {
                subjectTotal += marks[i][j];
            }

            double subjectAverage = (double) subjectTotal / 3;

            System.out.println("Subject " + (char)('A' + j) + ":");
            System.out.println("   Total Score: " + subjectTotal);
            System.out.println("   Average Score: " + subjectAverage);
        }

        // Calculate and display total and average scores for each student
        System.out.println("\nStudent-wise Performance:");

        for (int i = 0; i < 3; i++) {
            int studentTotal = 0;

            for (int j = 0; j < 3; j++) {
                studentTotal += marks[i][j];
            }

            double studentAverage = (double) studentTotal / 3;

            System.out.println("Student " + (i + 1) + ":");
            System.out.println("   Total Score: " + studentTotal);
            System.out.println("   Average Score: " + studentAverage);
        }
    }
}
