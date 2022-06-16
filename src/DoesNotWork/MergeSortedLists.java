package DoesNotWork;

import java.util.LinkedList;

public class MergeSortedLists {
	/*
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example 1:
Input: lists = [[1,4,5],[1,3,4],[2,6]]
Output:[1,1,2,3,4,4,5,6]
Explanation: The linked-lists are:
[
1->4->5,
1->3->4,
2->6
]
merging them into one sorted list:
1->1->2->3->4->4->5->6

Example 2:
Input: lists= []
Output: []

Example3:
Input: lists = [[]]
Output: []

Constraints:
k == lists.length
0 <= k <= 104
0 <= lists[i].length <= 500
-104 <= lists[i][j] <= 104
lists[i] is sorted in ascending order.
The sum of lists[i].length will not exceed 104.

	 */
	
	static int iteration = 0;
	
	public static void main(String[] args) {
	LinkedList<Integer> test = new LinkedList<Integer>();
	test.add(1);
	test.add(4);
	test.add(5);
	
	test.add(1);
	test.add(3);
	test.add(4);
	
	test.add(2);
	test.add(6);
//	[[1,4,5],[1,3,4],[2,6]]
//	[1,1,2,3,4,4,5,6]
	
	mergeSort(test);
	
	
	for(Integer x : test) {
		System.out.print(x + "  ");
	}
	
	}
	
	public static void printList(LinkedList<Integer> toPrint, String title) {
		System.out.println("\n\n++++++++++++++++++++" + title + "++++++++++++++++++++\n");
		for(Integer x : toPrint) {
			System.out.print(x + "  ");
		}
	}
	
	// call merge and split the list in two peaces
	public static void mergeSort (LinkedList<Integer> sort){
		printList(sort, "starting");
		mergeSort(sort, new LinkedList<Integer>(), 0, sort.size()-1);
		printList(sort, "ending");
	}
	
	// if left >= right return
	// other wise split the list again,
	public static void mergeSort (LinkedList<Integer> sort, LinkedList<Integer> temp, int leftStart, int rightEnd) {
		if(leftStart >= rightEnd) {
			return;
		}
		int middle =(leftStart + rightEnd)/2;
		
		mergeSort(sort,  temp, leftStart, middle);
		mergeSort(sort, temp, middle +1, rightEnd);
		mergeHalves(sort, temp, leftStart,rightEnd);
	}
	
	// then merge them together in order, moving right or left pointer one each time a new the lower is found.
	public static void mergeHalves(LinkedList<Integer> sort, LinkedList<Integer> temp, int leftStart, int rightEnd) {
		int leftEnd = (leftStart + rightEnd)/2;
		int rightStart = leftEnd + 1;
		int size = rightEnd - leftStart + 1;
		
		int left = leftStart;
		int right = rightStart;
		int index = leftStart;
		
		while (left <= leftEnd && right <= rightEnd){
			if (sort.get(left)<= sort.get(right)) {
				temp.add(sort.get(left));
				left++;
			} else {
				temp.add(sort.get(right));
				right++;
			}
		}//while
		
		
		
		iteration++;
		String tempTitle = "Temp " + iteration;
		printList(sort, tempTitle);
		
		int start = leftStart;
		int end = rightEnd;
		
		for(int i = 0; i >=temp.size(); i++) {
			sort.set(leftStart, temp.get(i));
			start++;			
		}
		
		
		String title = "sort " + iteration;
		printList(sort, title);
		
	}

}// class


