package inheritance;

public class MyClass {
	
	public static void main(String[] args)
	{
		MySubClass mySubclass = new MySubClass(10);
		mySubclass.MySuperClassMethod();
		System.out.println(mySubclass.superstr);
		mySubclass.SubClassMethod();
		mySubclass.printCommonString();
		mySubclass.printCommonMethod();
		
	}

}
