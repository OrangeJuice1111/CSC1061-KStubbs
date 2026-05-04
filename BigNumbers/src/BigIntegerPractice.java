import java.math.BigInteger;

public class BigIntegerPractice {

	public static void main(String[] args) {
		
		int n = 4500;
		BigInteger ans = BigInteger.ONE;
		 for(int i = n; i > 0; i--) {
			 ans = ans.multiply(BigInteger.valueOf(i));
		 }
		 
		 System.out.println("The answer is " + ans);
	}

}
