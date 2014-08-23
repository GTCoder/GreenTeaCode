package javademo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ComparatorDemo {

	public static void main(String[] args) {
		Comparator<Integer> comp = new Comparator<Integer>() {
			// The name of the override method is compare(), NOT compareTo()!!!
			@Override
			public int compare(Integer i1, Integer i2) {
				if (i1 > i2) {
					return 1;
				} else if (i1 == i2) {
					return 0;
				} else {
					return -1;
				}
			}
		}; // Don't forget this semicolon!

		List<Integer> list = new ArrayList<Integer>();
		list.add(8);
		list.add(6);
		list.add(4);
		list.add(7);
		list.add(3);

		Collections.sort(list, comp);

		for (Integer i : list) {
			System.out.println(i);
		}

	}

}
