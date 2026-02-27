package edu.frcc.csc1061j.PlaylistManager;

import com.sun.tools.javac.util.List;

import java.util.List;

public class PlaylistManager {

	public static void main(String[] args) {
		List<Integer> ll = new MyDoubleLinkedList<>();
		ll.add(1);
		ll.add(2);
		
		for(Integer x: ll) {
			System.out.println(x + " ");
		}

	}

}
