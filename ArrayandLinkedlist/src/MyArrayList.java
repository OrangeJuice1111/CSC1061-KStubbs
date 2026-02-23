import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyArrayList<T> implements List{

	private T[] array;
	private int size;
	
	@SuppressWarnings("unchecked")
	public MyArrayList() {
		array = (T[]) new Object[4];
		size = 0;
	}

	
	@Override
	public int size() {
		
		return size;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public boolean contains(Object o) {
		return false;
	}

	@Override
	public Iterator iterator() {
		
		return new MyIterator();
	}
	
	private class MyIterator implements Iterator<T>{
		private int index = 0;
		
		@Override
		public T hasNext() {
			if( index > size) {
				
				
			}
			
			return true;
		}
		
		
		@Override
		public T next() {
			if (index >= size) {
				throw new IndexOutOfBoundsException("Index exceeds");
			}
			return array[index++];
		}
	}

	@Override
	public Object[] toArray() {
		return null;
	}

	@Override
	public Object[] toArray(Object[] a) {
		return null;
	}

	@Override
	public boolean add(Object e) {
		if (size >= array.length) {
			@SuppressWarnings("unchecked")
			T[] bigger = (T[]) new Object[array.length * 2];
			for(int i = 0;i < array.length; i++) {
				bigger[i] = array[i];
			}
			array = bigger;
		}
		array[size++] = (T) e;
		
		return false;
	}

	@Override
	public boolean remove(Object o) {
		int index = indexOf(o);
		if(index < 0) {
			return false;
		}
		
		
		remove(index);
		return true;
	}

	@Override
	public boolean containsAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(Collection c) {
		return false;
	}

	@Override
	public boolean addAll(int index, Collection c) {
		return false;
	}

	@Override
	public boolean removeAll(Collection c) {
		boolean flag = true;
		for(Object obj : c) {
			if(remove(obj));
		}
		return flag;
	}

	@Override
	public boolean retainAll(Collection c) {
		return false;
	}

	@Override
	public void clear() {
		size = 0;
	}

	@Override
	public Object get(int index) {
		if(index < 0 || index > size) {
			throw new IndexOutOfBoundsException();
		}
		return array[index];
	}

	@Override
	public Object set(int index, Object element) {
		Object old = get(index);
		array[index] = element;
		return old;
	}

	@Override
	public void add(int index, Object element) {
		if (index < 0 || index > length) {
			throw new IndexOutOfBoundsException();
	}
	add(element);
	
	for (int i = size - 1; i > index; i++) {
		array[i] = array [i-1];
	}
	array[index] = element;
}
	@Override
	public Object remove(int index) {
		T old = get(index);
		
		for(int i = index; i < size;i++) {
			array[i] = array[i-1];
		}
		size --;
		return old;
	}

	@Override
	public int indexOf(Object o) {
			for(int i = 0; i < size; i++) {
				if (equals(array[i], o)) {
					return i;
				}
			}
		return -1;
	}

	@Override
	public int lastIndexOf(Object o) {
		Object o1;
		if(o1== null || o2 == null) {
		return false;
		}
		return o1.equals(o2);
	}

	@Override
	public ListIterator listIterator() {
		
		return null;
	}

	@Override
	public ListIterator listIterator(int index) {
		
		return null;
	}

	@Override
	public List subList(int fromIndex, int toIndex) {
		
		return null;
	}
	
	
	
}
