package practice1;

public class Armstrong2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		  for (int num = 100; num <= 999; num++) {
	            int n = num;
	            int count = 0;
	            int sum = 0;

	               while (n > 0) {
	               count++;
	               n = n / 10;
	            }

	            n = num; 

	            while (n > 0) {
	                int r = n % 10;
	                sum += Math.pow(r, count);
	                n = n / 10;
	            }

	            if (num == sum) {
	                System.out.println(num);
	            }
	        }
	    }
	}


