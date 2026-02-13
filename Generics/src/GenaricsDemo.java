
public class GenaricsDemo {

	public static void main(String[] args) {
		
		ReverseList<Integer> list1 = new ReverseList<>();
		
		list1.add(1);
		list1.add(2);
		list1.add(3);
		
		
		for(int i = 0; i < list1.size(); i ++) {
			System.out.print(list1.get(i) + " ");
		}
		System.out.println();
		
		
		ReverseList<Apple> apples = new ReverseList<>();
	}

}
