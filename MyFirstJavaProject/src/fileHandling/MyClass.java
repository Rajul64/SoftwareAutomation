package fileHandling;

import java.io.File;
import java.io.IOException;

public class MyClass {

	public static void main(String[] args) {
		
		File file = new File("MyFile.txt");
		
		if(!file.exists())
		{
			try{
				file.createNewFile();
		}catch(IOException e)
		{
			e.printStackTrace();
		}
		}
	}
}