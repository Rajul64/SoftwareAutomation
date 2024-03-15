package accessModifier_Dev;

import accessModifier_qa.QAClass;

public class MyClass extends QAClass {
	
	public static void main(String[] args)
	{
		MyClass myclass = new MyClass();
		myclass.MyMethod1();
	}
	
	public void MyMethod1()
	{
		MyMethod();
		System.out.println(str);
	}

}
