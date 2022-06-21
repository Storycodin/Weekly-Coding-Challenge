package Due6_24;

public class SherlockSquares {
	/*
	 * Watson likes to challenge Sherlock's math ability. He will provide a starting and ending value describing a range of integers. 
	 * Sherlock must determine the number of square integers within that range, inclusive of the endpoints (note that a square integer is an integer which is the square of an integer,
e.g. 1, 4, 9, 16, 25, 36, 49).
For example, the range is a=24 and b=49, inclusive. There are three square integers in the range: 25, 36, and 49.
Complete the squares function that returns an integer representing the number of square integers in the inclusive range from a to b.
Examples
<code>squares(3, 9) > 2
squares(17, 24) > 0
squares(1, 1000000000) > 31622
</code>Notes
Your solution must solve each problem in 1 second or less.


	 * */

	public static void main(String[] args) {
		
//		2
//		35 70
//		100 1000
		
		
		int min;
		int max;
		
		min = 0;
		max = 25;
		
		System.out.println(findAllSquaresWithRoot(min, max)); //6
		
		
		min = 35;
		max = 70;
		
		System.out.println(findAllSquaresWithRoot(min, max));//3
		
		
		min = 17;
		max = 24;
		
		System.out.println(findAllSquaresWithRoot(min, max));//0
		
		min = 3;
		max = 9;
		
		System.out.println("shouldbe 2 " + findAllSquaresWithRoot(min, max));//2
		
		min = 100;
		max = 1000;
		
		System.out.println(findAllSquaresWithRoot(min, max)); //22
		
		min = 9;
		max = 999999966;
		
		System.out.println(findAllSquaresWithRoot(min, max)); //31620
		
	}
	
	public static int findAllSquaresBrute(int min, int max) {
		int j = 0;
		int result = 0;
		for (int i = 0; i <= max; i++) {
			
			
			while( j*j >= min) {
				if(j*j <= max) {
					result++;
				}
				j++;
			}
			j++;
			
		}
		return result;
	}
	
	public static int findAllSquaresWithRoot(int min, int max) {
		int result = 0;
		
		int sqMin = (int) Math.sqrt((double) min);
		int sqMax = (int) Math.sqrt((double) max);
		
		if (Math.sqrt((double) min)%1 == 0.0) {
			result++;
		}
		
		
		result = result + (sqMax - sqMin);
		

		return result;
		
	}
	
	
}
