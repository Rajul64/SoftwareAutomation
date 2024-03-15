package accessModifier_qa;

public class QAClass {
	
	protected String str = "My String";
	
	protected void MyMethod()
	{
		System.out.println("QA class method");
	}
	
	/*
	 * private void MyMethod1() { MyMethod(); System.out.println(str); }
	 */

}
