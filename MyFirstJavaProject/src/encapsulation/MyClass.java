package encapsulation;

public class MyClass {
	
	public static void main(String[] args)
	{
		MyPrivateClass myprivateclass = new MyPrivateClass();
		myprivateclass.setstr("Update string"); // set the string value by setter method  // write only
		System.out.println(myprivateclass.getstr());
		myprivateclass.printString();
	}

}
