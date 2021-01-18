package q1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class JavaSortExample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Integer>  list= new ArrayList<Integer>();
		Scanner sc= new Scanner(System.in);
		System.out.print("Enter the size of list : ");
		int size = sc.nextInt();
		
		System.out.print("\nEnter the List Elements");
		for(int i=0; i<size; i++) {
			list.add(sc.nextInt());
		}
		
		System.out.print("\nElements Before Sorting : ");
		for(int i=0; i<size; i++) {
			System.out.print(list.get(i) + " ");
		}
		Collections.sort(list);
		System.out.print("\nElements After Sorting : ");
		for(int i=0; i<size; i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
