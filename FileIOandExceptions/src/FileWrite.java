import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;

public class FileWrite {

	public static void main(String[] args) throws IOException {
		
		File myFile = new File("File Write Test");
		
		if(!myFile.exists()) {
			myFile.createNewFile();
		}
		
		FileOutputStream fileOut= new FileOutputStream(myFile.getName(), false);
		PrintWriter printer = new PrintWriter(fileOut);
		printer.print("The moon is full today");
		printer.println("\nIt is an auspicious day");
		//printer.flush();
		printer.close();
	}
	

}
