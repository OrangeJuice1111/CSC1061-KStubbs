
public class Fibonacci {

	private static long recursioncnt = 0;
	private static long[] termArray = new long[200];
	public static void main(String[] args) {
		
		int n = 50; 
		
		System.out.println("The " + n + "th term is " + fibRecursive(n));
		System.out.println(recursioncnt);
	}

	public static long fibRecursive(int n) {
		if( n < 2) {
			return n;
		}
		recursioncnt++;
		
		long ans = (fibRecursive(n -1) + fibRecursive(n - 2));
		return ans;
	}
	
	public static long fibDynamic(int n) {
		if (n <= 0) {
			return n;
		}
		
		if(termArray[n] > 0) {
			return termArray[n];
		}
		
		long ans = (fibRecursive(n -1) + fibRecursive(n - 2));
		termArray[n] = ans;
		return ans;
	}

	
	public static long fibIterative(int n) {
		if(n <= 1) {
			return n;
		}
		long prev1 = 1;
		long prev2 = 0;
		
		long ans = 0;
		for(long i = 2; i <= n; i++) {
			ans = prev1 + prev2;
			prev2 = prev1;
			prev1 = ans;
		}
		return ans;
	}
	
}
