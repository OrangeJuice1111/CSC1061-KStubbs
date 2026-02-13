import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ReverseList <E extends Comparable<E>>{
	//says if E is not comparable i dont want it
	
	private List<E> list = new LinkedList<E>();//linkedlist would be better
	//for adding to the beginning of a list
	
	public void add(E input) {
		list.add(0, input);
	}
	
	public List<E> getList(){
		return list;
	}
	
	public int size() {
		return list.size();
	}
	
	public E get(int index) {
		return list.get(index);
	}

}
