package exceptionHandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class MyClass {

	public static void main(String[] args) throws FileNotFoundException  {
		
		File file = new File("C://file.txt");
		try {
//			FileReader fr = new FileReader(file); 
			System.out.println("randome exception");
			throw new MyException();
			
		}catch(MyException e)
		{
			e.printException();
			e.printStackTrace();
		}
		System.out.println("After Exception");
	}
		
/*		File file = new File("C://file.txt");
		FileReader fr = null;
		try {
			fr = new FileReader(file);
		}catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}finally {
			try{
				if(fr != null) {
				fr.close();
				}
			}catch(IOException e)
			{
				e.printStackTrace();
			}
		System.out.println("After exception");
		
		int array [] = {1,2,3};
		System.out.println(array[2]);
		}

	}*/

}
