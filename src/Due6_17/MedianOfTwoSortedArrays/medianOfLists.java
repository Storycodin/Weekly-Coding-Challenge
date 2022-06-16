package Due6_17.MedianOfTwoSortedArrays;

/*
 *1) Median of Two Sorted Arrays
Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.
The overall run time complexity should be O(log (m+n)).

Example1:
Input:nums1 = [1,3], nums2 = [2]
Output:2.00000
Explanation: merged array = [1,2,3] and median is 2.

Example2:
Input:nums1 = [1,2], nums2 = [3,4]
Output:2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.

Constraints:
nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106
*/
public class medianOfLists {
	// make pointers at the front and end of both lists
	// if total size of a and b is even find 2 number if odd find one.
	// move one of the front if it is the lowest
	// move one of the back if it is the highest
	// when a pair of pointers meet move the other pointer symotaneusly.
	// when both pairs don't move if the second to stop do not equal the same number then return avarage, if they do return that number. 

	public static void main(String[] arges) {
		int[] arr1 = {1,3};
		int[] arr2 = {2};
		
		System.out.println(findMedianSortedArrays(arr1, arr2));// 2
		
		
		System.out.println();
		int[] arr3 = {1,2};
		int[] arr4 = {3,4};
		
		System.out.println(findMedianSortedArrays(arr3, arr4));// 2.5
		
		
//		findMedianSortedArrays(
				
				
	}

	public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int nums1Front = 0;
		int nums1End = nums1.length-1;
		
		int nums2Front = 0;
		int nums2End = nums2.length-1;
		
		int spacesMoved = 0;
		
		double median = 0; 
		
		// used to find the middle of the two arrays if they where the same array. This is where the median is. 
		int middle = (nums1.length + nums2.length)/2;
		
		int[] lastElementIsMedian = new int[middle+1];
		
		// used to know if the median is the middle point or half of the two middle points.
		boolean ifEven;
		if((nums1.length + nums2.length)%2 == 0) {
			ifEven = true;
		}else {
			ifEven = false;
		}
		int i = 0;
		
		while(true) {
			
			// prevents the pointer from going out of bounds, and adds the next element to lastElementIsMedian. 
			if(nums1Front > nums1.length-1) {
				lastElementIsMedian[i] = nums2[nums2Front];
				i++;
				nums2Front++;
			}else if(nums2Front > nums2.length-1) {
				lastElementIsMedian[i] = nums1[nums1Front];
				i++;
				nums1Front++;
			}else {
				if(nums1[nums1Front] <= nums2[nums2Front]) {
					lastElementIsMedian[i] = nums1[nums1Front];
					i++;
					nums1Front++;
				}else {
					lastElementIsMedian[i] = nums2[nums2Front];
					i++;
					nums2Front++;
				}
			}	
			
			for(int x : lastElementIsMedian) {
				System.out.println(x);
			}
			System.out.println("Are there an even number of ints " + ifEven);
			System.out.println("++++++++++++++++++++++++++");
			
			
			if(nums1Front+nums2Front-1 >= middle) {
				if(ifEven) {
					return (double) (lastElementIsMedian[middle] + (double) lastElementIsMedian[middle-1])/2;
				}else {
					return lastElementIsMedian[middle];
				}
			}
			
		}// while
	}// find Median Sorted Arrays

}
