package practice1;

import java.util.Scanner;

public class ArraySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		 int[] A= {5, 12, 14, 6, 78, 19, 23, 26, 35, 37, 7, 52, 86, 47};
		 System.out.println("Enter a Key " );
	       int key=sc.nextInt();
	        
	        
	        for(int i=0;i<A.length;i++)
	        {
	            if(key==A[i])
	            {
	                System.out.println("Element Found at :"+i);
	                System.exit(0);
	            }
	            
	        }
	        System.out.println("Not found");
	}
	        }


