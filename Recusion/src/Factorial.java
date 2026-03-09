
public class Factorial {

	public static void main(String[] args) {

		int num = 3;
		System.out.println("Factorial of " + num + " is " + factorial(num));
		
		
	}

	private static int factorial(int n) {
		if( n == 0) {
			return 1;
		}
		int product = n * (n-1);
		return product;
	}

}
