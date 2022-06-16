package GibToolbox;

import java.util.LinkedList;

public class Print {
	public static void printList(LinkedList<Integer> toPrint, String title) {
		System.out.println("\n\n++++++++++++++++++++" + title + "++++++++++++++++++++\n");
		for(Integer x : toPrint) {
			System.out.println(x + "  ");
		}
		System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
	}// printList
}
