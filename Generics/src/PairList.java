import java.util.LinkedList;
import java.util.List;

public class PairList<T1 extends Comparable<T1>, T2 extends Cloneable> {

	private List<T1> list1 = new LinkedList<T1>();
	private List<T2> list2 = new LinkedList<T2>();
}
