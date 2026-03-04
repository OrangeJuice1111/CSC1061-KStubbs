package csc1060j.MyHashMap;

import java.util.Map;

public class MyHashMapTest {

	public static void main(String[] args) {
		Map<String, Integer> map = new MyHashMap();
		
		map.put("3", 3);
		map.put("5", 5);
		map.put("1", 1);

		
		System.out.println("Entries in map");
		for ( String key: map.keySet()) {
			System.out.print(key + ' ');
		}
		System.out.println();
		
		map.remove("5");
		System.out.println("after remove");
		System.out.println("Entries in map");
		for ( String key: map.keySet()) {
			System.out.print(key + ' ');
		}
		System.out.println();
		
	}

}
