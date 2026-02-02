import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileRead {

	public static void main(String[] args) throws FileNotFoundException {
		
		File myFile = new File("File Write Test");
		Scanner input = null;

		try {
			input = new Scanner(myFile);
		}
		catch (FileNotFoundException e) {
			System.out.println("Got File Not Found Exception");
			System.exit(-1);
		}
		
		while (input.hasNextLine()) {
			String line = input.nextLine();
			System.out.println(line);
		}
		
		int[] numbers = {1,2,3};
		try {
		addOne(numbers,4);
		}
		catch (Exception e) {
			System.out.println(e.getMessage());
			System.exit(-1);
		}
	}

	public static void addOne(int[] nums, int index) {
		if (index >= nums.length) {
			throw new ArrayIndexOutOfBoundsException("Index" + index + 
					"exceeds length of array" + nums.length);
		}
		nums[index]++;
	}
}
