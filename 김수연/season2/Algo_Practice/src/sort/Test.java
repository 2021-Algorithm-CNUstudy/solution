package sort;

import java.util.*;

public class Test {
	public static void main(String[] args) {
		Integer[] arr = {4, 2, 1, 8, 9};
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
		Arrays.sort(arr, Comparator.reverseOrder());
		System.out.println(Arrays.toString(arr));
		
		List<Integer> list = new ArrayList<>();
		
		list.add(8);
		list.add(1);
		list.add(9);
		list.add(3);
		System.out.println(list);
		
		Collections.sort(list);
		System.out.println(list);
		
		Collections.reverse(list);
		System.out.println(list);
	}
}
