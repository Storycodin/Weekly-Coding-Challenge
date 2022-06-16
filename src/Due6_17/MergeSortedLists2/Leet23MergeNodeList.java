package Due6_17.MergeSortedLists2;

import java.util.PriorityQueue;
import java.util.Queue;

/*
 *answer to leetcode https://leetcode.com/problems/merge-k-sorted-lists/ 
 * 
 */

// does not work here, but does work on leetcode. I don't know why.
public class Leet23MergeNodeList {
	public ListNode mergeKLists(ListNode[] lists) {
        // use a heap to organize the list
		
		Queue<ListNode> heap = new PriorityQueue<>((a,b)->a.val - b.val);
	      
		for (ListNode node : lists) {
			if(node == null) continue;
			
			heap.add(node);
		}//for
		
		ListNode dummy = new ListNode();
		ListNode cur = dummy;
		
		while(!heap.isEmpty()) {
			ListNode top = heap.poll();
			cur.next = top;
			cur = cur.next;
			if(top.next != null) {
				heap.add(top.next);
			}// if
		}// while
		
		return dummy.next;
	}
}
