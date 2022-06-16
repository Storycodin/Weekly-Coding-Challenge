package DoesNotWork;

import java.util.ArrayList;
import java.util.LinkedList;

public class MergeLists {
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

		
		LinkedList<Integer> sorted = new LinkedList<Integer>();	
		// for each linked list
		for(int i = 0; i<=all.size()-1; i++) {
			int pointerL1 = 0;
			int sortedPointer = 0;
			System.out.println("===================on list " + i);

			// for each element on the list
			for(int y = 0; y<=all.get(i).size()-1; y++) {
				if(sorted.size() == 0 ) {
					sorted.add(all.get(i).get(pointerL1));
					pointerL1++;
					y++;
				}//if
					System.out.println("At sorted Pointer 1 " + sortedPointer);
				// Compare to each element on sorted
				for (int u = 0; u <= sorted.size(); ++u) {
					System.out.println("At sorted Pointer  2 " + sortedPointer);
					System.out.println(sorted.get(sortedPointer));
					System.out.println();
					
					
					System.out.println("At pointer 1 " + pointerL1);
					System.out.println(all.get(i).get(pointerL1));
					System.out.println();
					
					if (sorted.get(sortedPointer) <= all.get(i).get(pointerL1)) {
						System.out.println("true");
						if(++sortedPointer < sorted.size()) {
							sortedPointer++;
						}else {
							System.out.println("false");
							sorted.add(sortedPointer, all.get(i).get(pointerL1));
							pointerL1++;
							sortedPointer = 0;
						}
					}else {
						System.out.println("false");
						sorted.add(sortedPointer, all.get(i).get(pointerL1));
						pointerL1++;
						sortedPointer = 0;
					}
					
					
				}
				
				System.out.println("===================on element " + y);
				printList(sorted, "sorted");
			}
		}// for loop
		

		for(Integer y : sorted) {
			System.out.print(y + "  ");				
		}
	
	}
	
	public static void printList(LinkedList<Integer> toPrint, String title) {
		System.out.println("\n\n++++++++++++++++++++" + title + "++++++++++++++++++++\n");
		for(Integer x : toPrint) {
			System.out.println(x + "  ");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}
}
