import java.util.ArrayList;
import java.util.List;

public class BreakStatement {

	public static void main(String[] args) {
		int[][] intArray = {{1,2,3},
				{4,5,6},
				{7,8,9}
	};
		
		
		List<Integer> intList = new ArrayList<>();
		
		intList.add(Integer.valueOf(1));
		intList.add(3);
		intList.add(2);
		intList.add(5);
		intList.add(4);
		
		for(int i = 0; i < intList.size();i++) {
			System.out.println(intList.get(i));
		}
		
		//for each loop
		for (int x: intList) {
			System.out.println(x);
		}
		
		int index = findIndex(intList, 3);
		System.out.println("Found at index: " + index);
		
		
		int rowIndex = -1;
		int colIndex = -1;
		for (int i = 0; i < intArray.length; i++) {
			boolean found = false;
			for(int j = 0; j < intArray[i].length; j++) {
				if(intArray[i][j] == 8) {
					rowIndex = i;
					colIndex= j;
					found = true;
					break;
				}
			}
			if(found) {
				break;
			}
		}
		System.out.println("Row = " + rowIndex + " Column = " + colIndex);
		
		
		int[] arr = {1,2,3,4,5,6,7,8,9,10};
		for (int i = 0; i < 10; i++) {
			System.out.println("Start of iteration");
			if(arr[i] %2 > 0) {
				continue;//means to continue with the other iterations
			}
			System.out.println("");
			System.out.println("Print something...");
		}
		
	}
	
	public static int findIndex(List<Integer> ints, int num) {
		int index = -1;
		for(int i = 0; i < ints.size();i++) {
			if(num == ints.get(i)) {
				index = i;
				break;
		}
		
	}
	return index;
	}
}