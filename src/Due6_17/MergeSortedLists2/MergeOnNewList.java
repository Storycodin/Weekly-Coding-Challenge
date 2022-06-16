package Due6_17.MergeSortedLists2;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

/*
 * 2) Merge Sorted Lists
You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
Merge all the linked-lists into one sorted linked-list and return it.

Example1:
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

Example2:
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

 * */


// run with example given
public class MergeOnNewList {
	public static void main(String[] args) {

		ArrayList<LinkedList<Integer>> all = new ArrayList<LinkedList<Integer>>();

		LinkedList<Integer> test1 = new LinkedList<Integer>();
		test1.add(1);
		test1.add(4);
		test1.add(5);
		all.add(test1);

		LinkedList<Integer> test2 = new LinkedList<Integer>();
		test2.add(1);
		test2.add(3);
		test2.add(4);
		all.add(test2);

		LinkedList<Integer> test3 = new LinkedList<Integer>();
		test3.add(2);
		test3.add(6);
		all.add(test3);
//		[[1,4,5],[1,3,4],[2,6]]
//		[1,1,2,3,4,4,5,6]
		
		 LinkedList<Integer> answer = sortList(all);
		 System.out.println(answer);
		
	}//main
	

	public static LinkedList<Integer> sortList(List<LinkedList<Integer>> all) {
		Iterator<LinkedList<Integer>> iter = all.iterator();
		LinkedList<Integer> sorted = new LinkedList<Integer>();
	
	
		// for each list on the list
		while (iter.hasNext()) {
			Iterator<Integer> unordered = (iter.next()).iterator();
			
			
			// for each int in on the list
			while (unordered.hasNext()) {
				// just copy the first list
				if(sorted.size() == 0 ) {
					while (unordered.hasNext()) {
						sorted.add(unordered.next());
					}
					
					break;
				}//if
				
				intsInOrder(sorted, unordered.next());
				
				
			}// inner while
		}// outer while
		return sorted;
	}// sortList
	
	public static void intsInOrder (LinkedList<Integer> sorted, int unsortedInt) {
		
//		int middle = sorted.size()/2;
//		System.out.println("middle of sorted " + middle);
		
		for (int i = 0; i <= sorted.size(); i++) {
			if(i == sorted.size()) {
				sorted.add(i, unsortedInt);
				break;
			}
				
				
				
			if(unsortedInt >= sorted.get(i)) {
			}else {
				sorted.add(i, unsortedInt);
				break;
			}
		}
	}
}
 