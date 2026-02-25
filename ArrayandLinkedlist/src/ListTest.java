import java.util.Iterator;
import java.util.List;

public class ListTest {
	
	public static void main(String[] args) {
		
		List<Integer> myArrList = new MyArrayList<>();
		
		myArrList.add(1);
		myArrList.add(2);
		myArrList.add(3);
		myArrList.add(4);
		myArrList.add(5);
		
		
		//if(myArrList instanceof  )
		System.out.println();
		
		for(int i = 0; i <myArrList.size(); i++) {
			System.out.print(myArrList.get(i) + " ");
		}
		System.out.println();
	
		for(Integer num : myArrList) {
			System.out.print(num + " ");
		}
		System.out.println();
	
	
		Iterator<E> iter = myArrList.iterator();
		while(iter.hasNext()) {
			Integer ans = (Integer)iter.next();
			System.out.print(ans + " ");
		}
		System.out.println();
		
		
		//test linked list
		
		List<Integer> ll = new MyDoubleLinkedList<>();
		ll.add(6);
		ll.add(7);
		ll.add(8);
		ll.add(9);
		ll.add(10);
		
		// Traverse LinkedList
		
		for(int i = 0; i < ll.size();i++) {
			System.out.print(ll.get(i));
			
			iter = ll.iterator();
			while (iter.hasNext());{
				System.out.println(iter.next() + " ");
			}
			System.out.println();
			
			for(Integer x : ll) {
				System.out.print(x + " ");
				
			}
			System.out.println();
		}
	}

	
	
}
