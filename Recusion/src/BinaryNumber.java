
public class BinaryNumber {

	public static void main(String[] args) {
		displayBinary(13);
		
	}

	private static void displayBinary(int value) {
		if(value <= 0) {
			return;
		}
		displayBinary(value/2);
		System.out.print(value % 2);
	}

}
