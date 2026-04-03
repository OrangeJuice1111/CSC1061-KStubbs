package edu.frcc.csc1060j.MyTreeSet;

public class MyTreeSetTest {

	public static void main(String[] args) {
		MyTreeSet<Integer> set = new MyTreeSet<>();
		
		set.add(15);
		set.add(14);
		set.add(13);
		set.add(12);
		set.add(11);
		set.add(10);
		set.add(9);
		set.add(8);
		set.add(7);
		set.add(6);
		set.add(5);
		set.add(4);
		set.add(3);
		set.add(2);
		set.add(1);
		
		System.out.println("Height of tree :" + set.getTreeHeight());
		
		for(Integer value : set) {
			System.out.print(value + " ");
		}
		System.out.println();

	}

}
