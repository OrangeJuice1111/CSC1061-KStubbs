import java.util.ArrayDeque;
import java.util.Deque;

public class Fibonacci {

	public static void main(String[] args) {
		System.out.println("The answer is " + FibonacciIterative(6));
		

	}

	private static int Fibonacci(int term) {
		if( term < 2) {
			return term;
		}
		return(Fibonacci(term -1) + Fibonacci(term - 2));
		
	}

	private static int FibonacciIterative(int term) {
		if( term < 2) {
			return term;
		}
		int term2 = 0;
		int term1 = 1;
		
		int answer = 0;
		for(int i = 2; i < term; i ++) {
			answer = term1 + term2;
			term2 = term1;
			term1 = answer;
		}
		return answer;
	}
	
	public static int fibonacciStack(int term) {
		if(term < 2) {
			return term;
		}
		Deque<Integer> stack = new ArrayDeque<>();
		stack.push(0);
		stack.push(1);
		int answer = 0;
		
		for(int i = term; i <= term; i++) {
			int term1 = stack.pop();
			int term2 = stack.pop();
			answer = term1 + term2;
			stack.push(term2);
			stack.push(term1);
			stack.push(answer);
		}
		return answer;
	}
}
