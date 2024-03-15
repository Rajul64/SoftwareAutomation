package inheritance;

public class MySuperClass {
	
	String superstr = "superClassString";
	
	String commonStr = "super common string";
	
	public MySuperClass(int i)
	{
		System.out.println("My super class constructor");
		System.out.println("Single parametrized constructor value = "+i);
	}
	
	public void MySuperClassMethod()
	{
		System.out.println("Super class method");
	}
	
	public void commonMethod()
	{
		System.out.println("super class common method");
	}

}
