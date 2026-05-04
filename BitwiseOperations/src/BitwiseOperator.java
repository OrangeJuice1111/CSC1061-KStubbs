
public class BitwiseOperator {

	private static final int NUM_LIGHTS = 32;
	public static void main(String[] args) {
		
		boolean[] xmaslights = new boolean[NUM_LIGHTS];
		
		//Turn them all on
		for(int i = 0; i <NUM_LIGHTS; i ++) {
			xmaslights[i] = true;
		}
		for(int i = 0; i < NUM_LIGHTS; i ++) {
			System.out.printf("%-6b", xmaslights[i]);
		}
		System.out.println();
		
		//Turn them all off
		for (int i = 0; i < NUM_LIGHTS; i ++) {
			if(i % 2 == 0) {
				xmaslights[i] = false;
			}
		
		}
		for(int i = 0; i < NUM_LIGHTS; i ++) {
			System.out.printf("%-6b", xmaslights[i]);
		}
		System.out.println();
		
		
		
		int xmasBits = 0xFFFFFFFF;
		xmasBits = -1;
		//Both of these are the same thing
		
		//System.out.printf("%x", xmasBits);
		int mask = 1;
		for(int i = 0; i < NUM_LIGHTS; i++){
			System.out.printf("%-6b", NUM_LIGHTS);
			System.out.printf("%-6b", (xmasBits & mask) != 0);
			mask = mask << 1;//shift left once
			//mask = mask >> 2;//shift right twice
		}
		
		//Turn off all the even lights
		xmasBits = xmasBits & 0xAAAAAAAA;
		xmasBits &= 0xAAAAAAAA;
		
		mask = 1;
		for(int i = 0; i <NUM_LIGHTS; i++) {
			System.out.printf("%-6b", (xmasBits & mask) != 0);
		}
		//Flip all the swtiches
		xmasBits ^= 1;// xor switch using 1 switches everything 
		
		mask = 1;
		for(int i = 0; i <NUM_LIGHTS; i++) {
			System.out.printf("%-6b", (xmasBits & mask) != 0);
			mask = mask << 1;
		}
		System.out.println();
		
		//Reset all the switches by xor'ing itself
		xmasBits ^= xmasBits;    
		mask = 1;
		for(int i = 0; i <NUM_LIGHTS; i++) {
			System.out.printf("%-6b", (xmasBits & mask) != 0);
			mask = mask << 1;
		}
		System.out.println();
		
	}
	

}
