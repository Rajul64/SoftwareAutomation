package polymorphism;

public class MethodOverloadingClass {
	
	public void myMethod1()
	{
		System.out.println("Empty method1");
	}
	
	public void myMethod1(int i, String s)
	{
		System.out.println(i + s);
	}
	
	public void myMethod1(int a, int b)
	{
		System.out.println(a+b);
	}

}
