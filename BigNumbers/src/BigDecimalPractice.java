import java.math.BigDecimal;

public class BigDecimalPractice {

	public static void main(String[] args) {
		
		double num = 0.1;
		
		double ans = num * num;
		
		BigDecimal ans1 = BigDecimal.valueOf(num).multiply(BigDecimal.valueOf(num));

		System.out.println("The answer is " + ans);
		System.out.println("The answer is " + ans1);
	}

}
