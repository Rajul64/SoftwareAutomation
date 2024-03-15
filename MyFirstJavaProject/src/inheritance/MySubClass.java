package inheritance;

public class MySubClass extends MySuperClass {
	
	String commonStr = "sub common string";
	
	public MySubClass(int i)
	{
		super(i);
		System.out.println("My sub class constructor");
	}
	
	public void SubClassMethod()
	{
		System.out.println("Sub class method");
	}
	
	public void printCommonString()
	{
		System.out.println(commonStr);
		System.out.println(super.commonStr);
	}
	
	public void commonMethod()
	{
		System.out.println("sub class common method");
	}
	
	public void printCommonMethod()
	{
		commonMethod();
		super.commonMethod();
	}

}
